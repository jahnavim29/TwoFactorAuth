package com.sams.email.samsemail.exception;

public class EmailException extends Exception{
	

	public EmailException() {
		super("Error sending Email");
	}

	
	public EmailException(String message) {
		super(message);
	}

}
