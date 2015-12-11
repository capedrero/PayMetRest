package com.paymet.rest.test;

import static com.jayway.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.paymet.rest.main.conf.ConfigurationSpring;
import com.paymet.rest.main.conf.FactoryBeans;
import com.paymet.rest.main.conf.IPropertiesConfiguration;
import com.paymet.rest.main.db.MorphiaSingleton;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.db.bean.ProductBean;
import com.paymet.rest.main.service.ApplicationMainForIntegrationTest;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationMainForIntegrationTest.class)
@WebAppConfiguration
//Random Port 
@IntegrationTest("server.port:0")	
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestServiceGet {
	
@Value("${local.server.port}")
	
	private int serverPort;	
	private IPropertiesConfiguration config;
	 	 
	@Before
	public void setUp(){
		RestAssured.port=serverPort;
	    RestAssured.baseURI = "http://localhost";
	    RestAssured.basePath = "/PaymetRest/Service";
	    config = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);
	}
	@Test
	public void testGetProductsByClient(){
		try {
			new TestMorphia().initDB();
			final Query<ClientBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).limit(1);
			Assert.assertNotNull(clientsQuery);
	
			 Response response = 
					 given().contentType(ContentType.JSON).
					queryParam("clientId", clientsQuery.get().getClientId().toHexString()).				
			when().
					get("/getProductsByClient").
			then().
					statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode()).
					 extract().response(); 
			 
			 List<ProductBean> products = getStringAsListObject(response.asString(), ProductBean.class);
			 
			 
			 Assert.assertTrue(products.size()>0);
	
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	
	@Test
	public void testGetProductsByClientNotExists(){
		try {
			new TestMorphia().initDB();
			final Query<ClientBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).limit(1);
			Assert.assertNotNull(clientsQuery);
	
			 Response response = 
					 given().contentType(ContentType.JSON).
					queryParam("clientId", "5669b84c99836f1dd870ebb3").				
			when().
					get("/getProductsByClient").
			then().
					statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode()).
					 extract().response(); 
			 			 
			 Assert.assertEquals(config.getItem(IPropertiesConfiguration.VALIDATION_WITH_NO_RESULTS), response.asString());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	@Test
	public void testGetProductsByClientInvalidId(){
		try {
			new TestMorphia().initDB();
			final Query<ClientBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).limit(1);
			Assert.assertNotNull(clientsQuery);
	
			 Response response = 
					 given().contentType(ContentType.JSON).
					queryParam("clientId", "1").				
			when().
					get("/getProductsByClient").
			then().
					statusCode(javax.ws.rs.core.Response.Status.OK.getStatusCode()).
					 extract().response(); 
			 
			 Assert.assertEquals(config.getItem(IPropertiesConfiguration.VALIDATION_ID_NO_VALID), response.asString());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(e.getMessage());

		}
	}
	
	
	private <T> List<T> getStringAsListObject(String output, Class<T> typeBean) throws IOException, JsonProcessingException {
		
		ObjectMapper mapper = new ObjectMapper();
		ObjectReader reader = mapper.readerFor(CollectionType.construct(List.class, SimpleType.construct(typeBean)));			
		
		List<T> myList = reader.readValue(output);
		return myList;
	}


}
