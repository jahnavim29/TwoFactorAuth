package com.sams.pin.samspin.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sams.pin.samspin.config.TwoFactor;
import com.sams.pin.samspin.exception.BusinessException;
import com.sams.pin.samspin.exception.DAOException;
import com.sams.pin.samspin.repository.ISecurePinDao;

@Service
public class SecurePinService implements ISecurePinService {

	@Autowired
	ISecurePinDao securePinDAO;

	@Override
	public String generateSecurePin(TwoFactor twofactor) throws BusinessException {
		String pin = generateRandomnPin();
		try {
			String memberId = twofactor.getMemberId();

			boolean pinExists = checkIfPinExists(memberId);

			if (pinExists) {
				deleteExistingPin(memberId);
			}

			securePinDAO.saveSecurePin(memberId, pin, twofactor.getAppId(), twofactor.getTtl());

		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
		return pin;

	}

	@Override
	public void deleteExistingPin(String memberId) throws BusinessException {
		try {
			securePinDAO.deletePin(memberId);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
	}

	@Override
	public boolean checkIfPinExists(String memberId) throws BusinessException {
		String existingPin;
		try {
			existingPin = securePinDAO.getPin(memberId);
		} catch (DAOException e) {
			throw new BusinessException(e.getMessage());
		}
		if (existingPin != null && !existingPin.equals("")) {
			return true;
		}
		return false;
	}

	public String generateRandomnPin() {
		Random random = new Random();
		String pin = String.valueOf(100000 + random.nextInt(900000));

		return pin;
	}
}
