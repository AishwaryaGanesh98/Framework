package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Implementation {
 public static WebDriver driver;
	public static void main(String[] args) throws IOException, InterruptedException {
		FileInputStream fis = new FileInputStream("./src/test/resource/vtigerdata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String browserName = pobj.getProperty("browser");
		if(browserName.equals("chrome"))
			driver = new ChromeDriver();
		else if(browserName.equals("edge"))
			driver = new EdgeDriver();
		else if(browserName.equals("firefox"))
			driver = new FirefoxDriver();
       Thread.sleep(2000);  //thread.sleep should not be used but we are using to see the flow and understand
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
       driver.get(pobj.getProperty("url"));
       Thread.sleep(2000);
       WebElement username=driver.findElement(By.id("username"));
       username.clear();
       Thread.sleep(2000);
       username.sendKeys(pobj.getProperty("username"));
       Thread.sleep(2000);
       WebElement password=driver.findElement(By.id("password"));
       password.clear();
       Thread.sleep(2000);
       password.sendKeys(pobj.getProperty("password"));
       Thread.sleep(2000);
       driver.findElement(By.xpath("//button[text()='Sign in']")).submit();
       Thread.sleep(2000);
       driver.manage().window().minimize();
       driver.quit();	
	}

}
