package TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class CustomListener extends BaseClass implements ITestListener {

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


