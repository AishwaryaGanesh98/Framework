package datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromWorkbook {
		public static void main(String[] args) throws IOException {
			FileInputStream fis = new FileInputStream("./src/test/resource/testcasespecificdata.xlsx");
			Workbook workbook  = WorkbookFactory.create(fis);
			 Sheet sheet = workbook.getSheet("details");
			 Row row = sheet.getRow(3);
			 Cell cell = row.getCell(1);
			 long cellValue = (long) cell.getNumericCellValue();
			 System.out.println("Cell Value = "+cellValue);
			
		}
   
	}


