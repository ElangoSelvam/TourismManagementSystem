package com.Practice.java;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseNosqlTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection=null;
		int result=0;
		//register the database
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		//get connection of database
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms","root","root");
		//create statement
		Statement state = connection.createStatement();
		String query=" insert into Tourism values('Akash','Bangalore',1000),('Naveen','Mysore',500),('Anbu','TamilNadu',1000);";		
		//executing the update query
		 result = state.executeUpdate(query);
		}
		catch(Exception e){
		}
	finally{
		if(result>0) {
			System.out.println("Data updated succesfully");
		}
		else {
			System.out.println("Data not Inserted");
		}
	}

	}	
} 