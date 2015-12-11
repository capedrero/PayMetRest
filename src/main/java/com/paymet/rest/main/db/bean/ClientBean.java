package com.paymet.rest.main.db.bean;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.paymet.rest.main.db.NoObjectIdSerializer;

@Entity("Client")
public class ClientBean {

	@Id
	@JsonSerialize(using = NoObjectIdSerializer.class)
	private ObjectId clientId;
	private String name;
	private String surname;
	private String address;
	private Long phoneNumber;
	@Reference
	private List<BillBean> bills;
	

	public ClientBean() {
		this.bills = new ArrayList<>();
	}
	public void setClientId(ObjectId clientId) {
		this.clientId = clientId;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void addBill(BillBean bill) {
		if(bill!=null){
			this.bills.add(bill);
		}
	}	

	public ObjectId getClientId() {
		return clientId;
	}
	public List<BillBean> getBills() {
		return bills;
	}
	
	public void setBills(List<BillBean> bills) {
		this.bills = bills;
	}
	
	public String getName() {
		return name;
	}
	public String getSurname() {
		return surname;
	}
	public String getAddress() {
		return address;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	@Override
	public String toString() {
		return "ClientBean [" + (clientId != null ? "clientId=" + clientId + ", " : "")
				+ (name != null ? "name=" + name + ", " : "") + (surname != null ? "surname=" + surname + ", " : "")
				+ (address != null ? "address=" + address + ", " : "")
				+ (phoneNumber != null ? "phoneNumber=" + phoneNumber + ", " : "")
				+ (bills != null ? "bills=" + bills : "") + "]";
	}
	
	
	
	

}
