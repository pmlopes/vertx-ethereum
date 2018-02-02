package xyz.jetdrone.blockchain;

import io.vertx.codegen.annotations.Fluent;
import io.vertx.codegen.annotations.ProxyGen;
import io.vertx.codegen.annotations.VertxGen;
import io.vertx.core.AsyncResult;
import io.vertx.core.Handler;
import io.vertx.core.Vertx;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.serviceproxy.ServiceProxyBuilder;
import xyz.jetdrone.blockchain.impl.EthereumClientImpl;
import xyz.jetdrone.vertx.jsonrpc.JsonRPC;

@VertxGen
@ProxyGen
public interface EthereumClient {

  /**
   * The default service address.
   */
  String DEFAULT_ADDRESS = "xyz.jetdrone.blockchain.Ethereum";



  static EthereumClient create(JsonRPC rpc) {
    return new EthereumClientImpl(rpc);
  }

  /**
   * Method called to create a proxy (to consume the service).
   *
   * @param vertx   vert.x
   * @param address the address on the event bus where the service is served.
   * @return the proxy
   */
  static EthereumClient createProxy(Vertx vertx, String address) {
    return new ServiceProxyBuilder(vertx)
      .setAddress(address)
      .build(EthereumClient.class);
  }

  @Fluent
  EthereumClient web3ClientVersion(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient web3Sha3(String data, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient netVersion(Handler<AsyncResult<String>> handler);


  @Fluent
  EthereumClient netListening(Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient netPeerCount(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethProtocolVersion(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethSyncing(Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethCoinbase(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethMining(Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient ethHashrate(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGasPrice(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethAccounts(Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethBlockNumber(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetBalance(String address, String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetStorageAt(String address, String position, String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetTransactionCount(String address, String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetBlockTransactionCountByHash(String hash, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetBlockTransactionCountByNumber(String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetUncleCountByBlockHash(String hash, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetUncleCountByBlockNumber(String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetCode(String address, String block, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethSign(String address, String message, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethSendTransaction(JsonObject transaction, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethSendRawTransaction(String transaction, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethCall(JsonObject transaction, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethEstimateGas(JsonObject transaction, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethGetBlockByHash(String hash, boolean full, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetBlockByNumber(String block, boolean full, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetTransactionByHash(String hash, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetTransactionByBlockHashAndIndex(String hash, String pos, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetTransactionByBlockNumberAndIndex(String block, String pos, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetTransactionReceipt(String hash, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetUncleByBlockHashAndIndex(String hash, String pos, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetUncleByBlockNumberAndIndex(String block, String pos, Handler<AsyncResult<JsonObject>> handler);

  @Fluent
  EthereumClient ethGetCompilers(Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethCompileLLL(String source, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethCompileSolidity(String source, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethCompileSerpent(String source, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethNewFilter(JsonObject filter, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethNewBlockFilter(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethNewPendingTransactionFilter(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient ethUninstallFilter(String filter, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient ethGetFilterChanges(String filter, Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethGetFilterLogs(String filter, Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethGetLogs(JsonObject filter, Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethGetWork(Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient ethSubmitWork(JsonArray work, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient ethSubmitHashrate(String hashrate, String id, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient dbPutString(String dbname, String key, String value, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient dbGetString(String dbname, String key, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient dbPutHex(String dbname, String key, String value, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient dbGetHex(String dbname, String key, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient shhPost(JsonObject message, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient shhVersion(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient shhNewIdentity(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient shhHasIdentity(String identity, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient shhNewGroup(Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient shhAddToGroup(String group, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient shhNewFilter(JsonObject filter, Handler<AsyncResult<String>> handler);

  @Fluent
  EthereumClient shhUninstallFilter(String filterId, Handler<AsyncResult<Boolean>> handler);

  @Fluent
  EthereumClient shhGetFilterChanges(String filter, Handler<AsyncResult<JsonArray>> handler);

  @Fluent
  EthereumClient shhGetMessages(String filter, Handler<AsyncResult<JsonArray>> handler);
}
