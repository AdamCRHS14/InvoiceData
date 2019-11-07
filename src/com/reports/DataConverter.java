package com.reports;

import java.sql.*;
import java.util.List;
import com.datacontainers.Person;
import com.reports.*;
import com.fileReader.FlatFileReader;
import com.fileWriter.JsonWriter;
import com.fileWriter.XMLWriter;
import com.mwc.ext.InvoiceData;

public class DataConverter {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		// Create a FlatFileReader object
		FlatFileReader fr = new FlatFileReader();
		
		
		
		// Write Person ArrayList into a Json file
		JsonWriter jWriter = new JsonWriter();
		jWriter.jsonConverter1(personList);
		jWriter.jsonConverter2(customerList);
		jWriter.jsonConverter3(productsList);
		
		
		// Write Person ArrayList into an XML file
		 XMLWriter xmlWriter = new XMLWriter();
	     xmlWriter.xmlConverter1(personList);
	     xmlWriter.xmlConverter2(customerList);
	     xmlWriter.xmlConverter3(productsList);
	}
}
