package com.sams.twofactor.samstwofactor.repository;

import com.microsoft.azure.documentdb.Document;
import com.sams.twofactor.samstwofactor.exception.DAOException;

public interface ITwoFactorDAO {


	public String getPin(String memberId) throws DAOException;
	
	public void deletePin(String memberId) throws DAOException;
	
	public Document getDocumentByMemberId(String memberId) throws DAOException;
	
}
