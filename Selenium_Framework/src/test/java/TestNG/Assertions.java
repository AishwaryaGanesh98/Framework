package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
	WebDriver driver;
	@Test
	public void softAssert()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    username.sendKeys("admin");
	    WebElement password = driver.findElement(By.id("password"));
	    password.clear();
	    password.sendKeys("admin");
	    WebElement signin= driver.findElement(By.xpath("//button[text()='Sign in']"));
	    signin.submit();
	    SoftAssert softassert = new SoftAssert();
	    softassert.assertEquals(driver.getTitle(), "Dashboard", "The Dashboard page title is not verified");
	    String dashboardURL = driver.getCurrentUrl();
	    System.out.println("Dashboard URL = "+dashboardURL);
	    driver.manage().window().minimize();
		driver.quit();
		softassert.assertAll();
	}

	@Test
	public void hardAssert()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://demo.vtiger.com/vtigercrm/");
		WebElement username = driver.findElement(By.id("username"));
	    username.clear();
	    username.sendKeys("admin");
	    WebElement password = driver.findElement(By.id("password"));
	    password.clear();
	    password.sendKeys("admin");
	    WebElement signin= driver.findElement(By.xpath("//button[text()='Sign in']"));
	    signin.submit();
	    Assert.assertEquals(driver.getTitle(), "Dashboard", "The Dashboard page title is not verified");
	    String dashboardURL = driver.getCurrentUrl();
	    System.out.println("Dashboard URL = "+dashboardURL);
	    driver.manage().window().minimize();
		driver.quit();
	}
}






