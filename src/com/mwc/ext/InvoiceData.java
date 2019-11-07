package com.mwc.ext;

import java.sql.*;

/* NOTE: Do not change the package name or any of the method signatures.
	 *  
	 * There are 14 methods in total, all of which need to be completed as a 
	 * bare minimum as part of the assignment.You can add additional methods 
	 * for testing if you feel.
	 * 
	 * It is also recommended that you write a separate program to read
	 * from the .dat files and test these methods to insert data into your 
	 * database.
	 * 
	 * Do not forget to change your reports generation classes to read from 
	 * your database instead of the .dat files.
	 */


	/**
	 * Class containing all methods interacting with the database.
	 */
public class InvoiceData {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static Statement stmt  = null;
	static ResultSet rs = null;
	static String cmd = "";
	
	
	public static void removeAllPersons() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "DELETE FROM Person WHERE personID <> ''";
			stmt.executeUpdate(cmd);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}
	
	
	public static void addPerson(String personCode, String firstName, String lastName, 
			String street, String city, String state, String zip, String country) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Person (personCode, personFirstName, personLastName, personStreet, personCity, personState, personZip, personCountry) VALUES (? , ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, personCode);
			pstmt.setString(2, firstName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, street);
			pstmt.setString(5, city);
			pstmt.setString(6, state);
			pstmt.setString(7, zip);
			pstmt.setString(8, country);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
	
	
	public static void addEmail(String personCode, String email) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "UPDATE Person SET personEmail = ? WHERE personCode = ?";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, email);
			pstmt.setString(2, personCode);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}
	
	
	public static void removeAllCustomers() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "DELETE FROM Customer WHERE custID <> ''";
			stmt.executeUpdate(cmd);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}
	
	
	public static void addCustomer(String customerCode, String type, String primaryContactPersonCode, String name, 
			String street, String city, String state, String zip, String country) {
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Customer (custCode, custType, personCode, custName, custStreet, custCity, custState, custZip, custCountry) VALUES (? , ?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, customerCode);
			pstmt.setString(2, type);
			pstmt.setString(3, primaryContactPersonCode);
			pstmt.setString(4, name);
			pstmt.setString(5, street);
			pstmt.setString(6, city);
			pstmt.setString(7, state);
			pstmt.setString(8, zip);
			pstmt.setString(9, country);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
	
	
	public static void removeAllProducts() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "DELETE FROM Products WHERE prodID <> ''";
			stmt.executeUpdate(cmd);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}
	
	
	
	public static void addEquipment(String productCode, String name, Double pricePerUnit) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Products (prodCode, prodName, pricePerUnit) VALUES (? , ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, productCode);
			pstmt.setString(2, name);
			pstmt.setDouble(3, pricePerUnit);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}

	
	
	public static void addService(String productCode, String name, double activationFee, double annualFee) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Products (prodCode, prodName, activationFee, annualFee) VALUES (? , ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, productCode);
			pstmt.setString(2, name);
			pstmt.setDouble(3, activationFee);
			pstmt.setDouble(4, annualFee);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
	
	
	public static void addConsultation(String productCode, String name, String consultantPersonCode, Double hourlyFee) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Products (prodCode, prodName, personCode, hourlyFee) VALUES (? , ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, productCode);
			pstmt.setString(2, name);
			pstmt.setString(3, consultantPersonCode);
			pstmt.setDouble(4,hourlyFee);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}
	
	
	public static void removeAllInvoices() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "DELETE FROM Invoice WHERE invoiceID <> ''";
			stmt.executeUpdate(cmd);
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
		
	}

	
	
	public static void addInvoice(String invoiceCode, String customerCode, String invoiceDate, String salesPersonCode) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Invoice (invoiceCode, custCode, invoiceDate, personCode) VALUES (? , ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, invoiceCode);
			pstmt.setString(2, customerCode);
			pstmt.setString(3, invoiceDate);
			pstmt.setString(4, salesPersonCode);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
	
	
	
	public static void addEquipmentToInvoice(String invoiceCode, String productCode, int numUnits) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Invoice (invoiceCode, prodCode, unitsBought) VALUES (? , ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, invoiceCode);
			pstmt.setString(2, productCode);
			pstmt.setInt(3, numUnits);
			
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
	
	
	public static void addServiceToInvoice(String invoiceCode, String productCode, String startDate, String endDate) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Invoice (invoiceCode, prodCode, startDate, endDate) VALUES (? , ?, ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, invoiceCode);
			pstmt.setString(2, productCode);
			pstmt.setString(3, startDate);
			pstmt.setString(4, endDate);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}

	
	public static void addConsultationToInvoice(String invoiceCode, String productCode, double numHours) {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://cse.unl.edu:3306/amcfarland", "amcfarland", "H3EbzZ");
			
			cmd = "INSERT INTO Invoice (invoiceCode, prodCode, hoursUsed) VALUES (? , ?, ?)";
			pstmt = conn.prepareStatement(cmd);
			pstmt.setString(1, invoiceCode);
			pstmt.setString(2, productCode);
			pstmt.setDouble(3, numHours);
			rs = pstmt.executeQuery();
			
			System.out.println("...Command Complete!...\n");
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			try{
				rs.close();
				pstmt.close();
				conn.close();
              if(stmt != null)
                 stmt.close();
              if(pstmt != null)
            	  pstmt.close();
           }catch(SQLException se2){
           }// nothing we can do
           try{
              if(conn != null)
                 conn.close();
           }catch(SQLException se){
               se.printStackTrace();
           }//end finally try
		}
	}
}

