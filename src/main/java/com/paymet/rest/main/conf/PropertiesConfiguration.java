package com.paymet.rest.main.conf;

import java.util.HashMap;
import java.util.Map;


public class PropertiesConfiguration implements IPropertiesConfiguration {
	private Map<String,String> map;
	
	
	
	public PropertiesConfiguration() {
		super();
		map = new HashMap<>();
	}



	@Override
	public void putItem(String field, String property) {
		map.put(field, property);
	}



	@Override
	public String getItem(String field) {
		return map.get(field);
	}
	

	
	
	

}

