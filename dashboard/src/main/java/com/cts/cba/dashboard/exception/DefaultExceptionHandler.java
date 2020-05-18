package com.cts.cba.dashboard.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {
    
    Logger log = LoggerFactory.getLogger(DefaultExceptionHandler.class);
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception exception){
        log.error("Response: {}", exception.getMessage());
        ErrorMessage response=new ErrorMessage(exception.getMessage(), "Kindly check the path variables or end points !");
        
        return new ResponseEntity<ErrorMessage>(response,HttpStatus.METHOD_FAILURE);
    }
}

class ErrorMessage{
    private String message;
    private String details;

    public ErrorMessage(String message, String details){
        super();
        this.message=message;
        this.details=details;
    }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}
    
}