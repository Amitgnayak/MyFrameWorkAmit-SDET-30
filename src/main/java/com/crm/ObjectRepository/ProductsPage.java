package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage 
{
	@FindBy(xpath = "//img[@title='Create Product...']")
	private WebElement createProductstLookUpImg;
	
	public ProductsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	
	public WebElement getCreateProductstLookUpImg()
	{
		return createProductstLookUpImg;
	}



	// business libraray
	/**
	 * This method will click on the Create product lookup img
	 */
	
	public void clickOnProductLookUpImg()
	{
		createProductstLookUpImg.click();
	}
	
	

}
