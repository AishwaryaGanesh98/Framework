package Workbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

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

public class WriteToExcel {

	public static void main(String[] args) throws IOException {
		XSSFWorkbook workbookWrite = new XSSFWorkbookFactory().create();
		XSSFSheet sheet = workbookWrite.createSheet("createsheet");
		XSSFRow row = sheet.createRow(0);
		XSSFCell cell = row.createCell(0);
		cell.setCellValue("qsp");
		FileOutputStream fos = new FileOutputStream("./src/test/resource/enterthedata.xlsx");
		workbookWrite.write(fos);
		workbookWrite.close();
		FileInputStream fis = new FileInputStream("./src/test/resource/enterthedata.xlsx");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet1 = workbook.getSheet("createsheet");
		 Row row1 = sheet1.getRow(0);
		 Cell cell1 = row1.getCell(0);
		 String cellValue = cell1.getStringCellValue();
		 System.out.println("Cell Value = "+cellValue);
	}

}
