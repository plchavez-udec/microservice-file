package com.edu.udec.gdmtfl.msgdfiles.controllers;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edu.udec.gdmtfl.msgdfiles.dtos.ErrorDto;
import com.edu.udec.gdmtfl.msgdfiles.exceptions.GeneralException;

import lombok.extern.log4j.Log4j2;

@Log4j2
@ControllerAdvice
public class HandlerExceptionsController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NoSuchElementException.class })
	public ResponseEntity<Object> noSuchElementException(NoSuchElementException ex, 
														 WebRequest request) {
		log.info("noSuchElementException {}", ex.getMessage());
		String error = ex.getMessage();
		ErrorDto apiError = new ErrorDto(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				HttpStatus.BAD_REQUEST,
				error,
				null);
		
		return new ResponseEntity<>(
				apiError, 
				new HttpHeaders(),
				apiError.getStatus());
	}
	
	@ExceptionHandler({ Exception.class })
	public ResponseEntity<Object> handleAll(Exception ex, WebRequest request) {
		log.info("handleAll {}", ex.getMessage());
		ErrorDto apiError = new ErrorDto(
				LocalDateTime.now(), 
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				HttpStatus.INTERNAL_SERVER_ERROR, 
				ex.getLocalizedMessage(), 
				Arrays.asList(ex.getMessage()));

		return new ResponseEntity<Object>(
				apiError, 
				new HttpHeaders(), 
				apiError.getStatus());
	}
	
	@ExceptionHandler({ GeneralException.class })
	public ResponseEntity<Object> generalException(GeneralException ex, WebRequest request) {
		String error = ex.getMessage();
		ErrorDto apiError = new ErrorDto(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				HttpStatus.BAD_REQUEST,
				error, Arrays.asList(error));
		
		return new ResponseEntity<>(
				apiError, 
				new HttpHeaders(), 
				apiError.getStatus());
	}

}
