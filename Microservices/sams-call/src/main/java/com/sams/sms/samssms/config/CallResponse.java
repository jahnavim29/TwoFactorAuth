package com.sams.sms.samssms.config;

import java.util.Date;

public class CallResponse {
	 private Date timestamp;
	  private String message;
	

	  public CallResponse(Date timestamp, String message) {
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