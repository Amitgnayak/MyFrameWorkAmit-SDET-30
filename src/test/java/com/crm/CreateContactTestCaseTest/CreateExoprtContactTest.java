package com.crm.CreateContactTestCaseTest;

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
import org.testng.annotations.Test;

public class CreateExoprtContactTest
{
@Test
	public void createExoprtContactTest() throws IOException 
	{
		Random ran= new Random();
		int random = ran.nextInt(1000);
		
		/*Read necessary data */
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj= new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		/*read the data from excel*/
		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Contacts");
		Row ro = sh.getRow(7);
		Cell cel = ro.getCell(2);
		String Lastname = cel.getStringCellValue();
		
		/*launch the browser*/
		
		WebDriver driver= null;
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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		
		/*login to the application*/
		
		driver.findElement(By.className("user_name")).sendKeys(USERNAME);
		driver.findElement(By.className("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*navigate to contact link*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*create a new contact and save*/

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.className("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
/*logout*/		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();

		
	}
}
