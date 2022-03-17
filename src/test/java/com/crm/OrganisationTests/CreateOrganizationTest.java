package com.crm.OrganisationTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CreateOrganizationTest {
	@Test
	public void createOrganizationTest()
	{
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:8888");
		
		// step2: login to application
		
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		// step 3:naviagte to organization link
		
		driver.findElement(By.linkText("Organizations")).click();
		
		//step4: click on create organization link
		
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		//step 5: create the organization
		
		driver.findElement(By.name("accountname")).sendKeys("xyz");
		
		// step 6: save the details
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		driver.quit();
		
	}

}