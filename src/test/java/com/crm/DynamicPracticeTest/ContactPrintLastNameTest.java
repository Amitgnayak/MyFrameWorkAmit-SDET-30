package com.crm.DynamicPracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.HomePage;
import com.crmGenericLibrary.BaseClass;

public class ContactPrintLastNameTest extends BaseClass
{
	@Test
	public void printLastNameContactTest()
	{
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLnk();
		
		List<WebElement> ele = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[4]/a[@title='Contacts']"));
		int count = ele.size();
		for(int i=0;i<count;i++)
		{
			WebElement element = ele.get(i);
			String text = element.getText();
			System.out.println(text);
			
		}
	}
	
}
