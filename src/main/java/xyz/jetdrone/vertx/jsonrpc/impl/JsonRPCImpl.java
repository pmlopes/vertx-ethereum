package xyz.jetdrone.vertx.jsonrpc.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonObject;
import xyz.jetdrone.vertx.jsonrpc.JsonRPC;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCTransport;

import java.util.UUID;

public class JsonRPCImpl implements JsonRPC {

  private final JsonRPCTransport transport;

  public JsonRPCImpl(JsonRPCTransport transport) {
    this.transport = transport;
  }

  private <T> void call(JsonObject request, Handler<AsyncResult<T>> handler) {
    final boolean isNotification = !request.containsKey("id");

    transport.exchange(request.toBuffer(), exchange -> {
      if (exchange.failed()) {
        handler.handle(Future.failedFuture(exchange.cause()));
      } else {
        if (isNotification) {
          // notifications do not reply
          handler.handle(Future.succeededFuture());
        } else {
          try {
            final JsonObject response = new JsonObject(exchange.result());

            if (response.containsKey("error")) {
              final JsonObject error = response.getJsonObject("error");
              handler.handle(Future.failedFuture(
                new JsonRPCException(
                  error.getInteger("code"),
                  error.getString("message"),
                  error.getValue("data"))));
            } else {
              if (!response.containsKey("id")) {
                handler.handle(Future.failedFuture("REQUIRED member 'id' is missing."));
              } else {
                if (!request.getValue("id").equals(response.getValue("id"))) {
                  handler.handle(Future.failedFuture("Member 'id' is not equal to request 'id'."));
                } else {
                  handler.handle(Future.succeededFuture((T) response));
                }
              }
            }
          } catch (RuntimeException e) {
            handler.handle(Future.failedFuture(exchange.cause()));
          }
        }
      }
    });
  }

  @Override
  public JsonRPC request(JsonObject request, Handler<AsyncResult<JsonObject>> handler) {
    if (!request.containsKey("id")) {
      request.put("id", UUID.randomUUID().toString());
    }

    call(request, handler);
    return this;
  }

  @Override
  public JsonRPC notify(JsonObject request, Handler<AsyncResult<Void>> handler) {
    if (request.containsKey("id")) {
      request.remove("id");
    }

    call(request, handler);
    return this;
  }
}
