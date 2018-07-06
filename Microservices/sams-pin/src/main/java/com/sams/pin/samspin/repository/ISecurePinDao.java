package com.sams.pin.samspin.repository;

import com.microsoft.azure.documentdb.Document;
import com.sams.pin.samspin.exception.DAOException;

public interface ISecurePinDao {

	public void saveSecurePin(String memberId, String pin, String appId, int expiry) throws DAOException;
	
	public String getPin(String memberId) throws DAOException;
	
	public void deletePin(String memberId) throws DAOException;
	
	public Document getDocumentByMemberId(String memberId) throws DAOException;
}
