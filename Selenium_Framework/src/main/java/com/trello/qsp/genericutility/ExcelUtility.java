package com.trello.qsp.genericutility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String readTheStringDataFromWorkbook(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("");
			Workbook workbook  = WorkbookFactory.create(fis);
			 Sheet sheet = workbook.getSheet(sheetName);
			 Row row = sheet.getRow(rowNum);
			 Cell cell = row.getCell(cellNum);
			 String value = cell.getStringCellValue();
			 return value;

	}
	public long readTheNumericLongDataFromWorkbook(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		 long value = (long) cell.getNumericCellValue();
		 return value;

}
	public double readTheNumericDoubleDataFromWorkbook(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		 double value = (double) cell.getNumericCellValue();
		 return value;

}
	public int readTheNumericIntDataFromWorkbook(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("");
		Workbook workbook  = WorkbookFactory.create(fis);
		 Sheet sheet = workbook.getSheet(sheetName);
		 Row row = sheet.getRow(rowNum);
		 Cell cell = row.getCell(cellNum);
		 int value = (int) cell.getNumericCellValue();
		 return value;

}
}
