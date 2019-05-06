package com.stadiumgood.AutomationChallenge;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	

	static String excelFile = "/AutomationChallenge/excelFile/Book1.xlsx"; 
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	FileInputStream inputStream;
	
	
	public ExcelUtils () {
		File srcFile = new File(excelFile);
		try {
			inputStream = new FileInputStream(srcFile);
			workbook = new XSSFWorkbook(inputStream);
		}catch(Exception e ) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
	public static int getColCount() {
		int colCount = 0;
		try {
			colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			//will get actual amount of rows
			System.out.println("Number Of Columns: " + colCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return colCount;
	}
	
	public static int getRowCount() {
		int rowCount = 0;
		try {
			rowCount = sheet.getPhysicalNumberOfRows();
			//will get actual amount of rows
			System.out.println("Number Of Rows: " + rowCount);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return rowCount;
	}
	
	public static String getCellDataString( int rowNum , int colNum) {
		String cellData = null;
		try {
			cellData = sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//System.out.println("CELL DATA: " + cellData);
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
		return cellData;
	}
	
public static void getCellDataNumber(int rowNum, int colNum) {
		
		try {
			workbook = new XSSFWorkbook(excelFile);
			sheet = workbook.getSheet("Sheet1");
			double cellData = sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
			System.out.println("CELL DATA: " + cellData);
		}  catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		}
	}
}

