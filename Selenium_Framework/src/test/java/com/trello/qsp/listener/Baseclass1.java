package com.trello.qsp.listener;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Baseclass1 {
	public  static WebDriver driver;
    @BeforeMethod
	public void precondition() {
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.trello.com/");
	}
    @AfterMethod
	public void postcondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	public void failed(String testMethod) throws IOException
	{
		String timestamp = LocalDateTime.now().toString().replace(':', '-');
		TakesScreenshot tss= (TakesScreenshot) driver; 
		 File tempFile = tss.getScreenshotAs(OutputType.FILE);
         File permFile = new File("./errorshots/"+testMethod+timestamp+"screenshot.png");
         	FileUtils.copyFile(tempFile, permFile);

	}

}
