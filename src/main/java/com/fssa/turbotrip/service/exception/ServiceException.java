package com.fssa.turbotrip.service.exception;
/**
 * Custom exception class for representing service related situations.
 */
public class ServiceException extends Exception {
	private static final long serialVersionUID = -8508529215117096666L;

	public ServiceException(String msg) {
		super(msg);
	}

	public ServiceException(Throwable e) {
		super(e);
	}
}
