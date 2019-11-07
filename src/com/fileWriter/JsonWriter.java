package com.fileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

import com.datacontainers.Person;
import com.reports.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {
	
	public void jsonConverter1(List<Person> persons) {
		
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Persons.json");
		
		PrintWriter jsonPrintWriter = null;
		
		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		for(Person aPerson : persons) {
			// Use toJson method to convert Person object into a String
			String personOutput = gson.toJson(aPerson); 
			jsonPrintWriter.write(personOutput + "\n");
		}
		
		jsonPrintWriter.close();
	}
//Customers	
	public void jsonConverter2(List<Customer> customers) {
		
		//Gson gson = new Gson();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Customers.json");
		
		PrintWriter jsonPrintWriter = null;
		
		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		for(Customer e : customers) {
			// Use toJson method to convert Person object into a String
			String customersOutput = gson.toJson(e); 
			jsonPrintWriter.write(customersOutput + "\n");
		}
		
		jsonPrintWriter.close();
	}

//Products	
	public void jsonConverter3(List<Products> products) {
	
	//Gson gson = new Gson();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	File jsonOutput = new File("data/Products.json");
	
	PrintWriter jsonPrintWriter = null;
	
	try {
		jsonPrintWriter = new PrintWriter(jsonOutput);
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	} 
	
	for(Products e : products) {
		// Use toJson method to convert Person object into a String
		String productsOutput = gson.toJson(e); 
		jsonPrintWriter.write(productsOutput + "\n");
	}
	
	jsonPrintWriter.close();
}
}
