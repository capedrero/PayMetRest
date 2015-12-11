package com.paymet.rest.main.db;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;
import com.paymet.rest.main.conf.ConfigurationSpring;
import com.paymet.rest.main.conf.FactoryBeans;
import com.paymet.rest.main.conf.IPropertiesConfiguration;

public class MorphiaSingleton {
		private Morphia morphia;
		private Datastore datastore;
		private MongoClient mongoClient;
		private static MorphiaSingleton instance;
		
		static{
			MorphiaSingleton.instance = new MorphiaSingleton();
		}
		private MorphiaSingleton(){
			IPropertiesConfiguration configdb = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);			
			mongoClient = new MongoClient(configdb.getItem(IPropertiesConfiguration.MONGO_DBHOST), Integer.valueOf(configdb.getItem(IPropertiesConfiguration.MONGO_DBPORT)));
			
			morphia = new Morphia();
			morphia.getMapper().getConverters().addConverter(BigDecimalConverter.class);
			morphia.mapPackage("com.paymet.rest.main.db.bean");
			datastore = morphia.createDatastore(mongoClient, configdb.getItem(IPropertiesConfiguration.MONGO_DBNAME));
			datastore.ensureIndexes();
		}					
		
		public static MorphiaSingleton getInstance(){
			return instance;
		}

		public Datastore getDatastore() {
			return datastore;
		}
		
		
}
