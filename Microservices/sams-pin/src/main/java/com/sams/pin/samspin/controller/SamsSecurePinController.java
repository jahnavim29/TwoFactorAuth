package com.sams.pin.samspin.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sams.pin.samspin.config.TwoFactor;
import com.sams.pin.samspin.config.TwoFactorResponse;
import com.sams.pin.samspin.exception.PinGenerationException;
import com.sams.pin.samspin.service.ISecurePinService;



@RestController
@RequestMapping(path = "/SamsPin/v1")
public class SamsSecurePinController {

@Autowired 
ISecurePinService securePinService;

	@PostMapping(path = "/generatePin")
	public ResponseEntity<TwoFactorResponse> generatePin(@Valid @RequestBody TwoFactor twoFactor) throws PinGenerationException{
		try {
			String pin =securePinService.generateSecurePin(twoFactor);
			
			TwoFactorResponse successResponse = new TwoFactorResponse(new Date(),
					"Pin successfully generated", pin);
			return new ResponseEntity<>(successResponse, HttpStatus.OK);
		}
		catch(Exception e) {
			throw new PinGenerationException(e.getMessage());
		}
		
	}
}
