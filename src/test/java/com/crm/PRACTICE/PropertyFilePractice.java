package com.crm.PRACTICE;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class PropertyFilePractice
{
	@Test
	public void propertyFile() throws IOException
	{
		//step1: read the file
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		// step2 : create the object of property
		Properties pObj= new Properties();
		pObj.load(fis);
		
		// step 3: read the data
		String URL = pObj.getProperty("url");
		
		//step 4: verification
		System.out.println(URL);

	}

}
