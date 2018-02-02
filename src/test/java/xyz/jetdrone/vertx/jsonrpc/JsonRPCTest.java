package xyz.jetdrone.vertx.jsonrpc;

import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.unit.Async;
import io.vertx.ext.unit.TestContext;
import io.vertx.ext.unit.junit.VertxUnitRunner;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import xyz.jetdrone.vertx.jsonrpc.impl.JsonRPCException;

import static xyz.jetdrone.vertx.jsonrpc.JsonRPC.*;

@RunWith(VertxUnitRunner.class)
public class JsonRPCTest {

  private static Vertx vertx;

  private JsonRPC rpc;
  private JsonRPCTransportMock mock;

  @BeforeClass
  public static void setup() {
    vertx = Vertx.vertx();
  }

  @AfterClass
  public static void teardown() {
    vertx.close();
  }

  @Before
  public void init() {
    mock = new JsonRPCTransportMock(vertx);
    rpc = JsonRPC.create(mock);
  }


  @Test
  public void testRpcCallWithPositionalParameters(TestContext ctx) {
    final Async test = ctx.async();

    // fixtures
    mock.setExpectation(req -> {
      return new JsonObject()
        .put("jsonrpc", "2.0")
        .put("result", 19)
        .put("id", req.getValue("id"));
    });

    rpc.request(wrap("subtract", new JsonArray().add(42).add(23)), res -> {
      ctx.assertTrue(res.succeeded());
      ctx.assertEquals(19, res.result().getInteger("result"));
      test.complete();
    });
  }

  @Test
  public void testRpcCallWithNamedParameters(TestContext ctx) {
    final Async test = ctx.async();

    // fixtures
    mock.setExpectation(req -> {
      return new JsonObject()
        .put("jsonrpc", "2.0")
        .put("result", -19)
        .put("id", req.getValue("id"));
    });

    rpc.request(wrap("subtract", new JsonObject().put("subtrahend", 23).put("minuend", 42)), res -> {
      ctx.assertTrue(res.succeeded());
      ctx.assertEquals(-19, res.result().getInteger("result"));
      test.complete();
    });
  }

  @Test
  public void testRpcNotification(TestContext ctx) {
    final Async test = ctx.async();

    // fixtures
    mock.setExpectation(req -> {
      return null;
    });

    rpc.notify(wrap("update", new JsonArray().add(1).add(2).add(3).add(4)), res -> {
      ctx.assertTrue(res.succeeded());
      test.complete();
    });
  }

  @Test
  public void testRpcSimpleNotification(TestContext ctx) {
    final Async test = ctx.async();

    // fixtures
    mock.setExpectation(req -> {
      return null;
    });

    rpc.notify(wrap("foobar"), res -> {
      ctx.assertTrue(res.succeeded());
      test.complete();
    });
  }

  @Test
  public void testRpcNonExistingMethod(TestContext ctx) {
    final Async test = ctx.async();

    // fixtures
    mock.setExpectation(req -> {
      return new JsonObject()
        .put("jsonrpc", "2.0")
        .put("error", new JsonObject()
          .put("code", -32601)
          .put("message", "Method not found"))
        .put("id", req.getValue("id"));
    });

    rpc.request(wrap("foobar"), res -> {
      ctx.assertFalse(res.succeeded());
      ctx.assertEquals(-32601, ((JsonRPCException) res.cause()).code());
      test.complete();
    });
  }
}
