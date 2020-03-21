package com.tigerAir.mobileAutomation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	String value = null; // variable for storing the cell value
	Workbook wb = null;
	FileInputStream fis;
	// initialize Workbook null

	public String getCelldata(int vRow, int vColumn) {
		try {
			// reading data from a file in the form of bytes
			fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx");

			// constructs an XSSFWorkbook object, by buffering the whole stream into the
			// memory
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet;
		sheet = wb.getSheet("BookFlight");// getting the XSSFSheet object at given index
		Row row = sheet.getRow(vRow); // returns the logical row
		Cell cell = (Cell) row.getCell(vColumn); // getting the cell representing the given column
		value = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue(); // getting cell value
		System.out.println("Value : " + value);
		return value;
	}

}
