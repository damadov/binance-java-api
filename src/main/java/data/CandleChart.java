package data;

import java.math.BigDecimal;
import java.util.Date;

public class CandleChart {

	public int candle_id=0;
	public String date;
	public BigDecimal open;
	public BigDecimal high;
	public BigDecimal low;
	public BigDecimal close;
	public Boolean isTrendPoint=false;
	public String swingPoint;
	
	
	public String getSwingPoint() {
		return swingPoint;
	}
	public void setSwingPoint(String swingPoint) {
		this.swingPoint = swingPoint;
	}
	public int getCandle_id() {
		return candle_id;
	}
	public void setCandle_id(int candle_id) {
		this.candle_id = candle_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public BigDecimal getOpen() {
		return open;
	}
	public void setOpen(BigDecimal open) {
		this.open = open;
	}
	public BigDecimal getHigh() {
		return high;
	}
	public void setHigh(BigDecimal high) {
		this.high = high;
	}
	public BigDecimal getLow() {
		return low;
	}
	public void setLow(BigDecimal low) {
		this.low = low;
	}
	public BigDecimal getClose() {
		return close;
	}
	public void setClose(BigDecimal close) {
		this.close = close;
	}
	public Boolean getIsTrendPoint() {
		return isTrendPoint;
	}
	public void setIsTrendPoint(Boolean isTrendPoint) {
		this.isTrendPoint = isTrendPoint;
	}
	

	
	
	/*
	 	"date": "2011-08-08",
	    "open": "131.11",
	    "high": "133.00",
	    "low": "125.09",
	    "close": "126.39"
	 */
	
	
	
}
