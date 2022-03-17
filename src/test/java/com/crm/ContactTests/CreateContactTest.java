package com.crm.ContactTests;

import static org.testng.Assert.fail;

import java.io.FileInputStream;
import java.io.IOException;
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

public class CreateContactTest extends BaseClass
{
@Test(groups = "smokeSuite")
public void createContactTest() throws Throwable
{
	javaUtility jLib= new javaUtility();
	PropertyFileUtility pLib= new PropertyFileUtility();
	ExcelUtility eLib= new ExcelUtility();
	WebDriverUtility wLib= new WebDriverUtility();
	
	
	
	/* step2: read all the necessary data from excel*/
	
	String lastname = eLib.readDataIntoExcel("Contacts", 1, 2)+"  "+jLib.getRandomNumber();
	System.out.println(lastname);
	
	Assert.fail();
	
	
	/*step 5; navigate to contact link*/
	
	HomePage hp= new HomePage(driver);
	hp.clickOnContactsLnk();
	
	ContactsPage cop= new ContactsPage(driver);
	cop.clickOnCreateContactImg();
	
	CreateContactPage ccp=new CreateContactPage(driver);
	ccp.createContact(lastname);
	
	ContactInfoPage cip= new ContactInfoPage(driver);
	String conHeader = cip.contactInfo();
	System.out.println(conHeader);
	Assert.assertTrue(conHeader.contains(lastname));
	
}
}
