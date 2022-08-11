package com.trello.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileUtility {
	public String getPropetyValue(String key) throws IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/pf.properties");
		Properties pobj=new Properties();
		pobj.load(fis);
		return pobj.getProperty(key);
	}
	
	public String getWorkbookStringValue(String sheetName,int rowNumber,int colomnNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/actiTIME.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		String cellValue = workbook.getSheet(sheetName).getRow(rowNumber).getCell(colomnNumber).getStringCellValue();
		return cellValue;
	}
	
	public double getWorkbookNumericValue(String sheetName,int rowNumber,int colomnNumber) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src/main/resources/actiTIME.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		double cellValue = workbook.getSheet(sheetName).getRow(rowNumber).getCell(colomnNumber).getNumericCellValue();
		return cellValue;
	}
}
