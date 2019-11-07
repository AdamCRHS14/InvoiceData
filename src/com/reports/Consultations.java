package com.reports;

import com.datacontainers.Person;

public class Consultations extends Products{
	Person contact;
	String hourlyFee;
	
	public Consultations(String code, String type, String name, Person contact, String hourlyFee) {
		super(code, type, name);
		this.hourlyFee = hourlyFee;
		this.contact = contact;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = "C";
	}

	public String getHourlyFee() {
		return hourlyFee;
	}

	public void setHourlyFee(String hourlyFee) {
		this.hourlyFee = hourlyFee;
	}
	
	
}
