package data;

import java.math.BigDecimal;

public class OrderRequest {

	public String order_guid;
	public String source;
	public String symbol;
	public String pair1;
	public String pair2;
	public String type;
	public String side;
	public BigDecimal quantity;
	public BigDecimal price;
	public BigDecimal amount;
	public String currency;
	public String date;
	public Boolean status;
	public String orderStatus = "";
	public int roundType=0;
	public String sourceOrderId;


	public String getSourceOrderId() {
		return sourceOrderId;
	}
	public void setSourceOrderId(String sourceOrderId) {
		this.sourceOrderId = sourceOrderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public int getRoundType() {
		return roundType;
	}
	public void setRoundType(int roundType) {
		this.roundType = roundType;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPair1() {
		return pair1;
	}
	public void setPair1(String pair1) {
		this.pair1 = pair1;
	}
	public String getPair2() {
		return pair2;
	}
	public void setPair2(String pair2) {
		this.pair2 = pair2;
	}
	public String getOrder_guid() {
		return order_guid;
	}
	public void setOrder_guid(String order_guid) {
		this.order_guid = order_guid;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
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

	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
