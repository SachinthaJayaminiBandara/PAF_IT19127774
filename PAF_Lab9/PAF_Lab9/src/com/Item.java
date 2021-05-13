
package com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Item {

	 
	 //getting the connection
	public Connection connect()
	{
	 Connection con = null;

	 try
	 {
	 Class.forName("com.mysql.jdbc.Driver");
	// Provide the correct details: DBServer/DBName, user name, password
	 con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/grant_management",
			"root", "root");
	 //For testing

//	 System.out.print("Successfully connected");
	 }
	 catch(Exception e)
	 {
	 e.printStackTrace();
	 }

	 return con;
	}
	
	//insert grant application details
	public String insertGrantApplication(String id,String title,String full_name, String email, String phone, String research_category,String budget,String introduction)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for inserting grant applicationt details.";
	 }
	 // create a prepared statement
	 String query = " insert into grant_application (Grant_Application_ID,Title,Full_Name,Email,Phone,Research_category,Budget,Introduction)" + " values (?,?,?,?,?,?,?,?)"; 
	 java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
	 
	// binding values to grant table
	 	preparedStmt.setString(1, id);
		preparedStmt.setString(2, title);
		preparedStmt.setString(3, full_name);
		preparedStmt.setString(4, email);
		preparedStmt.setString(5, phone);
		preparedStmt.setString(6, research_category);
		preparedStmt.setString(7, budget);
		preparedStmt.setString(8, introduction);
		

	
	 
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Inserted successfully";
	 }
	catch (Exception e)
	 {
	 output = "Error while inserting the application details.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}

	//read Grants from the system
	
	public String readGrants()
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database for reading the Avilable Grants.";
	 }
	 // Prepare the HTML table to be displayed
	 
//	 output = "<table border='1'><tr><th>Item Code</th>"
//	 +"<th>Item Name</th><th>Item Price</th>"
//	 + "<th>Item Description</th>"
//	 + "<th>Update</th><th>Remove</th></tr>";
	 
	 output = "<table class=\"table table-bordered\">\r\n"
	 		+ "  <thead>\r\n"
	 		+ "    <tr>\r\n"
	 		+ "      <th scope=\"col\">Grant ID</th>\r\n"
	 		+ "      <th scope=\"col\">Title</th>\r\n"
	 		+ "      <th scope=\"col\">Full Name</th>\r\n"
	 		+ "      <th scope=\"col\">Email</th>\r\n"
	 		+ "      <th scope=\"col\">Phone</th>\r\n"
	 		+ "      <th scope=\"col\">Research Category</th>\r\n"
	 		+ "      <th scope=\"col\">Budget</th>\r\n"
	 		+ "      <th scope=\"col\">Introduction</th>\r\n"
	 		+ "      <th scope=\"col\" colspan=\"2\">Upadate/Delete</th>\r\n"
	 		+ "    </tr>\r\n"
	 		+ "  </thead>\r\n"
	 		+ "</table";
	
	 String query ="select * from grant_application" ;
	 java.sql.Statement stmt = con.createStatement();
	 ResultSet rs = stmt.executeQuery(query);
	 // iterate through the rows in the result set
	 while (rs.next())
	 {
		 String id = rs.getString("Grant_Application_ID");
			System.out.println(id);
			String Title = rs.getString("Title");
		    String Full_Name = rs.getString("Full_Name");
		    String Email = rs.getString("Email");
		    String Phone = rs.getString("Phone");
		    String Research_category = rs.getString("Research_category");
		    String Budget = rs.getString("Budget");
		    String Introduction = rs.getString("Introduction");
	 
	 // Add a row into the HTML table
	 output += "<tr><td><input id='hidGrant_Application_IDUpdate'name='hidGrant_Application_IDUpdate'type='hidden' value='" +  id + "'>"
			 		  + Title + "</td>";
	 output += "<td>" + Full_Name + "</td>";
	 output += "<td>" + Email + "</td>"; 
	 output += "<td>" + Phone + "</td>";
	 output += "<td>" + Research_category  + "</td>";
	 output += "<td>" + Budget   + "</td>";
	 output += "<td>" + Introduction  + "</td>";
	 
	 // buttons
	 output += "<td>"
	 + "<input name='btnUpdate' "
     + " type='button' class='btnUpdate btn btn-outline-dark' value='Update'>"
	 + "<input name='id' type='hidden' "
	 + " value='" + id + "'>" + "</td>"
	 + "<td><form method='post' action='items.jsp'>"
	 + "<input name='btnRemove' "
	 + " type='submit' class='btn btn-outline-danger' value='Remove'>"
	 + "<input name='hidGrant_Application_IDDelete' type='hidden' "
	 + " value='" + id + "'>" + "</form></td></tr>";

	 }
	 con.close();
	 // Complete the html table
	 output += "</table>";
	 }
	catch (Exception e)
	 {
	 output = "An error occurred while reading the grant details.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}
	


	//delete specific grant
	public String deleteGrants(String id)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error occured while deleting the Grants.";
	 }
	// create a prepared statement
		String query = "delete from grant_application where Grant_Application_ID=?";
		java.sql.PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setString(1, id);

		// executing the statements
		preparedStmt.execute();

	 
	 con.close();
	 output = "Grant Details deleted successfully.";

	 
	 }
	catch (Exception e)
	 {
	 output = " An error occurred while deleting the grant_application details.";
	 System.err.println(e.getMessage());
	 }
	return output;
	}

	//update existing grant
	public String updateGrants(String id,String title, String full_name, String email, String phone,String research_category,String  budget,String introduction)
	{
	 String output = "";
	try
	 {
	 Connection con = connect();
	 if (con == null)
	 {
	 return "Error while connecting to the database";
	 }
	 // create a prepared statement
	 String query = "UPDATE grant_application SET Title=?,Full_Name=?,Email=?,Phone=?,Research_category=?,Budget=?,Introduction=?  WHERE Grant_Application_ID=?";
	 PreparedStatement preparedStmt = con.prepareStatement(query);
	 // binding values
	 
	    preparedStmt.setString(1, title);
		preparedStmt.setString(2, full_name);
		preparedStmt.setString(3, email);
		preparedStmt.setString(4, phone);
		preparedStmt.setString(5, research_category);
		preparedStmt.setString(6, budget);
		preparedStmt.setString(7, introduction);
		preparedStmt.setString(8, id);
	 
	//execute the statement
	 preparedStmt.execute();
	 con.close();
	 output = "Grant details update successfully.";
	 }
	catch (Exception e)
	 {
	 output = "An error occurred while updating the grant details.";
	 System.err.println(e.getMessage());
	 e.printStackTrace();
	 }
	return output;
	}


}

