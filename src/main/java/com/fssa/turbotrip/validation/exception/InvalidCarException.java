package com.fssa.turbotrip.validation.exception;

public class InvalidCarException extends Exception{
	private static final long serialVersionUID = -1194860954774008955L;

	public InvalidCarException(String msg) {
		super(msg);
	}

	public InvalidCarException(Throwable e) {
		super(e);
	} 
}
