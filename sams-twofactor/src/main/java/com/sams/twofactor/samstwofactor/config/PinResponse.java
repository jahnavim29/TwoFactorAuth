package com.sams.twofactor.samstwofactor.config;

import java.util.Date;

public class PinResponse {
	private Date timestamp;
	private String message;
	private String pin;

	  public PinResponse(Date timestamp, String message, String pin) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.pin = pin;
	   
	  }

	  public PinResponse() {}
	  
	  public Date getTimestamp() {
	    return timestamp;
	  }

	  public String getMessage() {
	    return message;
	  }

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

}
