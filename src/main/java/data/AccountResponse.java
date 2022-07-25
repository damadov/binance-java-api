package data;

import java.math.BigDecimal;

public class AccountResponse {

	public int makerCommission;
	public int takerCommission;
	public int buyerCommission;
	public int sellerCommission;
	public Boolean canTrade;
	public Boolean canWithdraw;
	public Boolean canDeposit;
	public long updateTime;
	public String accountType;
	public BBalance[] balances;
	public String[] permissions;
	
	
	public BBalance[] getBalances() {
		return balances;
	}
	public void setBalances(BBalance[] balances) {
		this.balances = balances;
	}
	public String[] getPermissions() {
		return permissions;
	}
	public void setPermissions(String[] permissions) {
		this.permissions = permissions;
	}
	public int getMakerCommission() {
		return makerCommission;
	}
	public void setMakerCommission(int makerCommission) {
		this.makerCommission = makerCommission;
	}
	public int getTakerCommission() {
		return takerCommission;
	}
	public void setTakerCommission(int takerCommission) {
		this.takerCommission = takerCommission;
	}
	public int getBuyerCommission() {
		return buyerCommission;
	}
	public void setBuyerCommission(int buyerCommission) {
		this.buyerCommission = buyerCommission;
	}
	public int getSellerCommission() {
		return sellerCommission;
	}
	public void setSellerCommission(int sellerCommission) {
		this.sellerCommission = sellerCommission;
	}
	public Boolean getCanTrade() {
		return canTrade;
	}
	public void setCanTrade(Boolean canTrade) {
		this.canTrade = canTrade;
	}
	public Boolean getCanWithdraw() {
		return canWithdraw;
	}
	public void setCanWithdraw(Boolean canWithdraw) {
		this.canWithdraw = canWithdraw;
	}
	public Boolean getCanDeposit() {
		return canDeposit;
	}
	public void setCanDeposit(Boolean canDeposit) {
		this.canDeposit = canDeposit;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	
	
}
