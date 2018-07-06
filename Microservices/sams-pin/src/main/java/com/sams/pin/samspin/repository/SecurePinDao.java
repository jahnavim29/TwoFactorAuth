package com.sams.pin.samspin.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Repository;

import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.FeedOptions;
import com.microsoft.azure.documentdb.RequestOptions;
import com.sams.pin.samspin.constants.QueryConstants;
import com.sams.pin.samspin.exception.DAOException;
import com.sams.pin.samspin.model.SecurePin;


@Repository
public class SecurePinDao implements ISecurePinDao{

	@Autowired
	private DocumentClient client;
	
	@Autowired
	private Environment env;
	
	public void saveSecurePin(String memberId, String pin, String appId, int expiry) throws DAOException {
		try {

			SecurePin pindetails = new SecurePin();
			pindetails.setId(UUID.randomUUID().toString());
			pindetails.setMemberId(memberId);
			pindetails.setPin(pin);
			pindetails.setAppId(appId);
			if (expiry != 0) {
				pindetails.setTtl(expiry);
			} else {
				pindetails.setTtl(Integer.parseInt(env.getProperty("twofactor.ttl")));
			}
			client.createDocument(QueryConstants.TWO_FACTOR_COLLECTION, pindetails, new RequestOptions(), true);

		}

		catch (DocumentClientException de) {

			throw new DAOException("Unable to Save Pin");

		}

	}

	public String getPin(String memberId) throws DAOException {
		String pin = "";
		try {

			FeedOptions queryOptions = new FeedOptions();
			queryOptions.setPageSize(-1);
			queryOptions.setEnableCrossPartitionQuery(true);

			List<Document> queryResults = client.queryDocuments(QueryConstants.TWO_FACTOR_COLLECTION,
					QueryConstants.GET_PIN + memberId + "'", queryOptions).getQueryIterable().toList();

			if (queryResults.size() > 0) {
				pin = queryResults.get(0).get("pin").toString();
			}
		} catch (Exception e) {

			throw new DAOException("Unable to check if there is an existing Pin");

		}

		return pin;
	}

	public void deletePin(String memberId) throws DAOException {

		Document pinDocument = getDocumentByMemberId(memberId);

		try {

			client.deleteDocument(pinDocument.getSelfLink(), null);

		} catch (DocumentClientException de) {

			throw new DAOException("Unable to delete existing Pin");

		}

	}

	public Document getDocumentByMemberId(String memberId) throws DAOException {

		try {

			FeedOptions queryOptions = new FeedOptions();
			queryOptions.setPageSize(-1);
			queryOptions.setEnableCrossPartitionQuery(true);

			List<Document> queryResults = client.queryDocuments(QueryConstants.TWO_FACTOR_COLLECTION,
					QueryConstants.GET_DOCUMENT + memberId + "'", queryOptions).getQueryIterable().toList();

			if (queryResults.size() > 0) {
				return queryResults.get(0);
			}

			else {
				return null;
			}
		} catch (Exception e) {

			throw new DAOException("Unable to retrieve Pin");

		}

	}

}
