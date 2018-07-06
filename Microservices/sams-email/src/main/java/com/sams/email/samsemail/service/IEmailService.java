package com.sams.email.samsemail.service;

public interface IEmailService {

	public void sendEmail(String contactInfo, String subject, String body);
}
