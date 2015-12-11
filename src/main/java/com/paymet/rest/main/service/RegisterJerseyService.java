package com.paymet.rest.main.service;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
@ApplicationPath("/PaymetRest")
public class RegisterJerseyService extends ResourceConfig {
	 public RegisterJerseyService() {
	        register(Service.class);	        
	    }


	
	
	
}
