package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;

public class ContactsPage extends WebDriverUtility
{
	//declaration
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactLookUpImg;
	
	// initialization
	
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	// utilization
	
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}
	
	// Business libraries
	
	public void clickOnCreateContactImg()
	{
		createContactLookUpImg.click();
	}
	
	
}
