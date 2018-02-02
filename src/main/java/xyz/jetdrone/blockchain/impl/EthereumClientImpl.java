package xyz.jetdrone.blockchain.impl;

import io.vertx.core.AsyncResult;
import io.vertx.core.Future;
import io.vertx.core.Handler;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import xyz.jetdrone.blockchain.EthereumClient;
import xyz.jetdrone.vertx.jsonrpc.JsonRPC;

import java.util.Objects;

public class EthereumClientImpl implements EthereumClient {

  static JsonObject wrap(String method, Object... args) {
    final JsonArray params = new JsonArray();
    for (Object o : args) {
      params.add(o);
    }
    return JsonRPC.wrap(method, params);
  }

  private final JsonRPC rpc;

  public EthereumClientImpl(JsonRPC rpc) {
    this.rpc = Objects.requireNonNull(rpc);
  }


  @Override
  public EthereumClient web3ClientVersion(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("web3_clientVersion"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient web3Sha3(String data, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("web3_sha3", data), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient netVersion(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("net_version"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient netListening(Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("net_listening"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient netPeerCount(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("net_peerCount"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethProtocolVersion(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_protocolVersion"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSyncing(Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_syncing"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethCoinbase(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_coinbase"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethMining(Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("eth_mining"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethHashrate(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_hashrate"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGasPrice(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_gasPrice"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethAccounts(Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_accounts"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethBlockNumber(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_blockNumber"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetBalance(String address, String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getBalance", address, block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetStorageAt(String address, String position, String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getStorageAt", address, position, block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetTransactionCount(String address, String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getTransactionCount", address, block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetBlockTransactionCountByHash(String hash, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getBlockTransactionCountByHash", hash), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetBlockTransactionCountByNumber(String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getBlockTransactionCountByNumber", block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetUncleCountByBlockHash(String hash, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getUncleCountByBlockHash", hash), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetUncleCountByBlockNumber(String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getUncleCountByBlockNumber", block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetCode(String address, String block, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_getCode", address, block), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSign(String address, String message, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_sign", address, message), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSendTransaction(JsonObject transaction, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_sendTransaction", transaction), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSendRawTransaction(String transaction, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_sendRawTransaction", transaction), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethCall(JsonObject transaction, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_call", transaction), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethEstimateGas(JsonObject transaction, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_estimateGas", transaction), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetBlockByHash(String hash, boolean full, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getBlockByHash", hash, full), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetBlockByNumber(String block, boolean full, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getBlockByNumber", block, full), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetTransactionByHash(String hash, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getTransactionByHash", hash), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetTransactionByBlockHashAndIndex(String hash, String pos, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getTransactionByBlockHashAndIndex", hash, pos), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetTransactionByBlockNumberAndIndex(String block, String pos, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getTransactionByBlockNumberAndIndex", block, pos), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetTransactionReceipt(String hash, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getTransactionReceipt", hash), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetUncleByBlockHashAndIndex(String hash, String pos, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getUncleByBlockHashAndIndex", hash, pos), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetUncleByBlockNumberAndIndex(String block, String pos, Handler<AsyncResult<JsonObject>> handler) {
    rpc.request(wrap("eth_getUncleByBlockNumberAndIndex", block, pos), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonObject("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetCompilers(Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_getCompilers"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethCompileLLL(String source, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_compileLLL", source), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethCompileSolidity(String source, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_compileSolidity", source), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethCompileSerpent(String source, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_compileSerpent", source), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethNewFilter(JsonObject filter, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_newFilter", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethNewBlockFilter(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_newBlockFilter"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethNewPendingTransactionFilter(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("eth_newPendingTransactionFilter"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethUninstallFilter(String filter, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("eth_uninstallFilter", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetFilterChanges(String filter, Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_getFilterChanges", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetFilterLogs(String filter, Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_getFilterLogs", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetLogs(JsonObject filter, Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_getLogs", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethGetWork(Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("eth_getWork"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSubmitWork(JsonArray work, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("eth_submitWork", work), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient ethSubmitHashrate(String hashrate, String id, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("eth_submitHashrate", hashrate, id), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient dbPutString(String dbname, String key, String value, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("db_putString", dbname, key, value), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient dbGetString(String dbname, String key, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("db_getString", dbname, key), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient dbPutHex(String dbname, String key, String value, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("db_putHex", dbname, key, value), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient dbGetHex(String dbname, String key, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("db_getHex", dbname, key), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhPost(JsonObject message, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("shh_post", message), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhVersion(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("shh_version"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhNewIdentity(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("shh_newIdentity"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhHasIdentity(String identity, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("shh_hasIdentity", identity), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhNewGroup(Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("shh_newGroup"), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhAddToGroup(String group, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("shh_addToGroup", group), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhNewFilter(JsonObject filter, Handler<AsyncResult<String>> handler) {
    rpc.request(wrap("shh_newFilter", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getString("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhUninstallFilter(String filterId, Handler<AsyncResult<Boolean>> handler) {
    rpc.request(wrap("shh_uninstallFilter", filterId), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getBoolean("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhGetFilterChanges(String filter, Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("shh_getFilterChanges", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }

  @Override
  public EthereumClient shhGetMessages(String filter, Handler<AsyncResult<JsonArray>> handler) {
    rpc.request(wrap("shh_getMessages", filter), request -> {
      if (request.failed()) {
        handler.handle(Future.failedFuture(request.cause()));
      } else {
        handler.handle(Future.succeededFuture(request.result().getJsonArray("result")));
      }
    });
    return this;
  }
}
