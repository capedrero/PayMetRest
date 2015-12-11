package com.paymet.rest.main.service;

import java.util.Collection;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.stereotype.Component;

import com.paymet.rest.main.Exception.RestException;
import com.paymet.rest.main.controller.RestController;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.db.bean.ProductBean;

@Component
@Path("/Service")
public class Service {
	private RestController controller;
	
	public Service() {
		super();
		this.controller = new RestController();
		
	}
	

	@GET	
	@Path("/getProductsByClient")
	@Produces({MediaType.APPLICATION_JSON})
	public Response getProductsByClient(@Context UriInfo context) {		
		try{		
			Collection<ProductBean> products = controller.getProductsByClient(new ParameterProcessor(context).getFirstParameter("clientId"));					
			return Response.ok(products).build();
		}catch(RestException ex){	
			return	 Response.ok(ex.getMessage()).build();
		}
		
	}
	
	@POST
	@Path("/saveClient")	
	@Consumes(MediaType.APPLICATION_JSON)
	public Response saveBill(ClientBean client){		
		controller.saveClient(client);	
		return Response.status(Response.Status.CREATED).build();
	}
	
}
