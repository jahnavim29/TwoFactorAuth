package com.sams.twofactor.samstwofactor.exception;

public class DeliveryException extends Exception{

	
	public DeliveryException() {
		super("Error sending the Pin");
	}

	public DeliveryException(String message) {
		super(message);
	}
}
