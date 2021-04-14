package com.edu.udec.gdmtfl.msgdfiles.controllers;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edu.udec.gdmtfl.msgdfiles.dtos.ErrorDto;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class HandlerExceptionsController extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NoSuchElementException.class })
	public ResponseEntity<Object> noSuchElementException(NoSuchElementException ex, WebRequest request) {

		log.info("HandlerExceptionsController : noSuchElementException {}", ex.getMessage());

		String error = ex.getMessage();

		ErrorDto apiError = new ErrorDto(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST,
				error, null);

		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}

}
