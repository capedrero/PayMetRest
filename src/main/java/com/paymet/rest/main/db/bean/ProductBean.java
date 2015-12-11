package com.paymet.rest.main.db.bean;

import java.math.BigDecimal;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paymet.rest.main.db.NoObjectIdSerializer;

@Entity("Product")
public class ProductBean {

	@Id
	@JsonSerialize(using = NoObjectIdSerializer.class)
	private ObjectId productId;
	private String name;
	private BigDecimal price;
	private Integer stock;
	
	
	public String getName() {
		return name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setProductId(ObjectId productId) {
		this.productId = productId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public ObjectId getProductId() {
		return productId;
	}
	@Override
	public String toString() {
		return "ProductBean [" + (productId != null ? "productId=" + productId + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (price != null ? "price=" + price + ", " : "")
				+ (stock != null ? "stock=" + stock : "") + "]";
	}
	
	
	
	
	

}
