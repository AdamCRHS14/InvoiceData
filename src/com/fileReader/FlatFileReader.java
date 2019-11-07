package com.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.*;
import java.util.List;
import java.util.Scanner;
import com.datacontainers.Address;
import com.datacontainers.Person;
import com.reports.*;
import com.mwc.ext.InvoiceData;

public class FlatFileReader {
	
	public ArrayList<Person> readPersons() {
	Scanner sc = null;
	
		
		try {
			sc = new Scanner(new File("data/Persons.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			// This Person ArrayList stores the Person objects 
			ArrayList<Person> personList = new ArrayList<Person>();
			String email = "";
			
			while(sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a tring array 
				
				// Stores the 4 array elements of each line into strings
				String personCode = data[0];
				String stuff[] = data[1].split(","); //Splits up the combined line of code with commas
				String lastName = stuff[0];
				String firstName = stuff[1];
				String location[] = data[2].split(",");
				String street = location[0];
				String city = location[1];
				String state = location[2];
				String zipCode =location[3];
				String country = location[4];
				InvoiceData.addPerson(personCode, firstName, lastName, street, city, state, zipCode, country);
				if(data.length == 3){
					email = "N/A";
				}else{
					email = data[3];
					InvoiceData.addEmail(personCode, email);
				}
				
				// Creates an Address object
				Address address = new Address(street, city, state, zipCode, country);
				
				// Creates a Person object
				Person person = new Person(personCode, firstName, lastName, address, email);
				
				// Adds the Person object into Person ArrayList
				personList.add(person);
			}
			sc.close();
			return personList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}	
	}

	public ArrayList<Customer> readCustomer() {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("data/Customers.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			// This Person ArrayList stores the Person objects 
			ArrayList<Customer> customerList = new ArrayList<Customer>();
			Person contact = null;
			
			while(sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a tring array 
				
				// Stores all the array elements of each line into strings
				String customerCode = data[0];
				String Type = data[1];
				String number = data[2];
				for (Person e : this.readPersons()){
					if (e.getPersonCode().equals(number)){
						contact = e;
						break;
					}
				}
				String name = data[3];
				String[] location = data[4].split(",");
				String street = location[0];
				String city = location[1];
				String state = location[2];
				String zipCode = location[3];
				String country = location[4];
				InvoiceData.addCustomer(customerCode, Type, number, name, street, city, state, zipCode, country);
				// Creates an Address object
				Address address = new Address(street, city, state, zipCode, country);
				
				// Creates a Person object
				Customer customer = new Customer(customerCode, Type, contact, name, address);
				
				// Adds the Person object into Person ArrayList
				customerList.add(customer);
			}
			sc.close();
			return customerList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public ArrayList<Products> readProducts() {
		Scanner sc = null;
		
		try {
			sc = new Scanner(new File("data/Products.dat"));
			sc.nextLine(); // reads the number of records from the first line
			
			// This Person ArrayList stores the Person objects 
			ArrayList<Products> productsList = new ArrayList<Products>();
			Person contact = null;
			String name="";
			String personCode="";
			String actFee="";
			String annualFee="";
			String hourlyFee="";
			String pricePerUnit="";
			
			while(sc.hasNext()) {
				String line = sc.nextLine(); // reads each line starting from 2nd line
				String data[] = line.split(";"); // tokenizes the line and stores in a tring array 
				
				// Stores all the array elements of each line into strings
				String productCode = data[0];
				String Type = data[1];
				if (Type.equals("E")){
					pricePerUnit = data[3];
					
				}else if(Type.equals("S")){
					actFee = data[3];
					annualFee = data[4];
				}else{
					personCode=data[3];
					for (Person e : this.readPersons()){
						if (e.getPersonCode().equals(personCode)){
							contact = e;
							break;
						}
					}
					hourlyFee = data[4];
				}
				name = data[2];
				
				
				
				// Creates a Person object
				if (Type.equals("E")){
					InvoiceData.addEquipment(productCode, name, Double.parseDouble(pricePerUnit));
					Products e = new Equipments(productCode, Type, name,pricePerUnit);
					productsList.add(e);
				}else if(Type.equals("S")){
					InvoiceData.addService(productCode, name, Double.parseDouble(actFee), Double.parseDouble(annualFee));
					Products e = new Services(productCode, Type, name, actFee, annualFee);
					productsList.add(e);
				}else{
					InvoiceData.addConsultation(productCode, name, personCode,Double.parseDouble(hourlyFee));
					Consultations e = new Consultations(productCode, Type, name, contact, hourlyFee);
					productsList.add(e);
				}
				
				// Adds the Person object into Person ArrayList
				
			}
			sc.close();
			return productsList;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
		
	
	
}

