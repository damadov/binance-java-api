package data;

public class TransferRequest {
	
	public String symbol;
	public String amount;
	public String fee;
	public String source;
	public String address;
	public String transfer_guid;
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getFee() {
		return fee;
	}
	public void setFee(String fee) {
		this.fee = fee;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTransfer_guid() {
		return transfer_guid;
	}
	public void setTransfer_guid(String transfer_guid) {
		this.transfer_guid = transfer_guid;
	}
	
	
}
