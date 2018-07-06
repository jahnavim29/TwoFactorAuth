package com.sams.sms.samssms.service;

import com.sams.sms.samssms.exception.SMSException;

public interface ISMSService {

	public void sendSMS(String phoneNumber, String message) throws SMSException;
}
