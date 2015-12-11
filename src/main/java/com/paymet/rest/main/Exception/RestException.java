package com.paymet.rest.main.Exception;

public class RestException extends Throwable{

	private static final long serialVersionUID = 1L;

	public RestException(String item) {
		super(item);
	}
	
}
