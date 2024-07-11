package extentreports;
import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class ExtentReportDemoScript extends ExtentReportsDemo{
org.apache.logging.log4j.Logger log;

@BeforeTest
public void startReport()
{
	extentReportCode();
}
@Test
public void testCase() 
{
log = org.apache.logging.log4j.LogManager.getLogger(this.getClass().getName());
String methodName = new Exception().getStackTrace()[0].getMethodName();
String className = new Exception().getStackTrace()[0].getClassName();
test = reports.createTest(methodName, "Logging in to the Facebook application");
test.log(Status.INFO, "Starting to open Facebook Login page");
test.assignCategory("Functionality Test");
Reporter.log("Trigger the URL to login to Facebook application");
driver.get("https://www.facebook.com/");
driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
driver.findElement(By.id("pass")).sendKeys("abc123"); 
driver.findElement(By.name("login")).click();
Reporter.log("User has successfully logged in");
}
@AfterTest
public void endTest()
{
reports.flush();	
}
}
