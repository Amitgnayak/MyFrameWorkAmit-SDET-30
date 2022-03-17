package com.crmGenericLibrary;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * this class consist of all the generic methods related to WebDriverActions
 * @author user
 *
 */
public class WebDriverUtility 
{
	
	/**
	 * this method will maximize the window
	 * @param driver
	 */
	
public void maximizeWindow(WebDriver driver)
{
	driver.manage().window().maximize();
}

/**
 * this method will wait for 20 seconds for the page to load
 * @param driver
 */

public void waitForPageLoad(WebDriver driver)
{
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
}

/** 
 * this method will wait for 10 seconds for the elements to be clickable
 * @param driver
 * @param element
 */

public void waitForElementToBeClickable(WebDriver driver, WebElement element)
{
	WebDriverWait wait=new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(element));
}

/**
 * this method will wait for 20 seconds for the element to be visible
 * @param driver
 * @param element
 */
public void waitForElementToBeVisible(WebDriver driver, WebElement element)
{
	WebDriverWait wait= new WebDriverWait(driver, 20);
	wait.until(ExpectedConditions.visibilityOf(element));
}


/**
 * this method will select the data from dropdown using index
 * @param element
 */
public void select(WebElement element, int index)
{
	Select sel = new Select(element);
	sel.selectByIndex(index);
}


/**
 * this method will select the data from dropdown using visible text
 * @param element
 * @param text
 */
public void select(WebElement element, String text)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
}

/**
 * this method will select the data from drop down using value
 * @param text
 * @param element
 */
	public void select(String value, WebElement element)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}
	/**
	 * this method is used to perform mouse hover action
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
	}

	/**
	 * this method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param target
	 */
 public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
 {
	 Actions act = new Actions(driver);
	 act.dragAndDrop(src, target).perform();
 }

 /**
  * this method will double click on element
  * @param driver
  * @param element
  */
 public void doubleClickAction(WebDriver driver, WebElement element)
 {
	 Actions act = new Actions(driver);
	 act.doubleClick(element).perform();
	 
 }

 
 /**
  * this method will double click on webpage
  * @param driver
  */
 public void doubleClickAction(WebDriver driver)
 {
	 Actions act= new Actions(driver);
	 act.doubleClick().perform();
 }
 
 
 /**
  * this method will right click on webpage
  * @param driver
  */
 public void rightClick(WebDriver driver)
 {
	 Actions act= new Actions(driver);
	 act.contextClick().perform();
 }
 
 /**
  * this method will right on element
  * @param driver
  * @param element
  */
 public void rightClick(WebDriver driver, WebElement element) 
 {
	 Actions act = new Actions(driver);
	 act.contextClick(element).perform();
	 
 }
 
 /**
  * this method will pass enter key
  * @param driver
  */
 
 public void enterKeyPress(WebDriver driver)
 {
	 Actions act = new Actions(driver);
	 act.sendKeys(Keys.ENTER).perform();
}

 /**
  * this method will press enter key
  * @throws AWTException
  */
 	public void enterKeyPress() throws Throwable
 	{
 		Robot rb= new Robot();
 		rb.keyPress(KeyEvent.VK_ENTER);
 	}
 
 	/**
 	 * this method will release the enter key
 	 * @throws Throwable
 	 */
 	
 public void enterKeyRelease() throws Throwable 
 {
	 Robot rb = new Robot();
	 rb.keyRelease(KeyEvent.VK_ENTER);
	 
 }
 
 	/**
 	 * this method will switch the frame based on index
 	 * @param driver
 	 * @param index
 	 */
 	public void switchToFrame(WebDriver driver, int index)
 	{
 		driver.switchTo().frame(index);
 	}
 	
 	/**
 	 * this method will switch the frame based on name or ID
 	 * @param driver
 	 * @param nameOrId
 	 */
 	
 	public void switchToFrame(WebDriver driver, String nameOrId)
 	{
 	driver.switchTo().frame(nameOrId);	
 	}
 	
 	/**
 	 * this method will switch the frame based on address of the element
 	 * @param driver
 	 * @param address
 	 */
 	public void switchToFrame(WebDriver driver, WebElement address)
 	{
 		driver.switchTo().frame(address);
 	}
 	
 	/**
 	 * this method will accept the alert popup 
 	 * @param driver
 	 */
 	
 	public void acceptAlert(WebDriver driver)
 	{
 		driver.switchTo().alert().accept();
 	}
 	
 	
 	/**
 	 * this method will cancel the alert popup 
 	 * @param driver
 	 */
 	public void cancelAlert(WebDriver driver)
 	{
 		driver.switchTo().alert().dismiss();
 	}
 	
 	
 	
 	/**
 	 * this method will switch the window depend on partial window title
 	 * @param driver
 	 * @param partialWinTitle
 	 */
 	public void switchToWindow(WebDriver driver, String partialWinTitle)
 	{
 		// step 1: use getWindowHandles to capture all the window Ids
 		Set<String> window = driver.getWindowHandles();
 		
 		// step 2: iterate through the windows
 		Iterator<String> it = window.iterator();
 		
 		// step 3: check whether there is next window 
 		while(it.hasNext())
 		{
 			// step 4: capture the current window id
 			String winId = it.next();
 			
 			//step 5: switch to current window and capture title
 			
 			String currentWinTitle = driver.switchTo().window(winId).getTitle();
 			
 			// step 6: check whether the current window is expected.
 			if(currentWinTitle.contains(partialWinTitle))
 			
 			{
 				break;
 			}
 				
  		}
 	}
 	/**
 	 * this method will take screenshot and store it in a folder called a screenshot 
 	 * @param driver
 	 * @param screenShotName
 	 * @return 
 	 * @throws IOException
 	 */
 	 
 	
 	public String getScreenShot(WebDriver driver, String screenShotName) throws IOException
 	{
 		TakesScreenshot ts = (TakesScreenshot) driver;
 		File src = ts.getScreenshotAs(OutputType.FILE);
 		String path= ".\\Screenshot\\"+screenShotName+".png";
 		File dst = new File(path);
 		Files.copy(src, dst);
 		return path;
 	}
 	
 	/**
 	 * this method will perform random scroll
 	 * @param driver
 	 */
 	
 	public void scrollAction(WebDriver driver)
 	{
 		JavascriptExecutor js= (JavascriptExecutor) driver;
 		js.executeScript("window.scrollBy(0,500)", "");
 	}
 	
 	/**
 	 * this method will scroll until the specified element is found
 	 * @param driver
 	 * @param element
 	 */
 	public void scrollAction(WebDriver driver, WebElement element)
 	{
 		JavascriptExecutor js= (JavascriptExecutor) driver;
 		int y = element.getLocation().getY();
 		js.executeScript("window.scrollBy(0,"+y+")", element);
 		// js.executeScript("argument[0].scrollIntoView()", element)
 	}
}


























