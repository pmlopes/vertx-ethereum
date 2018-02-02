package com.example.demo;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import xyz.jetdrone.blockchain.EthereumClient;
import xyz.jetdrone.vertx.jsonrpc.JsonRPC;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCOptions;
import xyz.jetdrone.vertx.jsonrpc.JsonRPCTransport;


public class MainVerticle extends AbstractVerticle {

   @Override
   public void start() throws Exception {
     EthereumClient eth = EthereumClient.create(
       JsonRPC.create(
         JsonRPCTransport.createHTTPTransport(vertx, new JsonRPCOptions()
           .setHost("localhost")
           .setPort(8545)
         )));


     eth.web3ClientVersion(res -> {
       if (res.failed()) {
         res.cause().printStackTrace();
       } else {
         System.out.println(res.result());
       }
     });
   }

   public static void main(String[] args) {
     Vertx.vertx().deployVerticle(new MainVerticle());
   }
}
