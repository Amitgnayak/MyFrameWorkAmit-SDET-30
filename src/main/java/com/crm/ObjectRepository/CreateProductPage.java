package com.crm.ObjectRepository;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;


public class CreateProductPage extends WebDriverUtility
{
	@FindBy(name = "productname")
	private WebElement productNameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getProductNameEdt()
	{
		return productNameEdt;
	}
	public WebElement getSaveBtn() 
	{
		return saveBtn;
	}
	
	// business libraray
	
	

	public void createProduct(String prodName)
	{
		productNameEdt.sendKeys(prodName);
		saveBtn.click();
	}
	
	

}



