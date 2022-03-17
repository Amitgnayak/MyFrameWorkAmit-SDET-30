package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class DataProviderPractice
{
	@Test(dataProvider = "getData")
	public void sampleDataProvider(String Name, String model, int qty)
	{
		System.out.println(Name+"-------"+ model+"---"+qty);
	}
	
	@DataProvider
	public Object[][] getData()
	{
	 Object[][] obj = new Object[4][3];
	 
	 obj[0][0]= "Mi";
	 obj[0][1]="13 pro max";
	 obj[0][2]=	25;
	 
	 obj[1][0]= "iPhone";
	 obj[1][1]="14 pro max";
	 obj[1][2]=	12;
	 
	 obj[2][0]= "Samsung";
	 obj[2][1]="a2max";
	 obj[2][2]=	32;
	
	 obj[3][0]= "vivo";
	 obj[3][1]="v12";
	 obj[3][2]=	22;
	 
	return obj;
	 
		
	}
}