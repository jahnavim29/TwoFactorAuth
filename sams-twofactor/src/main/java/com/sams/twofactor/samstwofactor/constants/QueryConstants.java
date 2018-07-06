package com.sams.twofactor.samstwofactor.constants;

public class QueryConstants {

	public static final String TWO_FACTOR_COLLECTION = "/dbs/memsync/colls/twofactor";

	public static final String GET_PIN = "SELECT twofactor.pin FROM twofactor where twofactor.memberId='";

	public static final String GET_DOCUMENT = "SELECT * FROM twofactor where twofactor.memberId='";
}
