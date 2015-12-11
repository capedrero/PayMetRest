package com.paymet.rest.test;

import static com.jayway.restassured.RestAssured.given;

import javax.ws.rs.core.Response;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mongodb.morphia.query.Query;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.paymet.rest.main.db.MorphiaSingleton;
import com.paymet.rest.main.db.bean.BillBean;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.service.ApplicationMainForIntegrationTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
//Random Port 
@IntegrationTest("server.port:0")	
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServicePost {
	
@Value("${local.server.port}")
	
	private int serverPort;	

	private TestMorphia testMorphia;
	 	 
	@Before
	public void setUp(){
		RestAssured.port=serverPort;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/PaymetRest/Service";
	    testMorphia = new TestMorphia();
	    testMorphia.initDB();
	}
	@Test
	public void testPost(){
		try {	
			Query<ClientBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).limit(1);
			Assert.assertNotNull(clientsQuery);			
			ClientBean client = clientsQuery.get();
			Assert.assertEquals(client.getBills().size(), 1);
			Query<BillBean> billsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(BillBean.class);	
			client.setBills(billsQuery.asList());			
			Assert.assertEquals(client.getBills().size(), 2);
			
			given().contentType(ContentType.JSON).
			body(client).		
			when().post("/saveClient").			
			then().statusCode(Response.Status.CREATED.getStatusCode());			
			
			clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).limit(1);
			Assert.assertNotNull(clientsQuery);			
			client = clientsQuery.get();
			Assert.assertEquals(client.getBills().size(), 2);
			 			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
			
	

}
