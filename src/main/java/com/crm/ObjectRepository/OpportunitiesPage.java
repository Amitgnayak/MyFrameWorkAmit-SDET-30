package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportunitiesPage 
{
	@FindBy(xpath = "//img[@title='Create Opportunity...']")
	private WebElement createOpportunitesLookUpImg;
	
	public  OpportunitiesPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateOpportunitesLookUpImg() 
	{
		return createOpportunitesLookUpImg;
	}
	
	
	//Business Library
	public void clickOnCreateOpportuniesImg()
	{
		createOpportunitesLookUpImg.click();
	}
	


}
