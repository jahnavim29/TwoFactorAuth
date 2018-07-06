package com.sams.twofactor.samstwofactor.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.microsoft.azure.documentdb.Document;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.DocumentClientException;
import com.microsoft.azure.documentdb.FeedOptions;
import com.sams.twofactor.samstwofactor.constants.QueryConstants;
import com.sams.twofactor.samstwofactor.exception.DAOException;

@Repository
public class TwoFactorDAO implements ITwoFactorDAO {

	@Autowired
	private DocumentClient client;

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

			throw new DAOException("Unable to retrieve Pin");

		}

		return pin;
	}
	
	public void deletePin(String memberId) throws DAOException {

		Document pinDocument = getDocumentByMemberId(memberId);

		try {

			client.deleteDocument(pinDocument.getSelfLink(), null);

		} catch (DocumentClientException de) {

			throw new DAOException("Unable to delete Pin");

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
