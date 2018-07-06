package com.sams.pin.samspin.exception;




public class DAOException extends Exception{

	private static final long serialVersionUID = -2791408155017660877L;

	public DAOException() {
		super("Exception occured in the Data Layer");
	}

	public DAOException(String message) {
		super(message);
	}

}
