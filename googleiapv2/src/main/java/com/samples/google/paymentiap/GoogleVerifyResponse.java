package com.samples.google.paymentiap;

public class GoogleVerifyResponse {
	// 0:Yet to be consumed         1:Consumed
	private Integer consumptionState;
	private String developerPayload;
	private String kind;
	//0:Purchased    1:Cancelled
	private Integer purchaseState;
	private Long purchaseTimeMillis;
	
	public Integer getConsumptionState() {
		return consumptionState == null ? -1 : consumptionState;
	}
	public void setConsumptionState(Integer consumptionState) {
		this.consumptionState = consumptionState;
	}
	public String getDeveloperPayload() {
		return developerPayload;
	}
	public void setDeveloperPayload(String developerPayload) {
		this.developerPayload = developerPayload;
	}
	public String getKind() {
		return kind;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public Integer getPurchaseState() {
		return purchaseState == null ? -1 : purchaseState;
	}
	public void setPurchaseState(Integer purchaseState) {
		this.purchaseState = purchaseState;
	}
	public Long getPurchaseTimeMillis() {
		return purchaseTimeMillis;
	}
	public void setPurchaseTimeMillis(Long purchaseTimeMillis) {
		this.purchaseTimeMillis = purchaseTimeMillis;
	}
}
