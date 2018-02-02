package xyz.jetdrone.vertx.jsonrpc.impl;

import io.vertx.core.VertxException;
import io.vertx.core.json.JsonObject;

public class JsonRPCException extends VertxException {

  private final int code;
  private final Object data;

  private static String getMessageForCode(int code) {
    switch(code) {
      case -32700:
        return "Parse error";
      case -32600:
        return "Invalid Request";
      case -32601:
        return "Method not found";
      case -32602:
        return "Invalid params";
      case -32603:
        return "Internal error";
    }

    if (code >= -32099 && code <= -32000) {
      return "Server error";
    }

    return "Unknown error (" + code + ")";
  }

  public JsonRPCException(int code, String message, Object data) {
    super(message == null ? getMessageForCode(code) : message);
    this.code = code;
    this.data = data;
  }

  public JsonRPCException(int code, String message, Object data, Throwable cause) {
    super(message == null ? getMessageForCode(code) : message, cause);
    this.code = code;
    this.data = data;
  }

  public int code() {
    return code;
  }

  public Object data() {
    return data;
  }
}
