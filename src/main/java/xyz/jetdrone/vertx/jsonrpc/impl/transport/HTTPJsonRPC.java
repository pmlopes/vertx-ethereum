package xyz.jetdrone.vertx.jsonrpc.impl.transport;

import io.vertx.core.*;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.http.HttpClient;
import io.vertx.core.http.HttpClientRequest;
import io.vertx.core.http.HttpMethod;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCOptions;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCTransport;

import java.util.Map;

public class HTTPJsonRPC implements JsonRPCTransport {

  private final HttpClient client;
  private final String path;

  private final MultiMap headers;

  public HTTPJsonRPC(Vertx vertx, JsonRPCOptions options) {
    boolean isSecure = options.isUseSSL();
    String host = options.getHost();
    int port = options.getPort();

    if (port == 0) {
      if (isSecure) {
        port = 443;
      } else {
        port = 80;
      }
    }

    client = vertx.createHttpClient(
      options
        .setSsl(isSecure)
        .setDefaultHost(host)
        .setDefaultPort(port));

    path = options.getPath() != null ? options.getPath() : "/";
    headers = options.getHeaders();
  }

  @Override
  public void exchange(Buffer buffer, Handler<AsyncResult<Buffer>> handler) {
    final HttpClientRequest request = client.request(HttpMethod.POST, path, resp -> {

      resp.exceptionHandler(t -> {
        handler.handle(Future.failedFuture(t));
        client.close();
      });

      resp.bodyHandler(body -> {
        if (resp.statusCode() != 200) {
          if (body == null || body.length() == 0) {
            handler.handle(Future.failedFuture(resp.statusMessage()));
          } else {
            handler.handle(Future.failedFuture(resp.statusMessage() + ": " + body.toString()));
          }
        } else {
          handler.handle(Future.succeededFuture(body));
        }
        client.close();
      });
    });

    request.exceptionHandler(t -> {
      handler.handle(Future.failedFuture(t));
      client.close();
    });

    if (headers != null) {
      for (Map.Entry<String, String> header : headers) {
        request.putHeader(header.getKey(), header.getValue());
      }
    }

    request
      .putHeader("User-Agent", "Vert.x/HttpClient")
      .putHeader("Content-Type", "application/json")
      .putHeader("Content-Length", Integer.toString(buffer.length()))
      .end(buffer);
  }
}
