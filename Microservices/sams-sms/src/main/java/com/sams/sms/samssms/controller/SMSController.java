package com.sams.sms.samssms.controller;

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

import com.sams.sms.samssms.config.Message;
import com.sams.sms.samssms.config.SMSResponse;
import com.sams.sms.samssms.exception.SMSException;
import com.sams.sms.samssms.service.ISMSService;

@RestController
@RequestMapping(path = "/SamsSms/v1")
public class SMSController {
	
	@Autowired
	private ISMSService smsService;
	
	private static final Logger logger = LoggerFactory.getLogger(SMSController.class);
	
	@PostMapping(path = "/sendSms")
	public ResponseEntity<SMSResponse> sendSms(@Valid @RequestBody Message message)
			throws SMSException {
		try {

			logger.debug("Send sms invoked");
			
			smsService.sendSMS(message.getPhoneNumber(), message.getText() );
			
			SMSResponse successResponse = new SMSResponse(new Date(),
					"SMS successfully sent");
			return new ResponseEntity<>(successResponse, HttpStatus.OK);

		} catch (Exception be) {
			throw new SMSException(be.getMessage());
		}

	}

}
