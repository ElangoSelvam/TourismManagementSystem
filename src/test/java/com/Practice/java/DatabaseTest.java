package com.Practice.java;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseTest {
public static void main(String[] args) throws SQLException {
	Connection connection=null;
	ResultSet result=null;
	//register the database
	try {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	
	//get connection of database
	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root","root");
	//create statement
	Statement state = connection.createStatement();
	String query="select* from tourism;";
	
	//execute query
	 result = state.executeQuery(query);
	 while(result.next()) {
		 System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
	 }
}
catch(Exception e) {
	
}
	finally {
		//close the database
		connection.close();
	}


}
}