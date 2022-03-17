package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
// declaration using -FindBy
	@FindBy(name = "user_name")
	private WebElement userEdt;
	
	@FindBy(name= "user_password")
	private WebElement passwordEdt;
	
	@FindBy(id = "submitButton")
	private WebElement submitBtn;
	
	// step 2: initialize - use constructor
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization- provide getter

	public WebElement getUserEdt() {
		return userEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// Business Library
	public void LoginToApp(String userName, String password)
	{
		userEdt.sendKeys("admin");
		passwordEdt.sendKeys("admin");
		submitBtn.click();
	}
	
	
}




















