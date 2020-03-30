package com.tigerAir.mobileAutomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtil {
	
	

	String value = null; // variable for storing the cell value
	// Workbook wb = null;
	// FileInputStream fis;
	// FileOutputStream fos;

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String xlFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx";
	public String sheetName = "TestCasesData";
	public static DataFormatter formatter = new DataFormatter();
	// initialize Workbook null

	public String getCelldata(int vRow, int vColumn) {
		try {
			// reading data from a file in the form of bytes
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx");

			// constructs an XSSFWorkbook object, by buffering the whole stream into the
			// memory
			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet;
		sheet = workbook.getSheet("BookFlight");// getting the XSSFSheet object at given index
		Row row = sheet.getRow(vRow); // returns the logical row
		Cell cell = (Cell) row.getCell(vColumn); // getting the cell representing the given column
		value = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue(); // getting cell value
		System.out.println("Value : " + value);
		return value;
	}

	/*
	 * public void setCellData(String value) throws IOException {
	 * 
	 * String path = System.getProperty("user.dir") +
	 * "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx"; fis =
	 * new FileInputStream(path);
	 * 
	 * workbook = new XSSFWorkbook(fis);
	 * 
	 * Sheet sheet = workbook.getSheetAt(0);
	 * 
	 * int lastRow = sheet.getLastRowNum();
	 * 
	 * for (int i = 1; i <= lastRow; i++) {
	 * 
	 * Row row = sheet.getRow(i);
	 * 
	 * Cell cell = row.createCell(2);
	 * 
	 * cell.setCellValue(value);
	 * 
	 * }
	 * 
	 * fos = new FileOutputStream(path);
	 * 
	 * workbook.write(fos);
	 * 
	 * fos.close(); }
	 */
	// setCellData("PNR", "PNR_Number", 2,
	// elementUtils.doGetText(BookingOverviewPage.getPnrtext()));

	public boolean setCellData(String sheetName, String colName, String value) {
		try {
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			sheet = workbook.getSheet(sheetName);
			// System.out.println("sheet name is : " + workbook.getSheet(sheetName));
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}
			// System.out.println("*****************************sheet.getLastRowNum() is : "
			// + sheet.getLastRowNum());
			sheet.autoSizeColumn(col_Num);
			row = sheet.getRow(sheet.getLastRowNum() + 1);
			if (row == null)
				row = sheet.createRow(sheet.getLastRowNum() + 1);

			cell = row.getCell(col_Num);
			if (cell == null)
				cell = row.createCell(col_Num);

			cell.setCellValue(value);

			fos = new FileOutputStream(xlFilePath);
			workbook.write(fos);
			fos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	@DataProvider
	public Object[][] ReadVariant() throws IOException {
		fis = new FileInputStream(xlFilePath); // Excel sheet file location get mentioned here
		workbook = new XSSFWorkbook(fis); // get my workbook
		sheet = workbook.getSheet(sheetName);// get my sheet from workbook
		row = sheet.getRow(0); // get my Row which start from 0

		int RowNum = sheet.getPhysicalNumberOfRows();// count my number of Rows
		int ColNum = row.getLastCellNum(); // get last ColNum

		Object Data[][] = new Object[RowNum - 1][ColNum]; // pass my count data in array

		for (int i = 0; i < RowNum - 1; i++) // Loop work for Rows
		{
			row = sheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) // Loop work for colNum
			{
				if (row == null)
					Data[i][j] = "";
				else {
					cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = ""; // if it get Null value it pass no data
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value; // This formatter get my all values as string i.e integer, float all type
											// data value
					}
				}
			}
		}

		return Data;
	}
}
