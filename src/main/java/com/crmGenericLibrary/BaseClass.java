package com.crmGenericLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass
{
	// create the object of all the utilities
	
	public DataBaseUtility dLib= new DataBaseUtility();
	public ExcelUtility eLib = new ExcelUtility();
	public PropertyFileUtility pLib = new PropertyFileUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	
	public WebDriver driver;
	public static WebDriver sDriver;
	
	
	@BeforeSuite (groups = {"regressionSuite", "smokeSuite" })
	public void connectDataBase()
	{
		// dbLib.connectToDb();
		
		Reporter.log("----------db connection successful------", true );
		
	}
	
	@BeforeClass (groups = {"regressionSuite", "smokeSuite" })
	//@Parameters("browser")
	//@BeforeTest
	public void launchTheBrowser() throws Throwable 
	{
		//read the data from property
		String BROWSER = pLib.readDataFromPropertyFile("browser");
		String URL = pLib.readDataFromPropertyFile("url");

	// create Run Time Polymorphism
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			driver= new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			//WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser");
		}
		 sDriver = driver;
	wLib.maximizeWindow(driver);
	wLib.waitForPageLoad(driver);
	driver.get(URL);
	}
	
	@BeforeMethod(groups = {"regressionSuite", "smokeSuite" })
	public void login() throws Throwable
	{
		String USERNAME = pLib.readDataFromPropertyFile("username");
		String PASSWORD = pLib.readDataFromPropertyFile("password");
		LoginPage lp =new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		Reporter.log("====login successsfull===", true);
		
	}
	
	@AfterMethod(groups = {"regressionSuite", "smokeSuite" })
	public void  logout()
	{
		HomePage hp= new HomePage(driver);
		hp.signOutOfApp(driver);
		Reporter.log("== logout successfull", true);
	}
	
	@AfterClass (groups = {"regressionSuite", "smokeSuite" })
	//@AfterTest
	public void closeBrowser() 
	{
	driver.quit();
	Reporter.log("== browswer closed successfully", true);
	
	}
	
	@AfterSuite (groups = {"regressionSuite", "smokeSuite" })
	public void closeDb() 
	{
		//dbLib.closeDB();
		Reporter.log("===Database close Successfull", true);
		
	}
}
























