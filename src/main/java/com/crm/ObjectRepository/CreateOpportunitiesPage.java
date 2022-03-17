package com.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crmGenericLibrary.WebDriverUtility;

public class CreateOpportunitiesPage extends WebDriverUtility
{
	//declaration
		@FindBy(name = "potentialname")
		private WebElement opportunityNameEdt;
		
		@FindBy(name = "related_to_type")
		private WebElement relatedToDropDown;
		
		@FindBy(name = "search_text")
		private WebElement searchEdt;
		
		@FindBy(name = "search")
		private WebElement seacrhNowBtn;
		
		@FindBy(xpath = "//input[@name='related_to_display']/following-sibling::img[@title='Select']")
		private WebElement reportToLookUpImg;
		
		@FindBy(name = "leadsource")
		private WebElement leadSourceDropDown;
		
		@FindBy(xpath = "//input[@name='campaignname']/following-sibling::img[@title='Select']")
		private WebElement campaignSourceLookUpImg;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']")
		private WebElement saveBtn;
		
		//initilization
		public CreateOpportunitiesPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}
		
		//utilization

		public WebElement getOpportunityNameEdt()
		{
			return opportunityNameEdt;
		}

		public WebElement getRelatedToDropDown() 
		{
			return relatedToDropDown;
		}

		public WebElement getSearchEdt() 
		{
			return searchEdt;
		}

		public WebElement getSeacrhNowBtn() 
		{
			return seacrhNowBtn;
		}

		public WebElement getReportToLookUpImg() 
		{
			return reportToLookUpImg;
		}

		public WebElement getLeadSourceDropDown() 
		{
			return leadSourceDropDown;
		}

		public WebElement getCampaignSourceLookUpImg() 
		{
			return campaignSourceLookUpImg;
		}

		public WebElement getSaveBtn() 
		{
			return saveBtn;
		}
		
		//business library
		/**
		 * This method will create the Opportunity with organization
		 * @param opportunityName
		 * @param relatedTo
		 * @param driver
		 * @param orgName
		 */
		public void createOpportinities(String opportunityName, String relatedTo, WebDriver driver,String orgName)
		{
			opportunityNameEdt.sendKeys(opportunityName);
			select(relatedTo, relatedToDropDown);
			reportToLookUpImg.click();
			switchToWindow(driver, "Accounts");
			searchEdt.sendKeys(orgName);
			seacrhNowBtn.click();
			driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
			switchToWindow(driver, "Potentials");
			saveBtn.click();
			
		}
		/**
		 * This Method will create the opportunity with contact
		 * @param opportunityName
		 * @param driver
		 * @param relatedTo
		 * @param contactName
		 */
		public void createOpportinities(String opportunityName, WebDriver driver,String relatedTo,String contactName, String leadSource, String campaignName)
		
		{
			opportunityNameEdt.sendKeys(opportunityName);
			select(relatedTo, relatedToDropDown);
			reportToLookUpImg.click();
			switchToWindow(driver, "Contacts");
			searchEdt.sendKeys(contactName);
			seacrhNowBtn.click();
			driver.findElement(By.xpath("//a[text()='"+" "+contactName+"']")).click();
			switchToWindow(driver, "Potentials");
			select(leadSource, leadSourceDropDown);
			campaignSourceLookUpImg.click();
			switchToWindow(driver, "Campaigns");
			searchEdt.sendKeys(campaignName);
			seacrhNowBtn.click();
			driver.findElement(By.xpath("//a[text()='"+campaignName+"']")).click();
			switchToWindow(driver, "Potentials");
			saveBtn.click();
			
		}
		
		

	}



