package com.infytel.exceptions;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

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
} 