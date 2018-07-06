package com.sams.pin.samspin.exception;

public class PinGenerationException extends Exception {

		public PinGenerationException() {
			super("Error Generating Pin");
		}

		
		public PinGenerationException(String message) {
			super(message);
		}
}
