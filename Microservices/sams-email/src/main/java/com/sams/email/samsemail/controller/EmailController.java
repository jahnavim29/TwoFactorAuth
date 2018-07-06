package com.sams.email.samsemail.controller;

import java.util.Date;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sams.email.samsemail.config.EmailResponse;
import com.sams.email.samsemail.config.Message;
import com.sams.email.samsemail.exception.EmailException;
import com.sams.email.samsemail.service.IEmailService;

@RestController
@RequestMapping(path = "/SamsEmail/v1")
public class EmailController {

	@Autowired
	private IEmailService emailService;
	
	private static final Logger logger = LoggerFactory.getLogger(EmailController.class);


	@PostMapping(path = "/sendEmail")
	public ResponseEntity<EmailResponse> sendSms(@Valid @RequestBody Message message) throws EmailException {
		try {

			logger.debug("Send Email Invoked");
			emailService.sendEmail(message.getTo(), message.getSubject(), message.getBody());
			EmailResponse successResponse = new EmailResponse(new Date(), "Email successfully sent");
			return new ResponseEntity<>(successResponse, HttpStatus.OK);

		} catch (Exception be) {
			throw new EmailException(be.getMessage());
		}

	}
}
