package com.sams.twofactor.samstwofactor.config;

import java.util.Date;

public class MessageResponse {

	private Date timestamp;
	private String message;


	public MessageResponse() {
		super();
	}

	public MessageResponse(Date timestamp, String message) {
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
