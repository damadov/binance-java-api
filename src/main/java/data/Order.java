package data;

import java.math.BigDecimal;

public class Order {

	public String symbol;
	public long orderId;
	public int orderListId;
	public String clientOrderId;
	public BigDecimal price;
	public BigDecimal origQty;
	public BigDecimal executedQty;
	public BigDecimal cummulativeQuoteQty;
	public String status;
	public String timeInForce;
	public String type;
	public String side;
	public BigDecimal stopPrice;
	public BigDecimal icebergQty;
	public long time;
	public long updateTime;
	public Boolean isWorking;
	public BigDecimal origQuoteOrderQty;
	
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}
	public int getOrderListId() {
		return orderListId;
	}
	public void setOrderListId(int orderListId) {
		this.orderListId = orderListId;
	}
	public String getClientOrderId() {
		return clientOrderId;
	}
	public void setClientOrderId(String clientOrderId) {
		this.clientOrderId = clientOrderId;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public BigDecimal getOrigQty() {
		return origQty;
	}
	public void setOrigQty(BigDecimal origQty) {
		this.origQty = origQty;
	}
	public BigDecimal getExecutedQty() {
		return executedQty;
	}
	public void setExecutedQty(BigDecimal executedQty) {
		this.executedQty = executedQty;
	}
	public BigDecimal getCummulativeQuoteQty() {
		return cummulativeQuoteQty;
	}
	public void setCummulativeQuoteQty(BigDecimal cummulativeQuoteQty) {
		this.cummulativeQuoteQty = cummulativeQuoteQty;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTimeInForce() {
		return timeInForce;
	}
	public void setTimeInForce(String timeInForce) {
		this.timeInForce = timeInForce;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public BigDecimal getStopPrice() {
		return stopPrice;
	}
	public void setStopPrice(BigDecimal stopPrice) {
		this.stopPrice = stopPrice;
	}
	public BigDecimal getIcebergQty() {
		return icebergQty;
	}
	public void setIcebergQty(BigDecimal icebergQty) {
		this.icebergQty = icebergQty;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public Boolean getIsWorking() {
		return isWorking;
	}
	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}
	public BigDecimal getOrigQuoteOrderQty() {
		return origQuoteOrderQty;
	}
	public void setOrigQuoteOrderQty(BigDecimal origQuoteOrderQty) {
		this.origQuoteOrderQty = origQuoteOrderQty;
	}
	
	
	
}
