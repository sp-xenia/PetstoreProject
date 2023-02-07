package it.xenia.petstore.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { Exception.class })
    public final ResponseEntity<Object> handleAllExceptions(Exception exception, WebRequest request) {
        String bodyOfResponse = exception.getMessage();
        return handleExceptionInternal(exception, bodyOfResponse, 
                new HttpHeaders(), HttpStatus.CONFLICT, request);
    }

   @ExceptionHandler(value = { NotFoundException.class })
    public final ResponseEntity<Object> handleNotFoundException(NotFoundException notFoundException, WebRequest request) {
    	String bodyOfResponse = notFoundException.getMessage();
    	return handleExceptionInternal(notFoundException, bodyOfResponse, 
                new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}	
