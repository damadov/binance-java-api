package data;

import java.math.BigDecimal;

public class Ticker {
	
	public String symbol;
	public BigDecimal askPrice;
	public BigDecimal bidPrice;
	public BigDecimal askQuantity;
	public BigDecimal bidQuantity;
	public BigDecimal lastPrice;
	public String requestStr;
	public String responseStr;
	
	
	public String getResponseStr() {
		return responseStr;
	}
	public void setResponseStr(String responseStr) {
		this.responseStr = responseStr;
	}
	public String getRequestStr() {
		return requestStr;
	}
	public void setRequestStr(String requestStr) {
		this.requestStr = requestStr;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
	public BigDecimal getAskQuantity() {
		return askQuantity;
	}
	public void setAskQuantity(BigDecimal askQuantity) {
		this.askQuantity = askQuantity;
	}
	public BigDecimal getBidQuantity() {
		return bidQuantity;
	}
	public void setBidQuantity(BigDecimal bidQuantity) {
		this.bidQuantity = bidQuantity;
	}
	public BigDecimal getLastPrice() {
		return lastPrice;
	}
	public void setLastPrice(BigDecimal lastPrice) {
		this.lastPrice = lastPrice;
	}

	

}
