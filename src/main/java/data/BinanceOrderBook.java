package data;

import com.google.gson.JsonArray;

public class BinanceOrderBook {

	public long lastUpdateId;
	public JsonArray bids;
	public JsonArray asks;
	
	public long getLastUpdateId() {
		return lastUpdateId;
	}
	public void setLastUpdateId(long lastUpdateId) {
		this.lastUpdateId = lastUpdateId;
	}
	public JsonArray getBids() {
		return bids;
	}
	public void setBids(JsonArray bids) {
		this.bids = bids;
	}
	public JsonArray getAsks() {
		return asks;
	}
	public void setAsks(JsonArray asks) {
		this.asks = asks;
	}

	
	
}
