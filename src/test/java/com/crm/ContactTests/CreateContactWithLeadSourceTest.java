package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crmGenericLibrary.BaseClass;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;
@Listeners(com.crmGenericLibrary.ListernerImplementationClass.class) 
public class CreateContactWithLeadSourceTest extends BaseClass
	{
		@Test(groups = "regressionSuite")
		public void createContactWithLeadSourceTest() throws Throwable
		{
			javaUtility jLib= new javaUtility();
			PropertyFileUtility pLib= new PropertyFileUtility();
			ExcelUtility eLib= new ExcelUtility();
			WebDriverUtility wLib= new WebDriverUtility();
			
		
			
			/*load the data from excel*/
			String lastName = eLib.readDataIntoExcel("Contacts", 22, 2)+""+jLib.getRandomNumber();
			String leadSource = eLib.readDataIntoExcel("Contacts", 22, 3);
			
			
			
			
			/*step 5; navigate to contat link*/
			  HomePage hp=new HomePage(driver);
			  hp.clickOnContactsLnk();
			  
			/*step 6: click on create contact button*/
			 ContactsPage cp=new ContactsPage(driver);
			 cp.clickOnCreateContactImg();
			 
			 
			 Assert.fail();
			 
			 CreateContactPage ccp= new CreateContactPage(driver);
			 ccp.createContact(lastName, leadSource);
			 
			 /*verification*/
			 
			 ContactInfoPage cip= new ContactInfoPage(driver);
			 String ConHeader = cip.contactInfo();
			 if(ConHeader.contains(lastName))
			 {
				 System.out.println(ConHeader+"===>Contact is created");
				 
			 }
			 else
			 {
				 System.out.println("contact is not created");
			 }
			
		}

	@Test
	public void sampleTestScript()
	{
	System.out.println("Sample test scripts");	
	}
	
	@Test
	public void sampleTestScript1()
	{
	System.out.println("Sample test scripts1");	
	}
	
	@Test
	public void sampleTestScript2()
	{
	System.out.println("Sample test scripts2");	
	}
}
