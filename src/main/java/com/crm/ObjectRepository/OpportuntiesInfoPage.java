package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportuntiesInfoPage 
{
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement opportunityHeader;
	
	public OpportuntiesInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOpportunityHeader() 
	{
		return opportunityHeader;
	}
	
	
	//business Library
	/**
	 * This method will fetch the Opportunity header
	 * @return
	 */
	public String opportunityInfo()
	{
		String oppHeaderName = opportunityHeader.getText();
		return oppHeaderName;
	}

}
