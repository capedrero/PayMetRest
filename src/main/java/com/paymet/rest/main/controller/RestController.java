package com.paymet.rest.main.controller;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

import org.bson.types.ObjectId;
import org.mongodb.morphia.query.Query;

import com.paymet.rest.main.Exception.RestException;
import com.paymet.rest.main.conf.ConfigurationSpring;
import com.paymet.rest.main.conf.FactoryBeans;
import com.paymet.rest.main.conf.IPropertiesConfiguration;
import com.paymet.rest.main.db.ComparatorProductBean;
import com.paymet.rest.main.db.MorphiaSingleton;
import com.paymet.rest.main.db.bean.BillBean;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.db.bean.ProductBean;

public class RestController implements IRestController{

	private IPropertiesConfiguration msgs;

	public RestController() {
		super();
		msgs = FactoryBeans.getInstance(ConfigurationSpring.class).getBean(IPropertiesConfiguration.class);
	}

	public void saveClient(ClientBean client) {
		MorphiaSingleton.getInstance().getDatastore().save(client);						
	}

	public Collection<ProductBean> getProductsByClient(String id) throws RestException {
		if(!ObjectId.isValid(id)){
			throw new RestException(msgs.getItem(IPropertiesConfiguration.VALIDATION_ID_NO_VALID));
		}
		final Query<ClientBean> query = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class).filter("clientId = ", new ObjectId(id));	
		ClientBean client = query.get();
		if(client==null){
			throw new RestException(msgs.getItem(IPropertiesConfiguration.VALIDATION_WITH_NO_RESULTS));
		}
		Set<ProductBean> setProductBean = new TreeSet<>(new ComparatorProductBean());
		for (BillBean bill : client.getBills()) {
			setProductBean.addAll(bill.getProducts());
		}
				
		return setProductBean;
	}
	
	

}
