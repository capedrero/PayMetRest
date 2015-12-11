package com.paymet.rest.main.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan({ "com.paymet.rest.main.conf" })
@PropertySource({ "config.properties","msg.properties" })
public class ConfigurationSpring {
	@Autowired
	private Environment environment;

	@Bean
	public IPropertiesConfiguration getPropertiesConfiguration() {
		IPropertiesConfiguration config = new PropertiesConfiguration();
		for (String field: IPropertiesConfiguration.NAMES.values()) {
			config.putItem(field, environment.getProperty(field));
		}
				
		return config;
	}
	
}
