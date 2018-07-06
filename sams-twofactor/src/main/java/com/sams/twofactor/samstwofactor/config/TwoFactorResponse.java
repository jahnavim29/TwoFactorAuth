package com.sams.twofactor.samstwofactor.config;

import java.util.Date;

public class TwoFactorResponse {
	 private Date timestamp;
	  private String message;
	

	  public TwoFactorResponse(Date timestamp, String message) {
	    super();
	    this.timestamp = timestamp;
	    this.message = message;
	   
	  }

	  public Date getTimestamp() {
	    return timestamp;
	  }

	  public String getMessage() {
	    return message;
	  }

	  

	}