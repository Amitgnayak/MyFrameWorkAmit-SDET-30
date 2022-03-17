package com.crm.DynamicPracticeTest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crmGenericLibrary.BaseClass;

public class ContactSelectAndDeleteTest extends BaseClass
{
	@Test
	public void contactSelectAndDelete() throws Throwable
	{
		HomePage hp= new HomePage(driver);
		hp.clickOnContactsLnk();
		
		driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[1]//input[@name='selected_id'])[5]")).click();
		
		driver.findElement(By.xpath("(//table[@class='lvt small']/tbody/tr[*]/td[10]/a[.='del'])[5]")).click();
		Thread.sleep(3000);
		wLib.acceptAlert(driver);
		
	}
}
