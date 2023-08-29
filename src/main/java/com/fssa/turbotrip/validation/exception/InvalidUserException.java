package com.fssa.turbotrip.validation.exception;
/**
 * This exception class for representing invalid User-related situations.
 */
public class InvalidUserException  extends Exception {
	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidUserException(String msg) {
		super(msg);
	}

	public InvalidUserException(Throwable e) {
		super(e);
	} 
}
