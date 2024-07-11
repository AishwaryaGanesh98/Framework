package com.trello.qsp.genericutility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class BaseClass {
	public WebDriverUtility webdriverutils = new WebDriverUtility();
	public JavaUtility javautils = new JavaUtility();
	public FileUtility fileutils = new FileUtility();
	public ExcelUtility excelutils = new ExcelUtility();
	public static WebDriver driver;
    @Parameters("browser")
    @BeforeMethod
     //public void precondition(@Optional("edge") String browserName) throws IOException {
	public void precondition() throws IOException {
		String browserName = fileutils.readTheDataFromPropertyFile("browser");
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webdriverutils.implicitWait(driver);
		driver.get(fileutils.readTheDataFromPropertyFile("url"));
	}
	
	/*@Test(dataProvider = "supplyTheDatatoAcceptTheDataMethod")
  	public void acceptTheDataFromSupplyTheDataMethod(String browserName) throws IOException {
    	if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		webdriverutils.implicitWait(driver);
		driver.get(fileutils.readTheDataFromPropertyFile("url"));	
  	}
  	@DataProvider
      public Object[][] supplyTheDatatoAcceptTheDataMethod() {
  		Object[][] obj = new Object[1][1];
  		//browsername
  		obj[0][0]="edge";
  		return obj;
  	}*/
	
	@AfterMethod
	public void postcondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	
	public void takeScreenShot(String testMethod) throws IOException {
		javautils.timeStamp();
		TakesScreenshot tss= (TakesScreenshot) driver; 
		 File tempFile = tss.getScreenshotAs(OutputType.FILE);
        File permFile = new File("./errorShots/" + javautils.timeStamp() + " " + testMethod + "ScreenShot.png");
        	FileUtils.copyFile(tempFile, permFile);
}
}
