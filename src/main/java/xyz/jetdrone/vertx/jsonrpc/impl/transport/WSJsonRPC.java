package xyz.jetdrone.vertx.jsonrpc.impl.transport;

import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.buffer.Buffer;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCTransport;

public class WSJsonRPC implements JsonRPCTransport {
  @Override
  public void exchange(Buffer request, Handler<AsyncResult<Buffer>> handler) {
    throw new RuntimeException("Not Implemented yet!");
  }
}
