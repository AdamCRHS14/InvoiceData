package com.reports;

import com.reports.*;
import com.datacontainers.*;

public class Invoices {

private String InvoiceCode;
private String Customer;
private String InvDate;
private String Person;
private String  ProductCode;

public Invoices(String InvoiceCode, String Customer, String InvDate, String Person, String ProductCode){
	this.InvoiceCode = InvoiceCode;
	this.Customer = Customer;
	this.InvDate = InvDate;
	this.Person = Person;
	this.ProductCode = ProductCode;
	
}

public Invoices(String string){
}


//Setters & getters
public String getInvoiceCode() {
	return InvoiceCode;
}

public void setInvoiceCode(String invoiceCode) {
	InvoiceCode = invoiceCode;
}

public String getCustomer() {
	return this.Customer;
}

public void setCustomer(String customer) {
	this.Customer = customer;
}

public String getInvDate() {
	return InvDate;
}

public void setInvDate(String invDate) {
	InvDate = invDate;
}

public String getPerson() {
	return this.Person;
}

public void setPerson(String people) {
	this.Person = people;
}

public String getProductCode() {
	return this.ProductCode;
}

public void setProductCode(String productCode) {
	this.ProductCode = productCode;
}

public void Cost(){
	double unitPrice = 0.0;
	int numUnits = 0;
	int total;
	final double ETAX = 0.07; //7% tax
	double TotalE,TotalS,TotalC;
	/*
	  if product is E then
	unitPrice * numunits = total
	total * FINAL ETAX = TotalE
	
	else if product is S then
	days pf service / 365 = TotalS
	
	
	
*/	
}

public String Print(){
	String print = ("=================================\n") +
	("INOVICE DETAIL REPORTS\n")+
	("=================================\n\n") 
	+("---------------------------------\n")+	
	("Invoice: " + this.InvoiceCode + "\n")
	+("---------------------------------\n")
	+("SalesPerson: " + Person)
	+("Customer: " + Customer + "\n\n\n\n")
	+("---------------------------------\n");
	
	String print1 = String.format("%2s %2s %50s %15s %15s %15s\n", "Code",  "Item", "SubTotal", "Taxes", "Fees", "Total");
	
	return print + print1;
}





}
