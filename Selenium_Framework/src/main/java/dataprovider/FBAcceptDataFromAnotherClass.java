package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class FBAcceptDataFromAnotherClass {

    @Test(dataProvider = "supplyTheData", dataProviderClass = FBSupplyDataToAnotherClass.class)
	public void acceptTheData(String firstname, String lastname, String mobilenumber, String password) throws InterruptedException {
    WebDriver	driver = new ChromeDriver();
    driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.facebook.com/signup");
	Thread.sleep(2000);
	driver.findElement(By.name("firstname")).sendKeys(firstname);
	driver.findElement(By.name("lastname")).sendKeys(lastname);
	driver.findElement(By.name("reg_email__")).sendKeys(mobilenumber);
	driver.findElement(By.name("reg_passwd__")).sendKeys(password);
	driver.findElement(By.name("websubmit")).click();
	driver.manage().window().minimize();
	driver.quit();
	}
}
