package com.mv.api.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

	@ExceptionHandler(value = ResourseNotAvailableException.class)
	public ResponseEntity<Object> resourseNotFoundExceptionHandler(ResourseNotAvailableException exception) {
		LOGGER.error(exception.getMessage(), exception.getCause());
		return ResponseEntity.notFound().build();
	}
}
