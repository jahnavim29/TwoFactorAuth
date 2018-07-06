package com.sams.twofactor.samstwofactor.config;

public class Message {

	
	private String method;
	private String text;
	private String subject;
	private String contactInfo;
	
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
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
	
	public Message(String method, String text, String subject, String contactInfo) {
		super();
		this.method = method;
		this.text = text;
		this.subject = subject;
		this.contactInfo = contactInfo;
	}
	public Message() {
		super();
	
	}
}
