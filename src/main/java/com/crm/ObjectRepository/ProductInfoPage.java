package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInfoPage 
{
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement productHeader;
	
	public ProductInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductHeader() 
	{
		return productHeader;
	}
	
	// business library
	/**
	 * This method will fetch the product header text
	 * @return
	 */
	public String productInfo()
	{
		String prodHeader = productHeader.getText();
		return prodHeader;
	}
	
	

}
