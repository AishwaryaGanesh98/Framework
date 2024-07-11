package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookReadDataFromSameClass {
	public  static WebDriver driver;
    @BeforeMethod
	public void precondition() {
    	driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.facebook.com/");
	}
    @AfterMethod
	public void postcondition() {
		driver.manage().window().minimize();
		driver.quit();
	}
	    @Test(dataProvider = "supplyTheDatatoAcceptTheDataMethod")
		public void acceptTheDataFromSupplyTheDataMethod(String email, String password) {
		driver.findElement(By.id("email")).sendKeys(email);	
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.name("login")).click();
		}
		@DataProvider
	    public Object[][] supplyTheDatatoAcceptTheDataMethod() {
			Object[][] obj = new Object[3][2];
			//firstpersondata
			obj[0][0]="aish98@gmail.com";
			obj[0][1]="123456";
			//secondpersondata
			obj[1][0]="vish98@gmail.com";
			obj[1][1]="123456";
			//thirdpersondata
			obj[2][0]="nish98@gmail.com";
			obj[2][1]="123456";
			return obj;
					}
	}

