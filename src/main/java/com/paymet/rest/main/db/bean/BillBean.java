package com.paymet.rest.main.db.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paymet.rest.main.db.NoObjectIdSerializer;
@Entity("Bill")
public class BillBean {

	@Id
	@JsonSerialize(using = NoObjectIdSerializer.class)
	private ObjectId billId;
	private Date billDate;
	@Reference
	private List<ProductBean> products;

	public BillBean() {
		this.billDate = new Date();
		this.products = new ArrayList<>();
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}	
	public void addProduct(ProductBean product) {
		if(this.products!=null){
			this.products.add(product);
		}
	}
	public List<ProductBean> getProducts() {
		return products;
	}
	

	public ObjectId getBillId() {
		return billId;
	}

	public Date getBillDate() {
		return billDate;
	}

	@Override
	public String toString() {
		return "BillBean [" + (billId != null ? "billId=" + billId + ", " : "")
				+ (billDate != null ? "billDate=" + billDate + ", " : "")
				+ (products != null ? "products=" + products : "") + "]";
	}	
	
	
	
	
	
}
