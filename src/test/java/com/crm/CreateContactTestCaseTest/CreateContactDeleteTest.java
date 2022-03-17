package com.crm.CreateContactTestCaseTest;

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

import com.mysql.cj.jdbc.Driver;

public class CreateContactDeleteTest 
{
	@Test
	
		public void createContactDeleteTest() throws Throwable
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
		String Lastname = cel.getStringCellValue()+""+random;
		Row ro1 = sh.getRow(10);
		Cell cel1 = ro.getCell(2);
		String repoterName = cel1.getStringCellValue()+""+random;		
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
		
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		/*navigate to contact link*/
		driver.findElement(By.linkText("Contacts")).click();
		
		/*create a new contact and save*/

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(Lastname);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		

		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(repoterName);
		driver.findElement(By.xpath("//input[@name='contact_name']/following-sibling::img[@title='Select']")).click();
		Set<String> wind = driver.getWindowHandles();
		for(String WindID: wind)
		{
			driver.switchTo().window(WindID);
		}
		driver.findElement(By.name("search_text")).sendKeys(Lastname);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='" +Lastname+"']")).click();
		Set<String> wind2 = driver.getWindowHandles();
		for (String wind3:wind2)
		{
			driver.switchTo().window(wind3);
		}
		driver.findElement(By.xpath("//input[@alt='Clear']")).click();
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		String ConHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		
		if(ConHeader.contains(repoterName))
		{
			System.out.println(ConHeader);
			System.out.println("contacted is created with repoter");
		}
		else {
			System.out.println(ConHeader);
			System.out.println("contact is not created with reporter");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act=new Actions(driver);
		act.moveToElement(ele);
		driver.findElement(By.linkText("Sign Out")).click();
		driver.quit();
		}	
		
}

