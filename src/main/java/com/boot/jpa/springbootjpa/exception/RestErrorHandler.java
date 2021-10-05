package com.boot.jpa.springbootjpa.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.server.ResponseStatusException;

@RestControllerAdvice
public class RestErrorHandler {

	//private static final Logger logger = LoggerFactory.getLogger(RestErrorHandler.class);

	@ExceptionHandler(ResponseStatusException.class)
	ResponseEntity<?> handleStatusException(ResponseStatusException ex, WebRequest request) {
		//logger.error(ex.getReason(), ex);
		return RestResponse.builder().exception(ex).path(request.getDescription(false).substring(4)).entity();
	}
	
	@ExceptionHandler(StudentNotFoundException.class)
	ResponseEntity<?> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request){
		RestResponse restResponse = new RestResponse();
		restResponse.setMessage(ex.getErrorMessage());
		restResponse.setStatus(ex.getErrorCode().value());
		return new ResponseEntity<>(restResponse,ex.getErrorCode());
	}
}
