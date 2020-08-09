package com.mv.api.exception;

public class ResourseNotAvailableException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5999265064188729936L;

	public ResourseNotAvailableException(String s) {
		super(s);
	}

	public ResourseNotAvailableException(String s, Throwable t) {
		super(s, t);
	}

}
