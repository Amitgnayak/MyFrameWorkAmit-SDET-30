package com.crm.OrganisationTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.CreateOrganizationPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.OrganizationPage;
import com.crmGenericLibrary.BaseClass;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;

public class CreateOrganisationWithMandatoryTest extends BaseClass
{
	@Test
	
		public void CreateOrgTest() throws IOException 
	{
		/*generate random number*/
		
		Random ran= new Random();
		int Random = ran.nextInt(500);
		
		/*Step 1: read all necessary data*/
		
		//read data from property file
		
		
		javaUtility jLib= new javaUtility();
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		//read data from excel sheet
		String OrgName = eLib.readDataIntoExcel("Org", 1, 2);
		

		
		/*Step 4: Navigate to Organizations Link*/
		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrgLnk();
		
		/*Step 5: click on create organization btn*/
		
		OrganizationPage op=new OrganizationPage(driver);
		op.clickOnCreateOrgImg();
		
		
		/*Step 6: enter mandatory fields and save*/
		
		
		CreateOrganizationPage cop= new CreateOrganizationPage(driver);
		cop.createNewOrg(OrgName);
		

	}
	}
