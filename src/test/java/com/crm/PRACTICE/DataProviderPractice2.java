package com.crm.PRACTICE;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPractice2 
{
	@Test(dataProvider= "getData")
	public void sampleDataProvider(String Name, int qty)
	{
		System.out.println(Name+"----------"+qty);
	}
	@DataProvider
	public Object[][] getData()

	{
	 Object[][] obj= new Object [6][2];
	 
	 obj[0][0]= "Apple";
	 obj[0][1]= 12;
	 
	 obj[1][0]= "Orange";
	 obj[1][1]= 30;
	 
	 obj[2][0]= "Banana";
	 obj[2][1]= 60;
	 
	 obj[3][0]= "Grapes";
	 obj[3][1]= 200;
	 
	 obj[4][0]="Pomogranates";
	 obj[4][1]= 15;
	 
	 obj[5][0]= "kiwi";
	 obj[5][1]= 54;
	 
	 return obj;
	 
	 
	 
	 
	}
}
