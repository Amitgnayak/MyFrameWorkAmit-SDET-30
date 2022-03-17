package com.crmOpportunitiesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.ContactInfoPage;
import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateContactPage;
import com.crm.ObjectRepository.CreateOpportunitiesPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.OpportunitiesPage;
import com.crm.ObjectRepository.OpportuntiesInfoPage;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;

public class OpportunitiesWithContactAndCampaignTestt 
{
	public class CreateOpportunitiesTest
	{
		@Test
		public void createOpportunitiesTest() throws Throwable
		{
			javaUtility jLib= new javaUtility();
			PropertyFileUtility pLib= new PropertyFileUtility();
			ExcelUtility eLib= new ExcelUtility();
			WebDriverUtility wLib=new WebDriverUtility();
			
			/*load all the data from the Property file*/
			String BROWSER = pLib.readDataFromPropertyFile("browser");
			String URL = pLib.readDataFromPropertyFile("url");
			String USERNAME = pLib.readDataFromPropertyFile("username");
			String PASSWORD = pLib.readDataFromPropertyFile("password");
			
			/*Load all the data from excel*/
			String lastName = eLib.readDataIntoExcel("Opportunities", 1, 2)+""+jLib.getRandomNumber();
			String campignName = eLib.readDataIntoExcel("Opportunities", 1, 3)+""+jLib.getRandomNumber();
			String opporName = eLib.readDataIntoExcel("Opportunities", 1, 4)+""+jLib.getRandomNumber();
			String realatedTo = eLib.readDataIntoExcel("Opportunities", 1, 5);
			String leadSource = eLib.readDataIntoExcel("Opportunities", 1, 6);
			
			/*launch the browser*/
			WebDriver driver=null;
			if(BROWSER.equalsIgnoreCase("chrome"))
			{
				driver=new ChromeDriver();
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
			
			/*navigate to contact link and save*/
			HomePage hp=new HomePage(driver);
			hp.clickOnContactsLnk();
			ContactsPage cp=new ContactsPage(driver);
			cp.clickOnCreateContactImg();
			CreateContactPage ccp=new CreateContactPage(driver);
			ccp.createContact(lastName);
			
		   ContactInfoPage cip=new ContactInfoPage(driver);
		   String conHeader = cip.contactInfo();
		   
	        if(conHeader.contains(lastName))
	        {
	        	System.out.println(conHeader);
	        	System.out.println("contact is created");
	        }
	        else
	        {
	        	System.out.println(conHeader);
	        	System.out.println("contact is not created");
	        }
	        
	        /*navigate to campgign and create camign and save*/
	      
	          hp.clickOnMoreLnk(driver);
	          CampaignsPage campPg=new CampaignsPage(driver);
	          campPg.clickOnCampaignsLookUpImg();
	          CreateCampaignsPage campcp=new CreateCampaignsPage(driver);
	          campcp.createCampaign(campignName);
	          CampaignsInfoPage campInf = new CampaignsInfoPage(driver);
	          String campignHeader = campInf.campaignInfo();
			if(campignHeader.contains(campignName))
			{
				System.out.println(campignHeader);
				System.out.println("campign is created");
			}
			else
			{
				System.out.println(campignHeader);
				System.out.println("campgn is not created");
			}
			/*navigate to opportunity link*/
			hp.clickOnOpportunitieslnk();
			OpportunitiesPage op= new OpportunitiesPage(driver);
			op.clickOnCreateOpportuniesImg();
			
			CreateOpportunitiesPage cop=new CreateOpportunitiesPage(driver);
			cop.createOpportinities(opporName, driver, realatedTo, lastName, leadSource, campignName);
		    OpportuntiesInfoPage oip=new OpportuntiesInfoPage(driver);
		    String opporHeader = oip.opportunityInfo();
			
			if(opporHeader.contains(opporName))
			{
				System.out.println(opporHeader);
				System.out.println("opportunity is created");
			}
			else
			{
				System.out.println(opporHeader);
				System.out.println("opportunity is not created");
			}
			/*logout from the application*/
			hp.signOutOfApp(driver);
			
			/* close the application*/
			driver.quit();
		}

	}
}
