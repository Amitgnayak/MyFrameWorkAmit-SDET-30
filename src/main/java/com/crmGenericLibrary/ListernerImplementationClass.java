package com.crmGenericLibrary;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class ListernerImplementationClass implements ITestListener 
{
		ExtentReports report;
		ExtentTest test;
		
	public void onTestStart(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		test= report.createTest(methodName);
		
	}

	public void onTestSuccess(ITestResult result)
	{
		String MethodName = result.getMethod().getMethodName();
	test.log(Status.PASS, MethodName+"---------------> passed");
	}

	public void onTestFailure(ITestResult result)
	{
		String path = null;
		String MethodName = result.getMethod().getMethodName()+"-";
		
		
		//Step 1: Configure screenshot name
		String screenshotName = MethodName+new javaUtility().getSystemDateInformat();
		System.out.println(screenshotName);
		
		//Step 2: using screenshot method from webDriver Utility
		try {
			
			path=new WebDriverUtility().getScreenShot(BaseClass.sDriver, screenshotName);
			
	
			//EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass.sDriver);
			//File src = eDriver.getScreenshotAs(OutputType.FILE);
			//String pa = System.getProperty("user.dir")+"/ScreenShots/"+screenshotName+".PNG";
			//String path = "./Screenshots/"+screenshotName+".png";
			//File dst = new File(pa);
			//Files.copy(src, dst);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
			test.log(Status.FAIL, MethodName+ "---->failed");
			//it will capture the execution and log it in the report
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(path);
			

	}

	public void onTestSkipped(ITestResult result) 
	{
		String MethodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, MethodName+"------->skipped");
		//it will capture the execution and log it in the report
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	public void onTestFailedWithTimeout(ITestResult result) 
	{
		
	}

	public void onStart(ITestContext context) 
	{
		//Execution will start here
		/*configure the report*/
		ExtentSparkReporter htmlReport = new ExtentSparkReporter("./ExtentReports/Reports"+new javaUtility().getSystemDateInformat()+".html");
		htmlReport.config().setDocumentTitle("SDET-30 Execution Report");
		htmlReport.config().setTheme(Theme.DARK);
		htmlReport.config().setReportName("selenium execution report");
		
		report= new ExtentReports();
		report.attachReporter(htmlReport);
		report.setSystemInfo("Base-Browser", "Chrome");
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("base-url", "http://localhost:8888");
		report.setSystemInfo("Reporter Name", "Amit");
		
	}

	public void onFinish(ITestContext context)
	{
		//consolidate all the parameters and generate the report
		report.flush();
	}
	
}
