package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParallelParameterCrossBrowserExecution {
		WebDriver driver;
		 
		@Parameters({"browserName","url"})
		@BeforeMethod
		public void precondition(String browserName, String url) throws InterruptedException
		{
			if(browserName.equals("chrome"))
		driver = new ChromeDriver();
			else if(browserName.equals("edge"))
				driver = new EdgeDriver();
			else if(browserName.equals("firefox"))
				driver = new FirefoxDriver();
			Thread.sleep(2000);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(url);
		}
		
		@AfterMethod
		public void postcondition()
		{
		driver.manage().window().minimize();
		driver.quit();
		}
		
		@Parameters({"userName","passWord"})
		@Test
		public void loginToVtiger(String userName, String passWord) throws InterruptedException
		{
		WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    Thread.sleep(2000);
	    username.sendKeys(userName);
	    Thread.sleep(2000);
	    WebElement password = driver.findElement(By.id("password"));
	    password.clear();
	    Thread.sleep(2000);
	    password.sendKeys(passWord);
	    Thread.sleep(2000);
	    WebElement signin= driver.findElement(By.xpath("//button[text()='Sign in']"));
	    signin.submit();
	    Thread.sleep(2000);
		}

	}


