package com.paymet.rest.test;

import org.junit.Test;
import org.mongodb.morphia.query.Query;

import com.paymet.rest.main.db.MorphiaSingleton;
import com.paymet.rest.main.db.bean.BillBean;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.db.bean.ProductBean;

public class TestMorphia {
	@Test
	public void initDB() {
		final Query<ClientBean> clientsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ClientBean.class);
		MorphiaSingleton.getInstance().getDatastore().delete(clientsQuery);
		
		final Query<BillBean> billsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(BillBean.class);
		MorphiaSingleton.getInstance().getDatastore().delete(billsQuery);
		
		final Query<ProductBean> productsQuery = MorphiaSingleton.getInstance().getDatastore().createQuery(ProductBean.class);
		MorphiaSingleton.getInstance().getDatastore().delete(productsQuery);
		
		FakeBeansDB fakeBeans = new FakeBeansDB();
		MorphiaSingleton.getInstance().getDatastore().save(fakeBeans.getProductBeans());
		MorphiaSingleton.getInstance().getDatastore().save(fakeBeans.getBillBeans());		
		MorphiaSingleton.getInstance().getDatastore().save(fakeBeans.getClientBeans());
				
	}

}
