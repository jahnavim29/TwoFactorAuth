package com.sams.pin.samspin.config;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TwoFactor {
	@Size(min = 17, max = 17, message = "Membership Id should be 17 digits")
	private String memberId;
	@NotBlank
	private String appId;
	private int ttl;

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
