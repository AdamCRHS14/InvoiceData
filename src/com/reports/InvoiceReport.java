package com.reports;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.datacontainers.Person;
import com.fileReader.FlatFileReader;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mwc.ext.InvoiceData;

public class InvoiceReport {
	
			FlatFileReader fr = new FlatFileReader();
			
			public  ArrayList<String> readInvoices(){
			Scanner sc = null;
			
			try {
				sc = new Scanner(new File("data/Invoices.dat"));
				sc.nextLine(); // reads the number of records from the first line
				
				// This Person ArrayList stores the Person objects 
				ArrayList<Invoices> invoiceList = new ArrayList<Invoices>();
				ArrayList<String> invoiceStringList = new ArrayList<String>();
				String contact = null;
				String product = "";
				String produce = "";
				String buyer = null;
				Calendar calendar1 = Calendar.getInstance();
				Calendar calendar2 = Calendar.getInstance();
				int x;
				final double TAXE = 0.07;//7% tax rate
				final double TAX = 0.0425; // 4.25% tax rate
				
				double finalsubtotal = 0.0;
				double finaltaxes = 0.0; 
				double finalfees = 0.0; 				
				double finaltotal = 0.0;
				double COMPLIANCE;
				double subTotalE,subTotalS,subTotalC;
				double taxTotalE,taxTotalS,taxTotalC;
				double Efee,Sfee,Cfee;
				int numUnits =0;
				double unitPrice = 0.0;
				
				while(sc.hasNext()) {
					String line = sc.nextLine(); // reads each line starting from 2nd line
					String data[] = line.split(";"); // tokenizes the line and stores in a string array 
					
					// Stores all the array elements of each line into strings
					
					String InvoiceCode = data[0];
					String customerCode = data[1];
					for (Customer c : fr.readCustomer()){
						if (c.getCustomerCode().equals(customerCode)){
							buyer = (c.getName() + " " + "(" + c.getCustomerCode() + ")" + "\n" + "(" + c.getType() +")" + "\n" + c.getName() + "\n" + c.getAddress().getStreet() + "\n" + c.getAddress().getLocation());
							break;
						}
					}
					String invDate = data[2];
					String SalesPersonCode = data[3];
					for (Person e : fr.readPersons()){
						if (e.getPersonCode().equals(SalesPersonCode)){
							contact =  (e.getLastName() + "," + e.getFirstName());
							break;
						}
					}
					String productList = data[4];
					
					Invoices invoice = new Invoices(InvoiceCode, buyer, invDate, contact, productList);
					InvoiceData.addInvoice(InvoiceCode, customerCode, invDate, SalesPersonCode);

				 String[] order = data[4].split(",");

								String orderStats[] = null;
								
								produce = "";
								switch (order.length) {
									
									case 1:	for (Products p : fr.readProducts()){
												orderStats = order[0].split(":");
												if(p.getCode().equals(orderStats[0])){
													Equipments e = (Equipments)p;
													if(buyer.contains("Business")){ //Checks if its a bussiness or not
														unitPrice = Double.parseDouble(e.getPricePerUnit());
														numUnits = Integer.parseInt(orderStats[1]);
														subTotalE = (unitPrice * numUnits);
														taxTotalE = (subTotalE * TAXE); 
														Efee = 0.0;
														finalsubtotal += subTotalE;
														finaltaxes += taxTotalE;
														finalfees += Efee;
														finaltotal += subTotalE + taxTotalE + Efee;
														}else {
															unitPrice = Double.parseDouble(e.getPricePerUnit());
															numUnits = Integer.parseInt(orderStats[1]);
															subTotalE = (unitPrice * numUnits);
															taxTotalE = 0.0;
															Efee = 0.0;
															finalsubtotal += subTotalE;
															finaltaxes += taxTotalE;
															finalfees += Efee;
															finaltotal += subTotalE + taxTotalE + Efee;
														}
													produce += String.format("%-2s %2s (%s units at %.2f/unit)    $%-16.2f $%-16.2f $%.2f\n", e.getCode(),e.getName(),orderStats[1],Double.parseDouble(e.getPricePerUnit()),subTotalE,taxTotalE,Efee);
													
													
												}
											}
											break;
									
									
											
									default: for(int y = 0; y < order.length; y++){
												orderStats = order[y].split(":");
												x =0;
												for (Products p : fr.readProducts()){
													if(p.getCode().equals(orderStats[x])){
														if(p.getType().equals("S")){
															Services s = (Services)p;
															//Date d1 = new Date(orderStatus[x+1])
															int year = Integer.parseInt(orderStats[x+1].substring(0, 4));
															int month = Integer.parseInt(orderStats[x+1].substring(5, 7));
															int date = Integer.parseInt(orderStats[x+1].substring(7));
															int year1 = Integer.parseInt(orderStats[x+2].substring(0, 4));
															int month1 = Integer.parseInt(orderStats[x+2].substring(5, 7));
															int date1 = Integer.parseInt(orderStats[x+2].substring(7));
															calendar1.set(year, month, date);
															calendar2.set(year1, month1, date1);
															Date d1 =  new Date();
															Date d2 = new Date();
															d1 = calendar1.getTime();
															d2 = calendar2.getTime();
															long days = (d2.getTime()-d1.getTime())/(1000*60*60*24);
															
															s.setEndDate(orderStats[x+2]);
															if(buyer.contains("Business")){ //Checks if its a business or not
																int dayz = (int) days;
																InvoiceData.addServiceToInvoice(InvoiceCode, s.getCode(), d1.toString(), d2.toString());
														subTotalS = (dayz)*((Double.parseDouble(s.getAnnualFee())/365) + Double.parseDouble(s.getActivationFee()));
														taxTotalS = (((Double.parseDouble(s.getAnnualFee())/365)*dayz)* TAX);
														Sfee = Double.parseDouble(s.getActivationFee());
														finalsubtotal += subTotalS;
														finaltaxes += taxTotalS;
														finalfees += Sfee;
														finaltotal += subTotalS + taxTotalS + Sfee;
														}else{
															long dayz = days;
															subTotalS = (dayz)*((Double.parseDouble(s.getAnnualFee())/365) + Double.parseDouble(s.getActivationFee()));
															taxTotalS = 0.0;
															Sfee = Double.parseDouble(s.getActivationFee());
															finalsubtotal += subTotalS;
															finaltaxes += taxTotalS;
															finalfees += Sfee;
															finaltotal += subTotalS + taxTotalS + Sfee;
														}
															produce += String.format("%-2s %2s (%d days at %.2f/year)    $%-16.2f $%-16.2f $%.2f\n", s.getCode(),s.getName(),days,Double.parseDouble(s.getAnnualFee()),subTotalS,taxTotalS,Sfee);
															x+=2;
															
														
														}else if(p.getType().equals("E")){
															Equipments e = (Equipments)p;
															unitPrice = Double.parseDouble(e.getPricePerUnit());
															numUnits = Integer.parseInt(orderStats[1]);
															InvoiceData.addEquipmentToInvoice(InvoiceCode, e.getCode(), numUnits);
															subTotalE = (unitPrice * numUnits);
															taxTotalE = 0.0;
															Efee = 0.0;
															finalsubtotal += subTotalE;
															finaltaxes += taxTotalE;
															finalfees += Efee;
															finaltotal += subTotalE + taxTotalE + Efee;
															produce += String.format("%-2s %2s (%s units at %.2f/unit)    $%-16.2f $%-16.2f $%.2f\n", e.getCode(),e.getName(),orderStats[x+1],Double.parseDouble(e.getPricePerUnit()),subTotalE, taxTotalE, Efee );
															
															x++;
														}else{
															Consultations c = (Consultations)p;
															if(buyer.contains("Business")){//Checks if its a business or not
																InvoiceData.addConsultationToInvoice(InvoiceCode, c.getCode(), 4);
																subTotalC = (150 * TAX) + 150;
																taxTotalC = Double.parseDouble(c.getHourlyFee()) * TAX;
																Cfee = 150;
																finalsubtotal += subTotalC;
																finaltaxes += taxTotalC;
																finalfees += Cfee;
																finaltotal += subTotalC + taxTotalC + Cfee;
																} else { subTotalC = (150 * TAX) + 150;
																		 taxTotalC = 0.0;
																         Cfee = 150;
																         finalsubtotal += subTotalC;
																			finaltaxes += taxTotalC;
																			finalfees += Cfee;
																			finaltotal += subTotalC + taxTotalC + Cfee;
																}
															produce += String.format("%-2s %2s (%s hours at %.2f/hours)    $%-16.2f $%-16.2f $%.2f\n", c.getCode(),c.getName(),orderStats[x+1],Double.parseDouble(c.getHourlyFee()),subTotalC,taxTotalC,Cfee);
															x++;
															
														}
													}
												}
											}
											break;
								}
					String beginning = invoice.Print();
					String line1 = ("                                                     " + "=========================================================\n");
					String line2 = String.format("%-51s $%-15.2f $%-15.2f $%-12.2f $%.2f\n", "SUB_TOTALS",finalsubtotal,finaltaxes,finalfees,finaltotal);
					String line3 = String.format("%-98s $%.2f\n","FINAL TOTAL",finaltotal);
					invoice = new Invoices(beginning + produce + line1 + line2 +line3);
					// Adds the Invoices object into Invoice ArrayList
					invoiceStringList.add(beginning + produce + line1 + line2 + line3);

				}
				sc.close();
				return invoiceStringList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}
			
		}
			

	public void output(List<String> invoice){
				File reportPrint = new File("data/output.txt");
				
				PrintWriter pw = null;
				
				try {
					pw = new PrintWriter(reportPrint);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
				
				for(String I : invoice) {
					// Use toJson method to convert Person object into a String
					String output = I;
					pw.write(output + "\n\n");
				}
				
				pw.close();
	}
			
			
	

	
			
}
