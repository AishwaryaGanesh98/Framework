package Workbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplementationFacebook {
	 public static WebDriver driver;
		public static void main(String[] args) throws IOException, InterruptedException {
			XSSFWorkbook workbookWrite = new XSSFWorkbookFactory().create();
			XSSFSheet sheet = workbookWrite.createSheet("createsheet");
			FileOutputStream fos = new FileOutputStream("./src/test/resource/facebookexcel.xlsx");
			for(int r=0; r<1; r++)
			 {
				XSSFRow row = sheet.createRow(r); 
				 for(int c=0; c<4; c++)	
				 {
					 XSSFCell cell = row.createCell(c);
					if(r==0 && c==0)
						cell.setCellValue("chrome");
				    else if(r==0&&c==1)
						cell.setCellValue("https://www.facebook.com/");
					else if(r==0&&c==2)
						cell.setCellValue("aishwaryaganesh98@gmail.com");
					else if(r==0&&c==3)
						cell.setCellValue("123456");
				 }
			
			 }
			workbookWrite.write(fos);
			workbookWrite.close();
			FileInputStream fis = new FileInputStream("./src/test/resource/facebookexcel.xlsx");
			Workbook workbook  = WorkbookFactory.create(fis);
			 Sheet sheet1 = workbook.getSheet("createsheet");
			 Row row1 = sheet1.getRow(0);
			 Cell cell1 = row1.getCell(0);
			 String cellValue = cell1.getStringCellValue();
			 if(cellValue.equals("chrome"))
					driver = new ChromeDriver();
				else if(cellValue.equals("edge"))
					driver = new EdgeDriver();
				else if(cellValue.equals("firefox"))
					driver = new FirefoxDriver();
			   driver.manage().window().maximize();
		       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				 Cell cell2 = row1.getCell(1);
				 String urlValue = cell2.getStringCellValue();
				 driver.get(urlValue);
				 WebElement emailTextField=driver.findElement(By.id("email"));
				 Cell cell3 = row1.getCell(2);
				 String emailValue = cell3.getStringCellValue();
				 emailTextField.sendKeys(emailValue);
				 WebElement passTextField=driver.findElement(By.id("pass"));
				 Cell cell4 = row1.getCell(3);
				 String passValue = cell4.getStringCellValue();
				 passTextField.sendKeys(passValue);				 
}
}
