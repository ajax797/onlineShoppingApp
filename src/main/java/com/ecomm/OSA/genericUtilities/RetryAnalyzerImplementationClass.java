package com.ecomm.OSA.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzerImplementationClass implements IRetryAnalyzer
{
	int count=1;
	int limit=2;
	@Override
	public boolean retry(ITestResult result) 
	{
		if(count<=limit)
		{
			count++;
			return true;
		}
		return false;
	}

}
