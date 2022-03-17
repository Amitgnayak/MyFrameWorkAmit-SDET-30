package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;

public class CreateCampaignsPage extends WebDriverUtility
{
	@FindBy(name = "campaignname")
	private WebElement campaignNameEdt;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement productLookUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;
	
	@FindBy(name = "search")
	private WebElement serachNowBtn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateCampaignsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameEdt() 
	{
		return campaignNameEdt;
	}

	public WebElement getProductLookUpImg() 
	{
		return productLookUpImg;
	}

	public WebElement getSearchEdt() 
	{
		return searchEdt;
	}

	public WebElement getSerachNowBtn() 
	{
		return serachNowBtn;
	}

	public WebElement getSaveBtn()
	{
		return saveBtn;
	}

	
	
	//Business Library
	/**
	 * This method will create the campaign
	 * @param campaignName
	 */
	public void createCampaign(String campaignName)
	{
		campaignNameEdt.sendKeys(campaignName);
		saveBtn.click();
	}
	
	/**
	 * This method will create the campaign with product name
	 * @param campaignName
	 * @param driver
	 * @param prodName
	 */
	public void createCampaign(String campaignName,WebDriver driver, String prodName)
	{
		campaignNameEdt.sendKeys(campaignName);
		productLookUpImg.click();
		switchToWindow(driver, "Products");
		searchEdt.sendKeys(prodName);
		serachNowBtn.click();
		driver.findElement(By.xpath("//a[text()='"+prodName+"']")).click();
		switchToWindow(driver, "Campaigns");
		saveBtn.click();
	}
	
	

}
