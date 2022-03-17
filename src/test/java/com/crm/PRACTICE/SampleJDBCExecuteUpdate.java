package com.crm.PRACTICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;



public class SampleJDBCExecuteUpdate 
{
@Test
public void sampleJDBCExecuteUpdate() throws SQLException
{
 Connection con = null;
try
{

	// step 1: register the database
	
	Driver driverRef= new Driver();
	DriverManager.registerDriver(driverRef);
	
	//Step 2: get connector from database - provide db name
	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/students", "root", "root");
	
	//Step 3: issue create statement
	 java.sql.Statement stat = con.createStatement();
	
	//Step 4: execute Query --provide table name
	int result=stat.executeUpdate("insert into student values(6,'Nilesh','Male');");
	
	if (result==1)
	{
		System.out.println("data added successfully");
	}
	
	else
	{
		System.out.println("data not added");
	}
}

catch(Exception e) 
{
	// to handle execption
}
finally
{
	//Step 5: close the database
	con.close();
	
}
}
}
