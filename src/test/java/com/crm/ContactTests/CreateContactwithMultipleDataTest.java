package com.crm.ContactTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CreateContactwithMultipleDataTest extends BaseClass
{

	WebDriverUtility wLib=new WebDriverUtility();
	javaUtility jLib= new javaUtility();
	ExcelUtility eLib= new ExcelUtility();
	PropertyFileUtility pLib=new PropertyFileUtility();

	@Test(dataProvider = "CreateContactWithTestData")
	public void createContactWithMultipleData(String lastName) throws Throwable
	{
		
				//navigate to contact link
				
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLnk();
				Reporter.log("navigate to contact link",true);
				
				//create contact
				ContactsPage cp=new ContactsPage(driver);
				cp.clickOnCreateContactImg();
				Reporter.log("click on create contact data",true);
				
				CreateContactPage ccp=new CreateContactPage(driver);
				ccp.createContact(lastName);
				
				//verification
				ContactInfoPage cip=new ContactInfoPage(driver);
				String actualHeader = cip.contactInfo();
				if(actualHeader.contains(lastName))
				{
					System.out.println("test case is pass");
				}
				else
				{
					System.out.println("test case is fail");
				}
				
	}
	
	@DataProvider(name="CreateContactWithTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("ContactWithData");
		return data;
	}
}
