package com.paymet.rest.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.paymet.rest.main.db.bean.BillBean;
import com.paymet.rest.main.db.bean.ClientBean;
import com.paymet.rest.main.db.bean.ProductBean;

public class FakeBeansDB {
	private List<ProductBean> products;
	private List<BillBean> bills;
	private List<ClientBean> clients;
	
	public List<ProductBean> getProductBeans(){
		if(products!=null){
			return products;
		}
		products = new ArrayList<>();
		ProductBean product = new ProductBean();
		product.setName("tablet");
		product.setPrice(new BigDecimal("200.6"));
		product.setStock(100);
		products.add(product);
		
		product = new ProductBean();
		product.setName("smartphone");
		product.setPrice(new BigDecimal("150.0"));
		product.setStock(200);
		products.add(product);
		
		product = new ProductBean();
		product.setName("keyboard");
		product.setPrice(new BigDecimal("10.0"));
		product.setStock(500);
		products.add(product);
		
		return products;
		
	}
	
	public List<BillBean> getBillBeans(){
		if(bills!=null){
			return bills;
		}
		List<ProductBean> products = getProductBeans();
		bills = new ArrayList<>();
		BillBean bill= new BillBean();	
		bill.addProduct(products.get(0));
		bill.addProduct(products.get(1));
		bills.add(bill);
		
		bill= new BillBean();	
		bill.addProduct(products.get(0));
		bill.addProduct(products.get(1));
		bill.addProduct(products.get(2));
		bills.add(bill);
		
		return bills;
		
	}
	
	public List<ClientBean> getClientBeans(){
		if(clients!=null){
			return clients;
		}
		List<BillBean> bills = getBillBeans();
		clients = new ArrayList<>();
		
		ClientBean client = new ClientBean();
		client.setAddress("Avenida de Santa Eugenia 1, Madrid");
		client.setName("Roberto");
		client.setSurname("Lopez");
		client.setPhoneNumber(666000001l);
		client.addBill(bills.get(0));
		clients.add(client);
		
		client = new ClientBean();
		client.setAddress("Plaza Castilla 1, Madrid");
		client.setName("Alvaro");
		client.setSurname("Perez");
		client.setPhoneNumber(666000002l);
		client.addBill(bills.get(0));
		client.addBill(bills.get(1));
		

		clients.add(client);
		
		return clients;
		
	}

}
