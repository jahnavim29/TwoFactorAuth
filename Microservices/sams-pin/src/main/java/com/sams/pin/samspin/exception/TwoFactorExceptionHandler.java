package com.sams.pin.samspin.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.sams.pin.samspin.utils.ValidationUtils;


@ControllerAdvice
@RestController
public class TwoFactorExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	
	
	@ExceptionHandler(PinGenerationException.class)
	public final ResponseEntity<ExceptionResponse> handleGenerationException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@Override
	  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
	      HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse errorDetails = new ExceptionResponse(new Date(), "Invalid inputs",
				ValidationUtils.fromBindingErrors( ex.getBindingResult()).toString());
		
	    return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	  } 

}
