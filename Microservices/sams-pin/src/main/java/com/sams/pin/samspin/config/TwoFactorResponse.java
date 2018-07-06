package com.sams.pin.samspin.config;

import java.util.Date;

public class TwoFactorResponse {
	 private Date timestamp;
	  private String message;
	  private String pin;

	  public TwoFactorResponse(Date timestamp, String message, String pin) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	    this.pin = pin;
	   
	  }

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