package data;

import java.math.BigDecimal;
import java.util.Date;

public class TrendLine {

	public int candle_id;
	public String date;
	public int index;
	public BigDecimal value;
	public Candlestick candle;
	public String code;
	public String title;
	public String description;
	public String chartLabel;
	public String color = "#000000";
	
	
	
	public TrendLine(int candle_id,String date, BigDecimal value, String color) {
		super();
		this.candle_id = candle_id;
		this.date = date;
		this.value = value;
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getChartLabel() {
		return chartLabel;
	}
	public void setChartLabel(String chartLabel) {
		this.chartLabel = chartLabel;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public Candlestick getCandle() {
		return candle;
	}
	public void setCandle(Candlestick candle) {
		this.candle = candle;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

	public BigDecimal getValue() {
		return value;
	}
	public void setValue(BigDecimal value) {
		this.value = value;
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

	
	
	/*
	 	"date": "2011-08-08",
	    "open": "131.11",
	    "high": "133.00",
	    "low": "125.09",
	    "close": "126.39"
	 */
	
	
	
}
