package com.crm.PRACTICE;

import org.testng.annotations.Test;

import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.javaUtility;

public class PracticeForGenericUtils 
{
 @Test
 public void practiceForGenericUtils() throws Throwable
 {
	 javaUtility jLib= new javaUtility();
	 int random = jLib.getRandomNumber();
	 System.out.println(random);
	 String date = jLib.getSystemDate();
	 System.out.println(date);
	 String dat = jLib.getSystemDateInformat();
	 System.out.println(dat);
	 
	 PropertyFileUtility pLib = new PropertyFileUtility();
	 String BROWSER = pLib.readDataFromPropertyFile("browser");
	 System.out.println(BROWSER);
	
 }
}
