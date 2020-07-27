package com.example.demo.common.entity;

/**
 * 
 * @ClassName: ExchangeRate
 * @Description: 自定义汇率对象
 * @author chenjy
 * @date 2020年5月13日 下午7:33:05
 *
 */
public class ExchangeRate {
	private String fromCurrencyCode;
	private String fromCurrencyName;
	private String toCurrencyCode;
	private String toCurrencyName;
	private String exchangeRate;
	private String lastRefreshed;
	private String timeZone;
	private String bidPrice;
	private String askPrice;

	public String getFromCurrencyCode() {
		return fromCurrencyCode;
	}

	public void setFromCurrencyCode(String fromCurrencyCode) {
		this.fromCurrencyCode = fromCurrencyCode;
	}

	public String getFromCurrencyName() {
		return fromCurrencyName;
	}

	public void setFromCurrencyName(String fromCurrencyName) {
		this.fromCurrencyName = fromCurrencyName;
	}

	public String getToCurrencyCode() {
		return toCurrencyCode;
	}

	public void setToCurrencyCode(String toCurrencyCode) {
		this.toCurrencyCode = toCurrencyCode;
	}

	public String getToCurrencyName() {
		return toCurrencyName;
	}

	public void setToCurrencyName(String toCurrencyName) {
		this.toCurrencyName = toCurrencyName;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getLastRefreshed() {
		return lastRefreshed;
	}

	public void setLastRefreshed(String lastRefreshed) {
		this.lastRefreshed = lastRefreshed;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public String getBidPrice() {
		return bidPrice;
	}

	public void setBidPrice(String bidPrice) {
		this.bidPrice = bidPrice;
	}

	public String getAskPrice() {
		return askPrice;
	}

	public void setAskPrice(String askPrice) {
		this.askPrice = askPrice;
	}

	@Override
	public String toString() {
		return "ExchangeRate [fromCurrencyCode=" + fromCurrencyCode + ", fromCurrencyName=" + fromCurrencyName
				+ ", toCurrencyCode=" + toCurrencyCode + ", toCurrencyName=" + toCurrencyName + ", exchangeRate="
				+ exchangeRate + ", lastRefreshed=" + lastRefreshed + ", timeZone=" + timeZone + ", bidPrice="
				+ bidPrice + ", askPrice=" + askPrice + "]";
	}

}
