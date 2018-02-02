package xyz.jetdrone.vertx.jsonrpc;

import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import xyz.jetdrone.vertx.jsonrpc.impl.transport.HTTPJsonRPC;

@VertxGen
public interface JsonRPCTransport {

  static JsonRPCTransport createHTTPTransport(Vertx vertx, JsonRPCOptions options) {
    return new HTTPJsonRPC(vertx, options);
  }

  void exchange(Buffer request, Handler<AsyncResult<Buffer>> handler);
}
