package com.exampleportal.Exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exampleportal.Helper.ExceptionResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ExceptionResponse> ResourceNotFoundExceptionHandler(ResourceNotFoundException ex){
		String message=ex.getMessage();
		ExceptionResponse exceptionresponse=new ExceptionResponse(message,false);
		//apiresponse.setMessage(message);
		//apiresponse.setStatus(false);
		return new ResponseEntity<ExceptionResponse>(exceptionresponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadCredentials.class)
	public ResponseEntity<ExceptionResponse> BadCredentialExceptionHandler(BadCredentials ex){
		String message=ex.getMessage();
		ExceptionResponse exceptionresponse=new ExceptionResponse(message,false);
		//apiresponse.setMessage(message);
		//apiresponse.setStatus(false);
		return new ResponseEntity<ExceptionResponse>(exceptionresponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ExceptionResponse> UserAlreadyExistExceptionHandler(UserAlreadyExistsException ex){
		String message=ex.getMessage();
		ExceptionResponse exceptionresponse=new ExceptionResponse(message,false);
		//apiresponse.setMessage(message);
		//apiresponse.setStatus(false);
		return new ResponseEntity<ExceptionResponse>(exceptionresponse,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> HandleMethodArgsNotValidException(MethodArgumentNotValidException ex){
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("ashraf","alam");
		ex.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName=((FieldError) error).getField();
			String message=error.getDefaultMessage();
			map.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);
	}


}
