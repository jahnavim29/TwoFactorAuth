package com.sams.sms.samssms.service;

import com.sams.sms.samssms.exception.CallException;

public interface ICallService {

	public void sendCall(String phoneNumber, String message) throws CallException;
}
