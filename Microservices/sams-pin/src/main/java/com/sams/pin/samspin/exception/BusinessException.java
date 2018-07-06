package com.sams.pin.samspin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessException extends Exception {
		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		public BusinessException() {
			super("Error processing the request");
		}

		
		public BusinessException(String message) {
			super(message);
		}
	}