package com.sams.sms.samssms.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sams.sms.samssms.config.TwilioProperties;
import com.sams.sms.samssms.controller.SMSController;
import com.sams.sms.samssms.exception.SMSException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SMSService implements ISMSService{
	
	@Autowired
	private TwilioProperties twilio;

	private static final Logger logger = LoggerFactory.getLogger(SMSService.class);
	
	public void sendSMS(String phoneNumber, String message) throws SMSException {
		try {
			
			Twilio.init(twilio.getAccountSid(), twilio.getAuthToken());
			logger.debug("Sending SMS to phone number :" + phoneNumber);
			Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(twilio.getNumber()), message ).create();
			
		} catch (Exception e) {
			throw new SMSException();
		}

	}

	
		
	}

