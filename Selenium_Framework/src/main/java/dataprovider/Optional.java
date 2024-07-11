package dataprovider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Optional {
WebDriver driver;

@Parameters({"browsername", "url", "username", "password"})
@Test
public void  loginToVtiger(@org.testng.annotations.Optional("EDGE") String browsername, String url, String username, String password)
{
/*switch(browsername.toLowerCase())
{
case "chrome":
	driver = new ChromeDriver();
	break;
case "edge":
	driver = new EdgeDriver();
	break;
case "firefox":
	driver = new FirefoxDriver();
}*/
	
if(browsername.equalsIgnoreCase("CHROME"))
	driver = new ChromeDriver();
else if(browsername.equalsIgnoreCase("EDGE"))
	driver = new EdgeDriver();
else if(browsername.equalsIgnoreCase("FIREFOX"))
	driver = new FirefoxDriver(); 
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
driver.get(url);
WebElement usernameTF = driver.findElement(By.id("username"));
usernameTF.clear();
usernameTF.sendKeys(username);
WebElement passwordTF = driver.findElement(By.id("password"));
passwordTF.clear();
passwordTF.sendKeys(password);
WebElement signin= driver.findElement(By.xpath("//button[text()='Sign in']"));
signin.submit();
driver.manage().window().minimize();
driver.quit();
}
}
