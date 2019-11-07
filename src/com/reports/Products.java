package com.reports;

public class Products {
	String code;
	String type;
	String name;
	
	public Products(String code, String type, String name){
		this.code = code;
		this.type = type;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getReport(){
		return null;
	}
	
	
	
}
