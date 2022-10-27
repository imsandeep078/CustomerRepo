package com.customer.customExceptions;

@SuppressWarnings("serial")
public class UnableToPersistException extends RuntimeException {

	public UnableToPersistException(String message) {
		super(message);
	}

}
