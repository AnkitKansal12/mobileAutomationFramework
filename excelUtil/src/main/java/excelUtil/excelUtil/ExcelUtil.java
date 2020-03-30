package excelUtil.excelUtil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public static void main(String[] args) {
		ExcelUtil excelt = new ExcelUtil();
		excelt.setCellData("PNR", "PNR_Number", Math.random());
		
	}

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
	String xlFilePath = System.getProperty("user.dir") + "/src/main/java/excelUtil/excelUtil/testData.xlsx";

	// setCellData("PNR", "PNR_Number", 2,
	// elementUtils.doGetText(BookingOverviewPage.getPnrtext()));

	public boolean setCellData(String sheetName, String colName, double value) {
		try {
			fis = new FileInputStream(xlFilePath);
			workbook = new XSSFWorkbook(fis);
			int col_Num = 0 ;
			sheet = workbook.getSheet(sheetName);
			System.out.println("sheet name is : "+workbook.getSheet(sheetName));
			row = sheet.getRow(0);
			for (int i = 0; i < row.getLastCellNum(); i++) {
				if (row.getCell(i).getStringCellValue().trim().equals(colName)) {
					col_Num = i;
				}
			}
			System.out.println("*****************************sheet.getLastRowNum() is : " + sheet.getLastRowNum());
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

}
