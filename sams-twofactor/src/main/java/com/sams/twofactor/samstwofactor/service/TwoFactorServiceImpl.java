package com.sams.twofactor.samstwofactor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sams.twofactor.samstwofactor.config.Message;
import com.sams.twofactor.samstwofactor.config.MessageResponse;
import com.sams.twofactor.samstwofactor.config.PinRequest;
import com.sams.twofactor.samstwofactor.config.PinResponse;
import com.sams.twofactor.samstwofactor.config.TwoFactor;
import com.sams.twofactor.samstwofactor.controller.TwoFactorAuthenticationController;
import com.sams.twofactor.samstwofactor.exception.BusinessException;
import com.sams.twofactor.samstwofactor.exception.DAOException;
import com.sams.twofactor.samstwofactor.repository.ITwoFactorDAO;

@Service
public class TwoFactorServiceImpl implements ITwoFactorService {

	@Autowired
	private ITwoFactorDAO twoFactorDAO;

	@Autowired
	private Environment env;

	private static final Logger logger = LoggerFactory.getLogger(TwoFactorServiceImpl.class);

	@Override
	public void sendSecurePin(TwoFactor twofactor) throws BusinessException {

		String pin = generatePin(twofactor.getMemberId(), twofactor.getAppId(), twofactor.getExpiry());
		ResponseEntity<MessageResponse> response = null;

		if (pin != null && !pin.equals("")) {

			String text = twofactor.getText() + " " + pin;

			response = sendMessage(twofactor.getMethod(), text, twofactor.getSubject(), twofactor.getContactInfo());

			if (response == null || response.getStatusCode() != HttpStatus.OK) {
				throw new BusinessException("Unable to send the Pin");
			}
		} else {
			throw new BusinessException("Pin couldnot be generated");
		}
	}

	public String generatePin(String memberId, String appId, int ttl) throws BusinessException {
		String generatePinURL = env.getProperty("sams.pin.url");
		PinResponse response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			PinRequest request = new PinRequest(memberId, appId, ttl);

			logger.debug("Sending request to Generate Pin " + request);

			response = restTemplate.postForEntity(generatePinURL, request, PinResponse.class).getBody();

		} catch (Exception e) {

			throw new BusinessException("Unable to generate the Pin");
		}

		return response.getPin();
	}

	public ResponseEntity<MessageResponse> sendMessage(String method, String text, String subject, String contactInfo)
			throws BusinessException {

		String sendMessageURL = env.getProperty("sams.message.url");
		ResponseEntity<MessageResponse> response = null;
		try {
			RestTemplate restTemplate = new RestTemplate();

			Message request = new Message(method, text, subject, contactInfo);

			logger.debug("Sending request to send the message " + request);

			response = restTemplate.postForEntity(sendMessageURL, request, MessageResponse.class);
		} catch (Exception e) {
			throw new BusinessException("Unable to send the message");
		}

		return response;
	}

	public boolean verifyPin(String memberId, String pin) throws BusinessException {
		try {
			String storedPin = twoFactorDAO.getPin(memberId);

			if (storedPin.equals(pin)) {

				logger.debug("Pin matched");

				twoFactorDAO.deletePin(memberId);
				return true;
			} else
				return false;
		} catch (DAOException de) {
			throw new BusinessException(de.getMessage());
		}

	}

}
