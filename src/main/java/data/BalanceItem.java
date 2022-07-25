package data;

import java.math.BigDecimal;

public class BalanceItem {

	public String asset;
	public String name;
	public BigDecimal amount;
	public BigDecimal locked;
	public BigDecimal free;
	
	
	
	public BalanceItem(String asset, BigDecimal amount) {
		super();
		this.asset = asset;
		this.amount = amount;
	}
	
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public BigDecimal getLocked() {
		return locked;
	}
	public void setLocked(BigDecimal locked) {
		this.locked = locked;
	}
	public BigDecimal getFree() {
		return free;
	}
	public void setFree(BigDecimal free) {
		this.free = free;
	}

	
	
	
}
