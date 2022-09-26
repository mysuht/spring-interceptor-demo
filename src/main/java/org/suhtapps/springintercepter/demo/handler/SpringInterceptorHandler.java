package org.suhtapps.springintercepter.demo.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.suhtapps.springintercepter.demo.exception.InvalidFieldException;
import org.suhtapps.springintercepter.demo.exception.InvalidHeaderFieldException;

@RestControllerAdvice
public class SpringInterceptorHandler {

	@ExceptionHandler
	public String handleInvalidFieldException(InvalidFieldException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleInvalidHeaderFieldException(InvalidHeaderFieldException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.PRECONDITION_FAILED);
	}
}
