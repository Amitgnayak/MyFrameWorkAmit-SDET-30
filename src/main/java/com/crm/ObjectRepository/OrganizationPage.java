package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;

public class OrganizationPage extends WebDriverUtility
{
	
	// step 1: declaration
	
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	// step2: initialization
	
	public OrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}
	
	// business library
	public void clickOnCreateOrgImg() 
	{
		createOrgLookUpImg.click();
	}
	
	
	
}
