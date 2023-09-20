package com.fssa.turbotrip.validation.exception;

public class InvalidBookingException extends Exception {
	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidBookingException(String msg) {
		super(msg);
	}

	public InvalidBookingException(Throwable e) {
		super(e);
	} 

}
