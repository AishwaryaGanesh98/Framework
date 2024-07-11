package com.trello.qsp.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends Baseclass1 implements ITestListener{

	@Override
	public void onTestFailure(ITestResult result) {
		try
		{
			failed(result.getMethod().getMethodName());
		}catch(Exception e)
		{
			
		}
	}

}
