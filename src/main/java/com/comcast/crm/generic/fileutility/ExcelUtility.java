package com.comcast.crm.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName, int rowNum, int cellNum) throws EncryptedDocumentException, IOException {
		
		FileInputStream fis=new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();//Or we can use getStringCellValue(); method
		
		wb.close();
		return data;
		
	}
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowNumber=wb.getSheet(sheet).getLastRowNum();
		
		wb.close();
		return rowNumber;
		
	}
	
	public int getCellCount(String sheet, int rowNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int cellNumber=wb.getSheet(sheet).getRow(rowNum).getLastCellNum();
		
		wb.close();
		return cellNumber;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum, int cellNum, String data) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
//		wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).setCellValue(data);
		
		FileOutputStream fos=new FileOutputStream("./testdata/testScriptData.xlsx");
		wb.write(fos);
		wb.close();// always close
		
	}
	
}
