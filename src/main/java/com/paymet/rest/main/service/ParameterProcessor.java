package com.paymet.rest.main.service;

import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

public class ParameterProcessor implements IParameterProcessor{
	private UriInfo context; 

	public ParameterProcessor() {
	}
	
	public ParameterProcessor(UriInfo context) {
		super();
		this.context = context;
	}

	@Override
	public void setContext(UriInfo context) {
		this.context = context;
	}
	@Override
	public MultivaluedMap<String, String> getMap() {
		return context.getQueryParameters();
	}
	
	@Override
	public String getFirstParameter(final String key) {		
		return context.getQueryParameters().getFirst(key);
	}
	
	

}
