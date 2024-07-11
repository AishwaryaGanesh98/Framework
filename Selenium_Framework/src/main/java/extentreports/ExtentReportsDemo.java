package extentreports;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportsDemo
{
WebDriver driver;
public static ExtentSparkReporter sparkreporter;
public static ExtentReports reports;
public static ExtentTest test;
@BeforeMethod
public void precondition()
{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
}
public void extentReportCode()
{
sparkreporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/extentreport.html");
sparkreporter.config().setDocumentTitle("ExecutionReport");
sparkreporter.config().setReportName("TestcaseExecutionReport");
sparkreporter.config().setTheme(Theme.STANDARD);
sparkreporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
reports = new ExtentReports();
reports.attachReporter(sparkreporter);
}
public static String screenshotCapture(WebDriver driver) throws IOException
{
	String fileSeparator = System.getProperty("file.separator");
	String extentReportPath = "."+fileSeparator+"Reports";
	String screenshotPath = extentReportPath+"screenshots";
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String screenshotName = "screenshot"+Math.random()+".png";
	String screenshotpath = screenshotPath+fileSeparator+screenshotName;
    	FileUtils.copyFile(src, new File(screenshotpath));
	return "."+fileSeparator+"screenshots"+fileSeparator+screenshotName;
}
@AfterMethod
public void postcondition() {
	driver.manage().window().minimize();
	driver.quit();
}
}









