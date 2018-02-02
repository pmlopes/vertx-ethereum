package xyz.jetdrone.vertx.jsonrpc;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.GenIgnore;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import xyz.jetdrone.vertx.jsonrpc.impl.JsonRPCImpl;

@VertxGen
public interface JsonRPC {

  String VERSION = "2.0";

  static JsonRPC create(JsonRPCTransport transport) {
    return new JsonRPCImpl(transport);
  }

  @Fluent
  JsonRPC request(JsonObject request, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  JsonRPC notify(JsonObject request, Handler<AsyncResult<Void>> handler);

  static JsonObject wrap(String method) {
    return new JsonObject()
      .put("jsonrpc", VERSION)
      .put("method", method);
  }

  static JsonObject wrap(String method, JsonArray params) {
    return wrap(method).put("params", params);
  }

  static JsonObject wrap(String method, JsonObject params) {
    return wrap(method).put("params", params);
  }
}
