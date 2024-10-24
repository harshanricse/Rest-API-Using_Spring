package com.infytel.exceptions;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.infytel.util.InfyTelConstants;


 
@RestControllerAdvice
public class GlobalExceptionHandler 
{
	@Autowired
	private Environment environment;
	//Generalized handler
	/*Its not mandatory to mention the type in the @ExceptionHandler as it refers to the type of the method 
	 * parameter by default. But, mentioning the type will make the code more readable.
	 * Mentioning the type in @ExceptionHandler is mandatory when there are multiple types of exceptions to 
	 * be handled by a single handler
	 */
	@ExceptionHandler(Exception.class) 
	public ResponseEntity<ErrorMessage> generalExceptionHandler(Exception ex) 
	{
		 ErrorMessage error = new ErrorMessage();
	     error.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
	     error.setMessage(environment.getProperty(InfyTelConstants.GENERAL_EXCEPTION_MESSAGE.toString()));
	     return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	//Handler for CustomerNotFoundException
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorMessage> customerNotFoundExceptionHandler(CustomerNotFoundException ex) 
	{
		 ErrorMessage error = new ErrorMessage();
	     error.setErrorCode(HttpStatus.BAD_REQUEST.value());
	     error.setMessage(ex.getMessage());
	     return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		 
	}
	
	//Handler for validation failures w.r.t DTOs
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumentExceptionHandler(MethodArgumentNotValidException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
			        		                                  .collect(Collectors.joining(", ")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
			
	//Handler for validation failures w.r.t URI parameters
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> constraintViolationExceptionHandler(ConstraintViolationException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		error.setErrorCode(HttpStatus.BAD_REQUEST.value());
		error.setMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
			        		                          .collect(Collectors.joining(", ")));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
} 