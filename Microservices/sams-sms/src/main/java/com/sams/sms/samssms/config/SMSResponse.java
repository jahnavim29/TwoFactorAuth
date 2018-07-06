package com.sams.sms.samssms.config;

import java.util.Date;

public class SMSResponse {
	 private Date timestamp;
	  private String message;
	

	  public SMSResponse(Date timestamp, String message) {
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