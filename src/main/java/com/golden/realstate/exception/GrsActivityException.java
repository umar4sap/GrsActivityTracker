package com.golden.realstate.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class GrsActivityException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public GrsActivityException(String message) {
		super(message);
	}
	
	
	public GrsActivityException(String message,Throwable throwable) {
		super(message,throwable);
	}
	
	

}
