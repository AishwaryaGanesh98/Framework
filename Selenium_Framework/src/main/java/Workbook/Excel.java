package Workbook;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resource/excel.xlsx");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet("Sheet1");
		 for(int r=0; r<=sheet.getLastRowNum();r++)
		 {
			 Row row = sheet.getRow(r);
			 for(int c=0; c<row.getLastCellNum();c++)	
			 {
				 Cell cell = row.getCell(c);
				 switch(cell.getCellType())
				 {
				 case STRING:
				 {
					 System.out.println("String data: "+cell.getStringCellValue());	
					 break;
				 }
				 case NUMERIC:
				 {
					 System.out.println("Numeric data: "+(long)cell.getNumericCellValue());
					 break;
				 }
				 case BOOLEAN:
				 {
					 System.out.println("Boolean data: "+cell.getBooleanCellValue()); 
					 break; 
				 }
				default:
					System.out.println("Invalid data");
				 }
			 }
				 
		 }				
	}
}
