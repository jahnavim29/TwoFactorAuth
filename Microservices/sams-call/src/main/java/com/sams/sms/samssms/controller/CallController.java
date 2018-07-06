package com.sams.sms.samssms.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sams.sms.samssms.config.CallResponse;
import com.sams.sms.samssms.config.Message;
import com.sams.sms.samssms.exception.CallException;
import com.sams.sms.samssms.service.ICallService;

@RestController
@RequestMapping(path = "/SamsCall/v1")
public class CallController {
	
	@Autowired
	private ICallService callService;
	
	@PostMapping(path = "/call")
	public ResponseEntity<CallResponse> sendSms(@Valid @RequestBody Message message)
			throws CallException {
		try {

			callService.sendCall(message.getPhoneNumber(), message.getText() );
			CallResponse successResponse = new CallResponse(new Date(),
					"Calling the member");
			return new ResponseEntity<>(successResponse, HttpStatus.OK);

		} catch (Exception be) {
			throw new CallException(be.getMessage());
		}

	}

}
