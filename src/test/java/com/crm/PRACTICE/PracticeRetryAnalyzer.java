package com.crm.PRACTICE;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeRetryAnalyzer 
{
	@Test(retryAnalyzer= com.crmGenericLibrary.RetryAnalyzerimplementation.class)
	
		public void practiceRetry()
		{
			System.out.println("this is test 1");
			Assert.fail();
			System.out.println("this is passed");
		}
	}
