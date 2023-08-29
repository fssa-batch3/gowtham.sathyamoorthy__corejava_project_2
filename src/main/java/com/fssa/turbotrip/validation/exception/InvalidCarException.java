package com.fssa.turbotrip.validation.exception;
/**
 * This exception class for representing invalid car-related situations.
 */
public class InvalidCarException extends Exception{
	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidCarException(String msg) {
		super(msg);
	}

	public InvalidCarException(Throwable e) {
		super(e);
	} 
}
