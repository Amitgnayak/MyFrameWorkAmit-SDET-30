package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsPage 
{
	@FindBy(xpath = "//img[@title='Create Campaign...']")
	private WebElement createCampaignsLookUpImg;
	
	public CampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateCampaignsLookUpImg() 
	{
		return createCampaignsLookUpImg;
	}
	
	
	//business library
	public void clickOnCampaignsLookUpImg()
	{
		createCampaignsLookUpImg.click();
	}


}
