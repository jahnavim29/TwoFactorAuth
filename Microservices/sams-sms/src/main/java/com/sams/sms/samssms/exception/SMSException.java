package com.sams.sms.samssms.exception;

public class SMSException extends Exception {

	public SMSException() {
		super("Error sending SMS");
	}

	
	public SMSException(String message) {
		super(message);
	}
}
