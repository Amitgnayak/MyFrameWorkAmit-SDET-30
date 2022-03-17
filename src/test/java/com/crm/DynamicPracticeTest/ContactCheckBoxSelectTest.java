package com.crm.DynamicPracticeTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.ObjectRepository.ContactsPage;
import com.crm.ObjectRepository.HomePage;
import com.crmGenericLibrary.BaseClass;

public class ContactCheckBoxSelectTest extends BaseClass
{
	@Test
	public void contactCheckBoxSelectAllTest()
	{
		HomePage hp= new HomePage(driver);
				hp.clickOnContactsLnk();
				
				List<WebElement> checkBoxes = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[1]/input[@name='selected_id']"));
				int count =checkBoxes.size();
				for(int i=0; i<count; i++)
				{
					WebElement cb= checkBoxes.get(i);
					cb.click();
				}
	}
}
