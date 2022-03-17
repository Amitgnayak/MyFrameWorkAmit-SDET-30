package com.crm.ContactTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crmGenericLibrary.BaseClass;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;



public class CreateContactWithOrgTest  extends BaseClass
{
@Test(groups = "smokeSuite")
public void createContactWithOrgTest() throws Throwable
{
	
	javaUtility jLib= new javaUtility();
	PropertyFileUtility pLib= new PropertyFileUtility();
	ExcelUtility eLib = new ExcelUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	
	
	
	/* load all the necessary data from excel*/
	String OrgName = eLib.readDataIntoExcel("Contacts", 1, 3)+" "+jLib.getRandomNumber();
	String lastname = eLib.readDataIntoExcel("Contacts", 1, 2)+ " " +jLib.getRandomNumber();
	
	
	/*launch the browser*/
	
	
	/*Create organization*/
	HomePage hp= new HomePage(driver);
	hp.clickOnOrgLnk();
	
	OrganizationPage op=new OrganizationPage(driver);
	op.clickOnCreateOrgImg();
	
	CreateOrganizationPage cop= new CreateOrganizationPage(driver);
	cop.createNewOrg(OrgName);
	
	/*step 5; navigate to contact link*/
	
	hp.clickOnContactsLnk();
	
	
	/*step 6: click on create contact button*/
	ContactsPage cp= new ContactsPage(driver);
	cp.clickOnCreateContactImg();
	
    /* enter the data into the mandatory field*/
	
	CreateContactPage ccp= new CreateContactPage(driver);
	ccp.createContact(driver, lastname, OrgName);
	
	// verification
	ContactInfoPage cip = new ContactInfoPage(driver);
	String contactHeader = cip.contactInfo();
	if(contactHeader.contains(lastname))
	{
		System.out.println(contactHeader+" -----> contact iss created");
	}
	else
	{
		System.out.println("contact not created");
	}

}
}
