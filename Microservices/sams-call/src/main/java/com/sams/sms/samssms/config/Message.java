package com.sams.sms.samssms.config;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Message {

	
	@Size(min=12,max=12, message="Phone number should be atleast 12 digits including the Area code")
	private String phoneNumber;
	
	
	private String text;
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
}
