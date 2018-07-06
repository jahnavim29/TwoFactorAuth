package com.sams.twofactor.samstwofactor.service;

import com.sams.twofactor.samstwofactor.config.TwoFactor;
import com.sams.twofactor.samstwofactor.exception.BusinessException;


public interface ITwoFactorService {
	
	public void sendSecurePin(TwoFactor twofactor) throws BusinessException ;

	public boolean verifyPin(String memberId, String pin) throws BusinessException ;
	

}
