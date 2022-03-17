package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignsInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement campaignHeader;
	
	public CampaignsInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignHeader()
	{
		return campaignHeader;
	}
	
	
	//Business library
	public String campaignInfo()
	{
		String campaignHeaderName = campaignHeader.getText();
		return campaignHeaderName;
	}
	
	
	


}
