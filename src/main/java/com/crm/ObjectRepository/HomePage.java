package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;

public class HomePage extends WebDriverUtility
{
	// step 1: declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productsLnk;
	
	@FindBy(linkText = "More")
	private WebElement moreLnk;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorImg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLnk;
	
	@FindBy(linkText = "Opportunities")
	private WebElement opportunitiesLnk;
	
	// initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	// utilization - provide getter
	public WebElement getOrganizationLnk()
	{
		return organizationLnk;
	}

	public WebElement getContactsLnk()
	{
		return contactsLnk;
	}

	public WebElement getProductsLnk() 
	{
		return productsLnk;
	}

	public WebElement getMoreLnk() 
	{
		return moreLnk;
	}

	public WebElement getCampaignsLnk() 
	{
		return campaignsLnk;
	}

	public WebElement getAdministratorImg() 
	{
		return administratorImg;
	}

	public WebElement getSignOutLnk() 
	{
		return signOutLnk;
	}
	
	public WebElement getOpportunitiesLnk()
	{
		return opportunitiesLnk;
	}
	
	// business library
	
	


	public void clickOnOrgLnk()
	{
		organizationLnk.click();
	}
	
	public void clickOnContactsLnk()
	{
		contactsLnk.click();
	}
	
	public void signOutOfApp(WebDriver driver)
	{
		mouseHover(driver, administratorImg);
		signOutLnk.click();
		
	}
	public void clickOnProductLnk()
	{
		productsLnk.click();
	}
	public void clickOnMoreLnk(WebDriver driver)
	{
		mouseHover(driver, moreLnk);
		campaignsLnk.click();
	}
	public void clickOnOpportunitieslnk()
	{
		opportunitiesLnk.click();
	}
	
	
}


















