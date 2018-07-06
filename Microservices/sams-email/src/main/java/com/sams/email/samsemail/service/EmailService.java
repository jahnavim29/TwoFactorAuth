package com.sams.email.samsemail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.sams.email.samsemail.controller.EmailController;

@Service
public class EmailService implements IEmailService {

	@Autowired
	private JavaMailSender mailSender;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);

	public void sendEmail(String contactInfo, String subject, String body) {

		SimpleMailMessage message = new SimpleMailMessage();

		message.setTo(contactInfo);
		message.setSubject(subject);
		message.setText(body);
		logger.debug("Sending email to mailId: "+contactInfo);
		mailSender.send(message);

	}
}
