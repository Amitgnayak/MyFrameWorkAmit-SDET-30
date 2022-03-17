package com.crm.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crmGenericLibrary.BaseClass;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;

public class CreateOrganisationWithPropertyFileTest extends BaseClass
{
	@Test
	public void createOrgTest() throws IOException
	{
	  // step1: read the data
		javaUtility jLib= new javaUtility();
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		
		//step2:launch the browser
		
		//navigate to organization link
		HomePage hp= new HomePage(driver);
		hp.clickOnOrgLnk();
		//create organization link
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//create org with mandatory field
		driver.findElement(By.name("accountname")).sendKeys("ABC");
		
		//save
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']"));
		
		driver.close();
		
	}

}
