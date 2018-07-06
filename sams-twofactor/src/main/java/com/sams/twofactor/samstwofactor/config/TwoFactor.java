package com.sams.twofactor.samstwofactor.config;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class TwoFactor {
	@NotBlank(message = "AppId cannot be blank")
	private String appId;
	@Size(min = 17, max = 17, message = "Membership Id should be 17 digits")
	private String memberId;
	@NotBlank(message = "Method cannot be blank")
	private String method;
	
	@NotBlank
	private String contactInfo;
	
	@NotBlank(message = "Text cannot be blank")
	private String text;
	
	private String subject;
	private int expiry;
	
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public int getExpiry() {
		return expiry;
	}
	public void setExpiry(int expiry) {
		this.expiry = expiry;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}
	
	
	

}
