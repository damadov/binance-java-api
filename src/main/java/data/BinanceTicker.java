package data;

import java.math.BigDecimal;

public class BinanceTicker {

	public String symbol;
	public BigDecimal bidPrice;
	public BigDecimal bidQty;
	public BigDecimal askPrice;
	public BigDecimal askQty;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public BigDecimal getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(BigDecimal bidPrice) {
		this.bidPrice = bidPrice;
	}
	public BigDecimal getBidQty() {
		return bidQty;
	}
	public void setBidQty(BigDecimal bidQty) {
		this.bidQty = bidQty;
	}
	public BigDecimal getAskPrice() {
		return askPrice;
	}
	public void setAskPrice(BigDecimal askPrice) {
		this.askPrice = askPrice;
	}
	public BigDecimal getAskQty() {
		return askQty;
	}
	public void setAskQty(BigDecimal askQty) {
		this.askQty = askQty;
	}
	
	
}


