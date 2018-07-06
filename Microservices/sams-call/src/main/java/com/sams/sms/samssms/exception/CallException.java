package com.sams.sms.samssms.exception;

public class CallException extends Exception {

	public CallException() {
		super("Problem placing call");
	}

	
	public CallException(String message) {
		super(message);
	}
}
