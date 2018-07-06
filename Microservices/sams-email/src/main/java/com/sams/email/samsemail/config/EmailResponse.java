package com.sams.email.samsemail.config;

import java.util.Date;

public class EmailResponse {

private Date timestamp;
private String message;


public EmailResponse(Date timestamp, String message) {
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