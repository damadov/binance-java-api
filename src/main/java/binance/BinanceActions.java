package binance;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import data.AccountResponse;
import data.Balance;
import data.BalanceItem;
import data.BinanceTicker;
import data.Order;
import data.OrderRequest;
import data.Ticker;
import data.Trade;
import data.TransferRequest;
import tools.appConfig;
import tools.appendPool;
import tools.requestTool;

public class BinanceActions {

	private static String API_KEY = appConfig.binanceSpotKey;
	private static String API_SECRET = appConfig.binanceSpotSecret;
	private static String baseUrl = appConfig.binanceUrl;
	private static HashMap<String, String> parameters = new HashMap<String, String>();
	private static Binance httpRequest;
	private static String orderId = UUID.randomUUID().toString();

	public static Balance account() {

		Gson gson = new GsonBuilder().create();
		Balance balance = null;
		BalanceItem item = null;
		BalanceItem[] items = null;
		
		try {

			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			httpRequest.sendSignedRequest(parameters, "/api/v3/account", "GET");
			
			if(httpRequest.resp!=null) {
					
					AccountResponse resp = gson.fromJson(httpRequest.resp, AccountResponse.class);
					
					if(resp != null && resp.balances !=null) {
						
						balance = new Balance();
						balance.setSource("binance");
						
					
						for(int i=0;i<resp.balances.length;i++) {
							
							item = new BalanceItem(resp.balances[i].asset,resp.balances[i].free.add(resp.balances[i].locked) );
					
							items = appendPool.appendBalanceItem(items, item);
						}
						
						balance.setAssets(items);
						
					}
					

			}

			return balance;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			parameters.clear();
		}
	}

	public static Ticker ticker(String pair1,String pair2) {

		Ticker ticker = null;
		BinanceTicker binanceTicker = null;
		Gson gson = new GsonBuilder().create();
		
		try {

			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			parameters.put("symbol", pair1+pair2);
			httpRequest.sendPublicRequest(parameters, "/api/v3/ticker/bookTicker");

			
			binanceTicker = gson.fromJson(httpRequest.resp, BinanceTicker.class);
			
			if(binanceTicker != null) {
				ticker = new Ticker();
				ticker.setAskPrice(binanceTicker.askPrice);
				ticker.setBidPrice(binanceTicker.bidPrice);
				ticker.setSymbol(binanceTicker.symbol);
			}

			return ticker;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			parameters.clear();
		}
	}

	public static String timer() {

		try {

			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			httpRequest.sendSignedRequest(parameters, "/api/v3/time", "GET");

			return httpRequest.resp;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			parameters.clear();
		}
	}

	public static String withdraw(TransferRequest transfer) {

		try {

			httpRequest = new Binance(baseUrl, appConfig.binanceSpotKeyWD, appConfig.binanceSpotSecretWD);

			parameters.put("coin", transfer.symbol);
			//parameters.put("address", transfer.address);
			parameters.put("amount", transfer.amount);
			parameters.put("withdrawOrderId", orderId);
			httpRequest.sendSignedRequest(parameters, "/sapi/v1/capital/withdraw/apply", "POST");
			parameters.clear();

			return httpRequest.resp;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		} finally {
			parameters.clear();
		}

	}
	
	public static Trade[] tradeList(String pair1,String pair2) {

		Trade trade = null;
		Trade[] trades = null;
		Gson gson = new GsonBuilder().create();
		String symbol = "";
		final List<String> locators = new ArrayList<String>();
		
		try {


			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			parameters.put("symbol", pair1+pair2);
			parameters.put("limit", "100");
			httpRequest.sendPublicRequest(parameters, "/api/v3/depth");

			
			
			if(httpRequest.resp != null ) {
				
				//BinanceOrderBook binanceBooks = gson.fromJson(httpRequest.resp, BinanceOrderBook.class);
				 
				  JsonObject jsonObject = new Gson().fromJson(httpRequest.resp, JsonObject.class);

				// tools.console.println("last yupdate: "+ new Gson().fromJson(element.getAsJsonObject("lastUpdateId"),long.class));
//
				 JsonArray bids = jsonObject.getAsJsonArray("bids");
				 JsonArray asks = jsonObject.getAsJsonArray("asks");
				 JsonPrimitive lastUpdate = jsonObject.getAsJsonPrimitive("lastUpdateId");
				 
				 tools.console.println("last yupdate: "+lastUpdate.getAsString());
				 
				for(int i=0;i<bids.size();i++) {
					JsonArray item = bids.get(i).getAsJsonArray();
					
					trade = new Trade();
					trade.setPrice(new BigDecimal(item.get(0).getAsString()));
					trade.setAmount(new BigDecimal(item.get(1).getAsString()));
					trade.setSide("BUY");
					trade.setDate(lastUpdate.getAsLong());
					trades = appendPool.appendTrade(trades, trade);
				}
				for(int i=0;i<asks.size();i++) {
					JsonArray item = bids.get(i).getAsJsonArray();
					
					trade = new Trade();
					trade.setPrice(new BigDecimal(item.get(0).getAsString()));
					trade.setAmount(new BigDecimal(item.get(1).getAsString()));
					trade.setSide("SELL");
					trade.setDate(lastUpdate.getAsLong());
					trades = appendPool.appendTrade(trades, trade);
				}
			    
			   
			}
			
			return trades;

		} catch (Exception ex) {
			tools.console.println("Error on Trade List:"+ex.getMessage());
			return null;
		} finally {
			parameters.clear();
		}
	}
	
	public static Order orderDetail(String symbol,String orderId) {

		Order order = null;
		Gson gson = new GsonBuilder().create();
		
		try {
		httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

		parameters.put("symbol", symbol);
		parameters.put("orderId", orderId);

		httpRequest.sendSignedRequest(parameters, "/api/v3/order", "GET");
		parameters.clear();

		order = gson.fromJson(httpRequest.resp,Order.class);
		
			
			return order;

		} catch (Exception ex) {
			tools.console.println("Error on Order Detail:"+ex.getMessage());
			return null;
		} finally {
			parameters.clear();
		}
	}

	public static String order(OrderRequest order) {

		try {

			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			if(order.symbol!=null)
				parameters.put("symbol", order.symbol);
			else
				parameters.put("symbol", order.pair1+order.pair2);
			parameters.put("side", order.side);
			parameters.put("type", order.type);

			parameters.put("quantity", String.valueOf(order.quantity));
			if (order.type.equals("LIMIT")) {
				parameters.put("timeInForce", "GTC");
				parameters.put("price", String.valueOf(order.price));
			}
			if(order.order_guid!=null)
				parameters.put("newClientOrderId", order.order_guid);
			else
				parameters.put("newClientOrderId", UUID.randomUUID().toString());
			
			httpRequest.sendSignedRequest(parameters, "/api/v3/order", "POST");
			parameters.clear();

			return httpRequest.resp;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			parameters.clear();
		}

	}
	
	public static String cancel(OrderRequest order) {

		try {

			httpRequest = new Binance(baseUrl, API_KEY, API_SECRET);

			if(order.symbol!=null)
				parameters.put("symbol", order.symbol);
			else
				parameters.put("symbol", order.pair1+order.pair2);

			parameters.put("orderId", order.sourceOrderId);
			parameters.put("timestamp", timer());
			
			httpRequest.sendSignedRequest(parameters, "/api/v3/order", "DELETE");
			parameters.clear();

			return httpRequest.resp;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}finally {
			parameters.clear();
		}

	}

}
