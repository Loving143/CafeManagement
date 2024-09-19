package com.cafe.exceptions;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cafe.response.ResponseMessage;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public  ResponseEntity<ResponseMessage<?>> handleBadRequestException(BadRequestException ex){
		ResponseMessage<?> message = new ResponseMessage<String>("0",ex.getMessage());
		return new ResponseEntity<>(message , HttpStatus.BAD_REQUEST);
	}

}
