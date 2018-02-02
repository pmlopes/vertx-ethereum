package xyz.jetdrone.vertx.jsonrpc;

import io.vertx.codegen.annotations.DataObject;
import io.vertx.core.MultiMap;
import io.vertx.core.http.HttpClientOptions;
import io.vertx.core.json.JsonObject;

@DataObject(generateConverter = true)
public class JsonRPCOptions extends HttpClientOptions {

  private String host;
  private int port;
  private String path;
  private boolean useSSL;
  private MultiMap headers;

  public JsonRPCOptions() {
    super();
  }

  public JsonRPCOptions(JsonObject other) {
    super(other);
    JsonRPCOptionsConverter.fromJson(other, this);
  }

  public String getHost() {
    return host;
  }

  public JsonRPCOptions setHost(String host) {
    this.host = host;
    return this;
  }

  public int getPort() {
    return port;
  }

  public JsonRPCOptions setPort(int port) {
    this.port = port;
    return this;
  }

  public MultiMap getHeaders() {
    return headers;
  }

  public JsonRPCOptions setHeaders(MultiMap headers) {
    this.headers = headers;
    return this;
  }

  public String getPath() {
    return path;
  }

  public JsonRPCOptions setPath(String path) {
    this.path = path;
    return this;
  }

  public boolean isUseSSL() {
    return useSSL;
  }

  public JsonRPCOptions setUseSSL(boolean useSSL) {
    this.useSSL = useSSL;
    return this;
  }

  public JsonObject toJSON() {
    JsonObject json = new JsonObject();
    JsonRPCOptionsConverter.toJson(this, json);
    return json;
  }

  @Override
  public String toString() {
    return toJSON().encodePrettily();
  }
}
