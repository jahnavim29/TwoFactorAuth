package com.sams.email.samsemail.config;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class Message {

	
	@Email(message="Email format is Invalid")
	private String to;
	
	@NotBlank(message="Subject cannot be null")
	private String subject;
	@NotBlank(message="Body cannot be null")
	private String body;
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
}
