package data;

import java.math.BigDecimal;

public class BBalance {

	public String asset;
	public BigDecimal free;
	public BigDecimal locked;
	public String getAsset() {
		return asset;
	}
	public void setAsset(String asset) {
		this.asset = asset;
	}
	public BigDecimal getFree() {
		return free;
	}
	public void setFree(BigDecimal free) {
		this.free = free;
	}
	public BigDecimal getLocked() {
		return locked;
	}
	public void setLocked(BigDecimal locked) {
		this.locked = locked;
	}
	
	
}
