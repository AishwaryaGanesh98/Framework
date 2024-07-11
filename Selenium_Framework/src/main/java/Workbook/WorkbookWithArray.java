package Workbook;

import java.io.File;
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

public class WorkbookWithArray {
	public static void main(String[] args) throws IOException {
		
		
		XSSFWorkbook workbookWrite=new XSSFWorkbookFactory().create();
		XSSFSheet sheet = workbookWrite.createSheet("createsheet");
		
		String[][] obj = new String[3][4];
		 
		 
		 obj[0][0]="Aish";
		 obj[0][1]="G";
		 obj[0][2]= "9632376649";
		 obj[0][3]="abc";
		 
		 obj[1][0]="Nish";
		 obj[1][1]="D";
		 obj[1][2]="9035902906";
		 obj[1][3]="def";
		 
		 obj[2][0]="Vish";
		 obj[2][1]="R";
		 obj[2][2]="9632376640";
		 obj[2][3]="ghi";
	
		for(int r=0;r<3;r++)
		{
			XSSFRow row = sheet.createRow(r);
			for(int c=0;c<4;c++) {
				XSSFCell cell = row.createCell(c);	
				cell.setCellValue((obj[r][c]));
			}
		}
		
		FileOutputStream fos = new FileOutputStream("./src/test/resource/array.xlsx");
		workbookWrite.write(fos);
		
		workbookWrite.close();
		
		//read data
		FileInputStream fis = new FileInputStream("./src/test/resource/array.xlsx");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet1 = workbook.getSheet("createsheet");
		 for(int r=0; r<=sheet1.getLastRowNum();r++)
		 {
			 Row row = sheet1.getRow(r);
			 for(int c=0; c<row.getLastCellNum();c++)	
			 {
				 Cell cell = row.getCell(c);
				 String cellValue = cell.getStringCellValue();
				 System.out.println(cellValue);
				 }
			 }
				 
		
		
		 }
		
	}

