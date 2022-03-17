package com.crm.DynamicPracticeTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crmGenericLibrary.BaseClass;

public class ContactCheckBoxLastSelectTest extends BaseClass 
{
	@Test
	public void contactCheckBoxLastSelect() throws Throwable
	{
		HomePage hp= new HomePage(driver);
		hp.clickOnContactsLnk();
		
		WebElement lastBox = driver.findElement(By.xpath("(//input[@name='selected_id'])[last()]"));
		
		
	}

}
