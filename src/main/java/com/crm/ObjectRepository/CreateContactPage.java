package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crmGenericLibrary.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility
{
	// declaration
	@FindBy(name="lastname")
	private WebElement lastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement orgNameLookUpimg;
	
	@FindBy(name ="search_text")
	private WebElement searchEdt;
	
	@FindBy(name="search")
	private WebElement searchNowBtn;
	
	@FindBy(name = "leadsource")
	private WebElement leadSourceDropDown;
	
	@FindBy(xpath = "//input[@name='contact_name']/following-sibling::img[@title='Select']")
	private WebElement selectReportsLookUpImg;
	
	@FindBy(name = "assigntype")
	private WebElement groupRadioBtn;
	
	@FindBy(name = "assigned_group_id")
	private WebElement assignToGroupDropDown;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement submitBtn;
	
	// initialization
	
	public CreateContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	// utilization
	
	public WebElement getLastNameEdt() 
	{
		return lastNameEdt;
	}

	public WebElement getSlectOrgnameLookUpimg() {
		return orgNameLookUpimg;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}

	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}

	public WebElement getLeadSourceDropDown() {
		return leadSourceDropDown;
	}

	public WebElement getSelectReportsLookUpImg() {
		return selectReportsLookUpImg;
	}

	public WebElement getGroupRadioBtn() {
		return groupRadioBtn;
	}

	public WebElement getAssignToGroupDropDown() {
		return assignToGroupDropDown;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	// business Libraries
	/**
	 * this method will create the contact
	 * @param lastName
	 */
	
	public void createContact(String lastName)
	{
		lastNameEdt.sendKeys(lastName);
		submitBtn.click();
	}
	
	
	/**
	 * this method will create the contact with organization
	 * @param driver
	 * @param lastName
	 * @param orgName
	 */
	public void createContact(WebDriver driver, String lastName, String orgName)
	{
		lastNameEdt.sendKeys(lastName);
		orgNameLookUpimg.click();
		switchToWindow(driver, "Accounts");
		searchEdt.sendKeys(orgName);
		searchNowBtn.click();
		driver.findElement(By.xpath("//a[.='"+orgName+"']")).click();
		switchToWindow(driver, "Contacts");
		submitBtn.click();
	}
	
	/**
	 * this method will create the contact with lead source
	 * @param lastName
	 * @param leadSoure
	 */
	public void createContact(String lastName, String leadSoure)
	{
	lastNameEdt.sendKeys(lastName);
	select(leadSoure, leadSourceDropDown);
	submitBtn.click();
	}
}






















