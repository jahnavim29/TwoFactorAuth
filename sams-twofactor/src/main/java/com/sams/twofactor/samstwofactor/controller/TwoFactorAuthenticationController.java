package com.sams.twofactor.samstwofactor.controller;

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
import com.sams.twofactor.samstwofactor.config.Pin;
import com.sams.twofactor.samstwofactor.config.TwoFactor;
import com.sams.twofactor.samstwofactor.config.TwoFactorResponse;
import com.sams.twofactor.samstwofactor.exception.BusinessException;
import com.sams.twofactor.samstwofactor.exception.DeliveryException;
import com.sams.twofactor.samstwofactor.exception.PinVerificationException;
import com.sams.twofactor.samstwofactor.service.ITwoFactorService;


@RestController
@RequestMapping(path="/SamsTwoFactor/v1")
public class TwoFactorAuthenticationController {

	@Autowired
	private ITwoFactorService twoFactorService;
	
	private static final Logger logger = LoggerFactory.getLogger(TwoFactorAuthenticationController.class);


	@PostMapping(path = "/sendPin")
	public ResponseEntity<TwoFactorResponse> sendPin(@Valid @RequestBody TwoFactor twoFactor) throws DeliveryException{
		try {

			logger.debug("Send Pin Invoked");
			twoFactorService.sendSecurePin(twoFactor );
			
			TwoFactorResponse successResponse = new TwoFactorResponse(new Date(),
					"PIN successfully sent to the member");
			return new ResponseEntity<>(successResponse, HttpStatus.CREATED);

		} catch (BusinessException be) {
			throw new DeliveryException(be.getMessage());
			
		}

	}

	@PostMapping(path = "/verifyPin")
	public ResponseEntity<TwoFactorResponse> verifyPin(@Valid @RequestBody Pin pin)
			throws PinVerificationException {
		try {
			
			logger.debug("Verify Pin Invoked");
			
			boolean pinMatched = twoFactorService.verifyPin(pin.getMemberId(), pin.getPin());

			if (pinMatched) {

				TwoFactorResponse successResponse = new TwoFactorResponse(new Date(), "PIN Verified");
				return new ResponseEntity<>(successResponse, HttpStatus.OK);

			} else {
				throw new PinVerificationException("PIN did not match. Please try again");
			}

		}

		catch (BusinessException be) {
			throw new PinVerificationException("Unable to verify PIN");
		}
	}

}
