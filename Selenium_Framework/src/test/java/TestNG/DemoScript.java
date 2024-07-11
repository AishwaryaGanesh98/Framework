package TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class DemoScript {
	WebDriver driver;
    
	@BeforeClass
	public void precondition()
	{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@AfterClass
	public void postcondition()
	{
	driver.manage().window().minimize();
	driver.quit();
	}
	
	@Test(invocationCount = 2, threadPoolSize = 2)
	public void loginToVtiger()
	{
	driver.get("https://demo.vtiger.com/vtigercrm/");
	WebElement username = driver.findElement(By.id("username"));
    username.clear();
    username.sendKeys("admin");
    WebElement password = driver.findElement(By.id("password"));
    password.clear();
    password.sendKeys("admin");
    WebElement signin= driver.findElement(By.xpath("//button[text()='Sign in']"));
    signin.submit();
    WebElement icon = driver.findElement(By.xpath("//span[@title='Vtiger Demo Administrator(admin)']"));
    icon.click();
    WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
    signout.click();
    Reporter.log("Login method is executed", true);
	}
	
	@Test(enabled = false)
	public void loginToFacebook()
	{
	driver.get("https://www.facebook.com/"); 
	WebElement email=driver.findElement(By.id("email"));
	email.sendKeys("abc@gmail.com");
	 WebElement password=driver.findElement(By.id("pass"));
	 password.sendKeys("123456");
	WebElement login=driver.findElement(By.name("login"));
	login.submit();
	}
	
	@Test(priority = 1, dependsOnMethods = "loginToVtiger")
	public void mouseHoverOnMyntra()
	{
	driver.get("https://www.myntra.com/");
	WebElement menLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Men']"));
	 WebElement womenLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Women']"));
	 WebElement kidsLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Kids']"));
	 WebElement homeAndLivingLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Home & Living']"));
	 WebElement beautyLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Beauty']"));
	 WebElement studioLink=driver.findElement(By.xpath("//div[@class='desktop-navLink']/a[text()='Studio']"));
	 Actions actions = new Actions(driver);
	 actions.moveToElement(menLink).pause(1000).moveToElement(womenLink).pause(1000).moveToElement(kidsLink).pause(1000).moveToElement(homeAndLivingLink).pause(1000).moveToElement(beautyLink).pause(1000).moveToElement(studioLink).perform();
	}

}
