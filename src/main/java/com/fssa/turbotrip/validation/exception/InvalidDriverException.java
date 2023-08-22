package com.fssa.turbotrip.validation.exception;

public class InvalidDriverException extends Exception {
	
		private static final long serialVersionUID = -1194860954774008955L;

		public InvalidDriverException(String msg) {
			super(msg);
		}

		public InvalidDriverException(Throwable e) {
			super(e);
		} 
}
