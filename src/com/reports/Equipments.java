package com.reports;

public class Equipments extends Products{
	String pricePerUnit;
	public Equipments(String code, String type, String name, String pricePerUnit) {
		super(code, type, name);
		this.code = code;
		this.type = type;
		this.pricePerUnit = pricePerUnit;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = "E";
	}
	public String getPricePerUnit() {
		return pricePerUnit;
	}
	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}
	
	

}
