package com.reports;

import java.util.Date;

public class Services extends Products {
	String activationFee;
	String annualFee;
	String startDate;
	String endDate;
	
	public Services(String code, String type, String name, String activationFee, String annualFee) {
		super(code, type, name);
		this.activationFee = activationFee;
		this.annualFee = annualFee;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = "S";
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getActivationFee() {
		return activationFee;
	}
	public void setActivationFee(String activationFee) {
		this.activationFee = activationFee;
	}
	public String getAnnualFee() {
		return annualFee;
	}
	public void setAnnualFee(String annualFee) {
		this.annualFee = annualFee;
	}
	
	private static long daysBetween(Date one, Date two) {
        long difference =  (one.getTime()-two.getTime())/86400000;
        return Math.abs(difference);
    }
	//@Override
	//public String getReport(){
//		return (this.code + " " + this);
	//}

}
