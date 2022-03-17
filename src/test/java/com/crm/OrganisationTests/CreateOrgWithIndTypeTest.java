package com.crm.OrganisationTests;


import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OrganizationInfoPage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;



public class CreateOrgWithIndTypeTest 
{
 @Test
 public void createOrgwithIndDropdownTest() throws Throwable
	{
	    javaUtility jLib= new javaUtility();
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		/* load all the nessacry data*/
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		
		
		/*load the all the nessary data from excel*/
		
		String orgName = eLib.readDataIntoExcel("Org", 1, 2)+""+jLib.getRandomNumber();
		String indType = eLib.readDataIntoExcel("Org", 2, 3);
		
		/*launch the browser*/
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
		   driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
			
		}
		wLib.maximizeWindow(driver);
		wLib.waitForPageLoad(driver);
		driver.get(URL);
		
		/*login to application*/
		LoginPage lp= new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		
		/*step5: navigate to organization link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		/*click on create organization button*/
		
		OrganizationPage op= new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		/*enter the mandatory field  and select industry type as healthcare and save*/
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrg(orgName, indType);
		
		/*verification*/
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String actOrgHeader = oip.OrgNameInfo();
		if(actOrgHeader.contains(orgName))
		{
			System.out.println(actOrgHeader+"---->"+"Data verified");
		}
		else
		{
			System.out.println("data not verified");
		}
		
		/*logout of application*/
		
		hp.signOutOfApp(driver);
		
		/* close the application*/
		driver.quit();
		
		
		}

}

