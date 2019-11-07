package com.fileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import com.datacontainers.Person;
import com.reports.*;
import com.thoughtworks.xstream.XStream;

public class XMLWriter {

	public void xmlConverter1(List<Person> persons) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Persons.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("person", Person.class); 
		for(Person aPerson : persons) {
			// Use toXML method to convert Person object into a String
			String personOutput = xstream.toXML(aPerson);
			xmlPrintWriter.write(personOutput);
		}
		xmlPrintWriter.close();	
	}
	
//Customer	
	public void xmlConverter2(List<Customer> customers) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Customer.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("customer", Customer.class); 
		for(Customer e : customers) {
			// Use toXML method to convert Person object into a String
			String personOutput = xstream.toXML(e);
			xmlPrintWriter.write(personOutput);
		}
		xmlPrintWriter.close();	
	}
	
//Products	
	public void xmlConverter3(List<Products> products) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Products.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("products", Products.class); 
		for(Products e : products) {
			// Use toXML method to convert Person object into a String
			String productsOutput = xstream.toXML(e);
			xmlPrintWriter.write(productsOutput);
		}
		xmlPrintWriter.close();	
	}
}
