package com.customer.controllerExceptions;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.customer.customExceptions.CustomerNotFoundException;
import com.customer.customExceptions.IdNotFoundException;
import com.customer.customExceptions.UnableToPersistException;

@RestControllerAdvice
public class AdviceExceptionHandler {

	private Map<String, String> errorMap = new HashMap<>();

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> invalidHandlerException(MethodArgumentNotValidException exception) {
		exception.getBindingResult().getFieldErrors().forEach(error -> {
			errorMap.put(error.getField(), error.getDefaultMessage());
		});
		return errorMap;
	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(NonUniqueResultException.class) public Map<String, String>
	 * NonUniqueResultHandlerException(NonUniqueResultException exception) {
	 * errorMap.put("errorMessage", exception.getMessage()); return errorMap; }
	 */

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(CustomerNotFoundException.class)
	public Map<String, String> customerNotFoundHandlerException(CustomerNotFoundException exception) {
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;

	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(IdNotFoundException.class)
	public Map<String, String> IdNotFoundHandlerException(IdNotFoundException exception) {
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;

	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(UnableToPersistException.class)
	public Map<String, String> UnableToPersistHandlerException(UnableToPersistException exception) {
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;

	}

	/*
	 * @ResponseStatus(HttpStatus.BAD_REQUEST)
	 * 
	 * @ExceptionHandler(NullPointerException.class) public Map<String, String>
	 * NullPointerHandlerException(NullPointerException exception) {
	 * errorMap.put("errorMessage", exception.getMessage()); return errorMap;
	 * 
	 * }
	 */

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(SQLException.class)
	public Map<String, String> sqlException(SQLException exception) {
		errorMap.put("errorMessage", exception.getMessage());
		return errorMap;

	}
}
