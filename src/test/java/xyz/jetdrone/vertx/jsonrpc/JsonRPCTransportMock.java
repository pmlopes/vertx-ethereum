package xyz.jetdrone.vertx.jsonrpc;

import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.json.JsonObject;

import java.util.function.Function;

public class JsonRPCTransportMock implements JsonRPCTransport {

  private Vertx ctx;
  private Function<JsonObject, JsonObject> fn;

  JsonRPCTransportMock(Vertx ctx) {
    this.ctx = ctx;
  }

  public void setExpectation(Function<JsonObject, JsonObject> fn) {
    this.fn = fn;
  }

  @Override
  public void exchange(Buffer request, Handler<AsyncResult<Buffer>> handler) {
    try {
      final JsonObject response = fn.apply(new JsonObject(request));
      if (response == null) {
        ctx.runOnContext(v -> handler.handle(Future.succeededFuture()));
      } else {
        ctx.runOnContext(v -> handler.handle(Future.succeededFuture(response.toBuffer())));
      }
    } catch (RuntimeException e) {
      ctx.runOnContext(v -> handler.handle(Future.failedFuture(e)));
    }
  }
}
