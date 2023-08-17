package com.tms.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtility {
	Connection con=null;
	/**
	 * This method is used to connect the database
	 * @author ELANGO
	 * @throws SQLException
	 */
	public void connectToDataBase() throws SQLException {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IpathConstants.dbURL,IpathConstants.dbUSERNAME,IpathConstants.dbPASSWORD);
		}
	/**
	 * This method is used to execute the query and get the data
	 * @author ELANGO
	 * @param query
	 * @param columnNo
	 * @param Expdata
	 * @return
	 * @throws SQLException
	 */
	
	public String getExecuteQuery(String query,int columnNo,String Expdata) throws SQLException {
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next()){
			String data=result.getString(columnNo);
			if(data.equalsIgnoreCase(Expdata)){
				flag=true;
				break;
			}
		}
		if(flag==true){
			System.out.println("Data is verfied");
			return Expdata;
			}
		else {
			System.out.println("Data is not verfied");
			return "";
		}
	}
	public void closeDataBase() throws SQLException {
		con.close();
		
	}
	
	

}
