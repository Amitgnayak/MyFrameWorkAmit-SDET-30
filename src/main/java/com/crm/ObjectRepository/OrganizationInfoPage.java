package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage 
{
	// step 1: declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerText;
	
	// step 2: initialization
	
	public  OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	
	}
	// step 3: utilization
	public WebElement getHeaderText() {
		return headerText;
	}

	// business library
	public String OrgNameInfo() 
	{
	String OrgInfo = headerText.getText();
	return OrgInfo;
	
	}

}
