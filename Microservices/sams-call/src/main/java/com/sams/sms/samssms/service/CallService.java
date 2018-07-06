package com.sams.sms.samssms.service;

import java.net.URI;
import java.net.URLEncoder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sams.sms.samssms.config.TwilioProperties;
import com.sams.sms.samssms.exception.CallException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;

@Service
public class CallService implements ICallService{
	
	@Autowired
	private TwilioProperties twilio;
	

	public void sendCall(String phoneNumber, String message) throws CallException {
		try {
			
			Twilio.init(twilio.getAccountSid(), twilio.getAuthToken());

			//Message.creator(new PhoneNumber(phoneNumber), new PhoneNumber(twilio.getNumber()), message ).create();
			
			 Call.creator(new PhoneNumber(phoneNumber), new PhoneNumber(twilio.getNumber()),
	                new URI("https://handler.twilio.com/twiml/EHca4cdc4b93d6221712d1106b9333a290?Message="+URLEncoder.encode(message, "UTF-8"))).create();
		} catch (Exception e) {
			throw new CallException();
		}

	}

	
		
	}

