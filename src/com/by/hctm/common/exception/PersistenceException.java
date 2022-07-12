package com.by.hctm.common.exception;

import com.by.base.exception.BaseException;

/**
 * @author ted
 */
public class PersistenceException extends BaseException {

	private static final long serialVersionUID = 1L;


	public PersistenceException(String message) {
		super(message);
	}
	
	
	public PersistenceException(Throwable cause) {
		super(cause);
	}

}
