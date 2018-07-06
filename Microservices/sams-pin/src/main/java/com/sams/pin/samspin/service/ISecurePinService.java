package com.sams.pin.samspin.service;

import com.sams.pin.samspin.config.TwoFactor;
import com.sams.pin.samspin.exception.BusinessException;
import com.sams.pin.samspin.exception.DAOException;

public interface ISecurePinService {

	String generateSecurePin(TwoFactor twofactor) throws BusinessException;
	
	void deleteExistingPin(String memberId) throws BusinessException;
	
	 boolean checkIfPinExists(String memberId) throws  BusinessException;

}
