package com.sams.twofactor.samstwofactor.config;

import javax.validation.constraints.Size;

public class Pin {

	@Size(min = 17, max = 17, message = "Membership Id should be 17 digits")
	private String memberId;
	
	@Size(min = 6, max = 6, message = "Pin should be 6 digits")
	private String pin;
	
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	
	
}
