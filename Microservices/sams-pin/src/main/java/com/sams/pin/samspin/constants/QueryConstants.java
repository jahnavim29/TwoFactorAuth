package com.sams.pin.samspin.constants;

public class QueryConstants {

	
	public static final String MEMBER_COLLECTION = "/dbs/memsync/colls/membershipsearch";
	
	public static final String TWO_FACTOR_COLLECTION ="/dbs/memsync/colls/twofactor";
	
	public static final String GET_MEMBER_EMAIL = "SELECT membershipsearch.loginEmailId FROM membershipsearch where membershipsearch.membershipSeventeen='" ;
	
	public static final String GET_MEMBER_PHONE = "SELECT membershipsearch.loginPhoneNumber FROM membershipsearch where membershipsearch.membershipSeventeen='";
	
	public static final String GET_PIN = "SELECT twofactor.pin FROM twofactor where twofactor.memberId='";

	public static final String GET_DOCUMENT = "SELECT * FROM twofactor where twofactor.memberId='";
	
	
	
}
