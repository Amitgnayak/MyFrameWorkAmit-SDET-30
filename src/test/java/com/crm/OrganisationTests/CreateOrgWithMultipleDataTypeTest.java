package com.crm.OrganisationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
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

public class CreateOrgWithMultipleDataTypeTest
{

	WebDriverUtility wLib=new WebDriverUtility();
	javaUtility jLib= new javaUtility();
	ExcelUtility eLib= new ExcelUtility();
	PropertyFileUtility pLib=new PropertyFileUtility();
	
	@Test(dataProvider = "OrgwithTestData")
	public void createOrgWithIndAndType(String orgName, String indType, String type) throws Throwable
	{
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		
		String orgname=orgName+jLib.getRandomNumber();
		
		// launch the browser
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
				
				
				//login to application
				LoginPage lp=new LoginPage(driver);
				lp.LoginToApp(USERNAME, PASSWORD);
				Reporter.log("login sucessful",true);
				
				//naviagate to org link
				HomePage hp=new HomePage(driver);
				hp.clickOnOrgLnk();
				Reporter.log("navigated to org link",true);
				
				OrganizationPage op= new OrganizationPage(driver);
				op.clickOnCreateOrgImg();
				Reporter.log("click on create org link",true);
				
				CreateOrganizationPage cop= new CreateOrganizationPage(driver);
				cop.createNewOrg(orgname, indType);
				
				Reporter.log("Create org with ind and type",true);
				
				// validate
				OrganizationInfoPage iop=new OrganizationInfoPage(driver);
				String actHeader = iop.OrgNameInfo();
				if(actHeader.contains(orgname))
				{
					System.out.println("test case is pass");
				}
				else
				{
					System.out.println("test case is failed");
				}
				Reporter.log("Verification sucessful",true);
				
				//logout of app
				hp.signOutOfApp(driver);
				
				driver.quit();
	}
	
	@DataProvider(name="OrgwithTestData")
	public Object[][] getData() throws Throwable
	{
		Object[][] data = eLib.readmultipleDataFromExcel("OrgTestData");
		return data;
	}


}
