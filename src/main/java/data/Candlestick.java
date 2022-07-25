package data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Candlestick {

	public String source;
	public String symbol;
	public String interval;
	public long open_time;
	public long close_time;
	public LocalDateTime open_time_local;
	public LocalDateTime close_time_local;
	public BigDecimal price_highest;
	public BigDecimal price_lowest;
	public BigDecimal price_open;
	public BigDecimal price_close;
	public int direction = +1;
	public int candle_id;
	public Boolean isTouchPoint=false;
	public Boolean isFirstCandle=false;
	public String swingStatus = "";
	public int dbIndex;
	
	
	public int getDbIndex() {
		return dbIndex;
	}
	public void setDbIndex(int dbIndex) {
		this.dbIndex = dbIndex;
	}
	public String getSwingStatus() {
		return swingStatus;
	}
	public void setSwingStatus(String swingStatus) {
		this.swingStatus = swingStatus;
	}
	public Boolean getIsFirstCandle() {
		return isFirstCandle;
	}
	public void setIsFirstCandle(Boolean isFirstCandle) {
		this.isFirstCandle = isFirstCandle;
	}
	public Boolean getIsTouchPoint() {
		return isTouchPoint;
	}
	public void setIsTouchPoint(Boolean isTouchPoint) {
		this.isTouchPoint = isTouchPoint;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public int getCandle_id() {
		return candle_id;
	}
	public void setCandle_id(int candle_id) {
		this.candle_id = candle_id;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}


	public LocalDateTime getOpen_time_local() {
		return open_time_local;
	}
	public void setOpen_time_local(LocalDateTime open_time_local) {
		this.open_time_local = open_time_local;
	}
	public LocalDateTime getClose_time_local() {
		return close_time_local;
	}
	public void setClose_time_local(LocalDateTime close_time_local) {
		this.close_time_local = close_time_local;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getInterval() {
		return interval;
	}
	public void setInterval(String interval) {
		this.interval = interval;
	}
	public long getOpen_time() {
		return open_time;
	}
	public void setOpen_time(long open_time) {
		this.open_time = open_time;
	}
	public long getClose_time() {
		return close_time;
	}
	public void setClose_time(long close_time) {
		this.close_time = close_time;
	}
	public BigDecimal getPrice_highest() {
		return price_highest;
	}
	public void setPrice_highest(BigDecimal price_highest) {
		this.price_highest = price_highest;
	}
	public BigDecimal getPrice_lowest() {
		return price_lowest;
	}
	public void setPrice_lowest(BigDecimal price_lowest) {
		this.price_lowest = price_lowest;
	}
	public BigDecimal getPrice_open() {
		return price_open;
	}
	public void setPrice_open(BigDecimal price_open) {
		this.price_open = price_open;
	}
	public BigDecimal getPrice_close() {
		return price_close;
	}
	public void setPrice_close(BigDecimal price_close) {
		this.price_close = price_close;
	}
	
	
	
}
