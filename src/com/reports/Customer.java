package com.reports;

import com.datacontainers.Address;
import com.datacontainers.Person;

public class Customer {
	private String customerCode;
	private String type;
	private Person contact;
	private String name;
	private Address address;
	
	public Customer (String customerCode, String type, Person contact, String name, Address address){
		this.customerCode = customerCode;
		this.type = type;
		this.contact = contact;
		this.name = name;
		this.address = address;
	}

	public String getType() {
		if (type.equals("B")){
			type = "Business";
		}else{
			type = "Residential";
		}
		return type;
	}

	public void setType(String type) {
		if (type.equals("B")){
			this.type = "Business";
		}else{
			this.type = "Residential";
		}
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Person getContact() {
		return contact;
	}

	public void setContact(Person contact) {
		this.contact = contact;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	
}
