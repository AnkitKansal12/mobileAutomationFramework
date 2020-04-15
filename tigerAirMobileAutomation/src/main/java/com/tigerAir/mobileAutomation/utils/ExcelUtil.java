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

	String value = null;
	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String xlFilePath = System.getProperty("user.dir")
			+ "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx";
	public String sheetName = "TestCas";
	public static DataFormatter formatter = new DataFormatter();

	public String getCelldata(int vRow, int vColumn) {
		try {

			fis = new FileInputStream(System.getProperty("user.dir")
					+ "/src/main/java/com/tigerAir/mobileAutomation/testData/testData.xlsx");

			workbook = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		Sheet sheet;
		sheet = workbook.getSheet("BookFlight");
		Row row = sheet.getRow(vRow);
		Cell cell = (Cell) row.getCell(vColumn);
		value = ((org.apache.poi.ss.usermodel.Cell) cell).getStringCellValue();
		System.out.println("Value : " + value);
		return value;
	}

	public boolean setCellData(String sheetName, String colName, String value) {
		try {
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			int col_Num = 0;
			sheet = workbook.getSheet(sheetName);

			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}
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
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetName);
		row = sheet.getRow(0);

		int RowNum = sheet.getPhysicalNumberOfRows();
		int ColNum = row.getLastCellNum();

		Object Data[][] = new Object[RowNum - 1][ColNum];

		for (int i = 0; i < RowNum - 1; i++) {
			row = sheet.getRow(i + 1);

			for (int j = 0; j < ColNum; j++) {
				if (row == null)
					Data[i][j] = "";
				else {
					cell = row.getCell(j);
					if (cell == null)
						Data[i][j] = "";
					else {
						String value = formatter.formatCellValue(cell);
						Data[i][j] = value;
					}
				}
			}
		}

		return Data;
	}
}
