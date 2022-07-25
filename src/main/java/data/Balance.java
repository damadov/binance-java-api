package data;

import java.math.BigDecimal;

public class Balance {
	
	public String source;
	public BalanceItem[] assets;
	public BigDecimal total_USD;
	public BigDecimal total_TRY;
	public BigDecimal total_BTC;
	
	
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public BalanceItem[] getAssets() {
		return assets;
	}
	public void setAssets(BalanceItem[] assets) {
		this.assets = assets;
	}
	public BigDecimal getTotal_USD() {
		return total_USD;
	}
	public void setTotal_USD(BigDecimal total_USD) {
		this.total_USD = total_USD;
	}
	public BigDecimal getTotal_TRY() {
		return total_TRY;
	}
	public void setTotal_TRY(BigDecimal total_TRY) {
		this.total_TRY = total_TRY;
	}
	public BigDecimal getTotal_BTC() {
		return total_BTC;
	}
	public void setTotal_BTC(BigDecimal total_BTC) {
		this.total_BTC = total_BTC;
	}
	
	

}
