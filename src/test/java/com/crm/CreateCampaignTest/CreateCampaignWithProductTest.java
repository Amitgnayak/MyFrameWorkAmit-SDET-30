package com.crm.CreateCampaignTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
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

import com.crm.ObjectRepository.CampaignsInfoPage;
import com.crm.ObjectRepository.CampaignsPage;
import com.crm.ObjectRepository.CreateCampaignsPage;
import com.crm.ObjectRepository.CreateProductPage;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.LoginPage;
import com.crm.ObjectRepository.ProductInfoPage;
import com.crm.ObjectRepository.ProductsPage;
import com.crmGenericLibrary.BaseClass;
import com.crmGenericLibrary.ExcelUtility;
import com.crmGenericLibrary.PropertyFileUtility;
import com.crmGenericLibrary.WebDriverUtility;
import com.crmGenericLibrary.javaUtility;

public class CreateCampaignWithProductTest extends BaseClass
{
	@Test
	public void createCampaignWithProductTest() throws Throwable
	{
		javaUtility jLib= new javaUtility();
		PropertyFileUtility pLib= new PropertyFileUtility();
		ExcelUtility eLib= new ExcelUtility();
		WebDriverUtility wLib= new WebDriverUtility();
		
		
		
	   
	   /*read all the from excel*/
		String prodName = eLib.readDataIntoExcel("Campigans", 1, 2)+""+jLib.getRandomNumber();
		String campignName = eLib.readDataIntoExcel("Campigans", 1, 3)+""+jLib.getRandomNumber();
	    
	   
	   
	 
		
		/*navigate to products link*/
		HomePage hp=new HomePage(driver);
		hp.clickOnProductLnk();
		
		
		/*create the product and save the product*/
		ProductsPage pp=new ProductsPage(driver);
		pp.clickOnProductLookUpImg();
		CreateProductPage cpp=new CreateProductPage(driver);
		cpp.createProduct(prodName);
		
		/*verify for the product*/
		ProductInfoPage pip=new ProductInfoPage(driver);
		String prodHeader = pip.productInfo();
		if(prodHeader.contains(prodName))
		{
			System.out.println(prodHeader);
			System.out.println("product is created");
		}
		else
		{
			System.out.println(prodHeader);
			System.out.println("product is not created");
		}
		/*navigate to campaign*/
		 hp.clickOnMoreLnk(driver);
		 CampaignsPage cp=new CampaignsPage(driver);
		 cp.clickOnCampaignsLookUpImg();
		 
		CreateCampaignsPage ccp=new CreateCampaignsPage(driver);
		ccp.createCampaign(campignName, driver, prodName);
		 
		 /*verify for the campign*/
		 CampaignsInfoPage cip=new CampaignsInfoPage(driver);
		 String campignHeader = cip.campaignInfo();
		 if(campignHeader.contains(campignName))
		 {
			 System.out.println(campignHeader+" campign created");
		 }
		 else
		 {
			 System.out.println("camign not created");
		 }
		 
	}
}
