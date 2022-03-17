package com.crmGenericLibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;
/**
 * this class contains generic methods to read the data from database
 * @author user
 *
 */

public class DataBaseUtility 
{
	Connection con= null;
	
	/**
	 * this method will register the driver and establish the connection with database
	 * @throws Throwable
	 */
public void connectToDb() throws Throwable
{
	Driver driver= new Driver();
	DriverManager.registerDriver(driver);
	con= DriverManager.getConnection(IPathConstants.dbURL, IPathConstants.dbUsername, IPathConstants.dbPassword);
		
}

/**
 * this method will execute the query and return the matching data to the user
 * @param query
 * @param columnIndex
 * @param expData
 * @return
 * @throws Throwable
 */
public String executeQueryAndgetData(String query, int columnIndex, String expData) throws Throwable
{
	String data=null;
	boolean flag= false;
	ResultSet result = con.createStatement().executeQuery(query);
	while(result.next())
	{
		data=result.getString(columnIndex);
		if(data.equalsIgnoreCase(expData));
		{
			flag=true;// flag rising
			break;
			
		}
				
	}
	if(flag)
	{
	 System.out.println(data+" -------> data is verified");
	 return expData;
	}
	else
	{
		System.out.println("data is not verified");
		return "";
	}
}

/**
 * this method will the close the DB connection 
 * @throws Throwable 
 * 
 */
public void closeDb() throws Throwable 
{
	con.close();
}
}

















