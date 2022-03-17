package com.crmGenericLibrary;

import java.util.Date;
import java.util.Random;

/**
 * This class consists of generic methods wrt Java
 * @author user
 *
 */

public class javaUtility {
	
	
	/**
	 * This  method will generate a random numbers and return in to the user
	 * @return
	 */

	public int getRandomNumber()
	{
		Random ran= new Random();
		int random = ran.nextInt(500);
		return random;
		
	}
	
	/**
	 * This method will generate current system date and return it to the user
	 * @return
	 */
	public String getSystemDate()
	{
		Date d = new Date();
		String date = d.toString();
		return date;
	}
	
	/**
	 * This method will generate system date and return date in format
	 * @return
	 */
	public String getSystemDateInformat()
	{
		Date d = new Date();
		String d1 = d.toString();
		String[] date = d1.split(" ");
		
		String mon = date[1];
		String day = date[2];
		String time= date[3].replace(":", "-");
		String year = date[5];
		String Dateformat = day+"-"+mon+"-"+year+"-"+time;
		return Dateformat;
		
	}
}
