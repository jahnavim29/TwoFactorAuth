package com.sams.twofactor.samstwofactor.config;

public class PinRequest {
	private String memberId;
	private String appId;
	private int ttl;

	public PinRequest() {
		super();
	}

	public PinRequest(String memberId, String appId, int ttl) {
		super();
		this.memberId = memberId;
		this.appId = appId;
		this.ttl = ttl;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public int getTtl() {
		return ttl;
	}

	public void setTtl(int ttl) {
		this.ttl = ttl;
	}

}
