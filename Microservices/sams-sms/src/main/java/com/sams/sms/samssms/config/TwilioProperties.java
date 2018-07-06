package com.sams.sms.samssms.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioProperties {

	private  String accountSid;
	private String authToken;
	private String number;
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getAuthToken() {
		return authToken;
	}
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String twilioNumber) {
		this.number = twilioNumber;
	}
	
	
}
