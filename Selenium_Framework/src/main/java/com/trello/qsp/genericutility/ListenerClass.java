package com.trello.qsp.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends BaseClass implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		System.out.println("failed test case");
		try {
			takeScreenShot(result.getMethod().getMethodName());
		} catch (Exception e) {
			
		}
	}

}
