package com.pegasus.test.veterinarybff.exception;

public class VeterinaryException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VeterinaryException(String msg, Throwable e) {
		super(msg, e);
	}

}
