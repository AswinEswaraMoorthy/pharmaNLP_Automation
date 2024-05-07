package com.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.event.CellEditorListener;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTRow;

public class ExcelReader {

	public Object[][] getTestData() throws IOException {
		String userdir = System.getProperty("user.dir");
		XSSFWorkbook workbook = new XSSFWorkbook(userdir +"\\src\\test\\resources\\testdatas\\PNLP.xlsx");
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Object[][] data = new Object[rowCount][colCount];
		for (int i = 1; i <= rowCount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < colCount; j++) {
				Cell cell = row.getCell(j);
				data[i-1][j] = (Object)cell.getStringCellValue();
			}
		}
		workbook.close();
		return data;
	}

	
	
	/*
	 * public static FileInputStream fileInputStream; public static FileOutputStream
	 * fileOutputStream; public static XSSFWorkbook workbook; public static
	 * XSSFSheet sheet; public static XSSFRow row; public static XSSFCell cell;
	 * public static CellStyle style;
	 * 
	 * public static int getRowCount(String xlfile, String xlsheet) throws
	 * IOException { fileInputStream = new FileInputStream(xlfile); workbook = new
	 * XSSFWorkbook(fileInputStream); sheet = workbook.getSheet(xlsheet); int
	 * rowCount = sheet.getLastRowNum(); workbook.close(); fileInputStream.close();
	 * return rowCount; }
	 * 
	 * public static int getCellCount(String xlfile, String xlsheet, int rownum)
	 * throws IOException { fileInputStream = new FileInputStream(xlfile); workbook
	 * = new XSSFWorkbook(fileInputStream); sheet = workbook.getSheet(xlsheet); row
	 * = sheet.getRow(rownum); int cellCount = row.getLastCellNum();
	 * workbook.close(); fileInputStream.close(); return cellCount; }
	 * 
	 * public static String getCellData(String xlfile, String xlsheet, int rownum,
	 * int colnum) throws IOException { fileInputStream = new
	 * FileInputStream(xlfile); workbook = new XSSFWorkbook(fileInputStream); sheet
	 * = workbook.getSheet(xlsheet); row = sheet.getRow(rownum); cell =
	 * row.getCell(colnum); String data; try {
	 * 
	 * data = cell.toString(); return data; } catch (Exception e) { data = ""; }
	 * workbook.close(); fileInputStream.close(); return data; }
	 * 
	 * public static String SetCellData(String xlfile, String xlsheet, int rownum,
	 * int colnum, String data) throws IOException { fileInputStream = new
	 * FileInputStream(xlfile); workbook = new XSSFWorkbook(fileInputStream); sheet
	 * = workbook.getSheet(xlsheet); row = sheet.getRow(rownum); cell =
	 * row.createCell(colnum); cell.setCellValue(data); fileOutputStream = new
	 * FileOutputStream(xlfile); workbook.write(fileOutputStream); workbook.close();
	 * fileInputStream.close(); return data; }
	 */

	// method 1
	/*
	 * public static String[][] readExcel() throws IOException {
	 * 
	 * // Excel File path XSSFWorkbook workbook = new XSSFWorkbook(
	 * "C:\\Users\\aswin.moorthy\\Automation\\pharma_NLP\\src\\test\\resources\\testdatas\\TestData.xlsx"
	 * );
	 * 
	 * // getting sheet name XSSFSheet sheet = workbook.getSheet("Sheet1");
	 * 
	 * // to get row count int rowcount = sheet.getLastRowNum();
	 * System.out.println(rowcount); // to get col count int colcount =
	 * sheet.getRow(0).getLastCellNum(); System.out.println(colcount);
	 * 
	 * String[][] data = new String[rowcount][colcount]; for (int i = 1; i <=
	 * rowcount; i++) {
	 * 
	 * XSSFRow row = sheet.getRow(i);
	 * 
	 * for (int j = 0; i < colcount; j++) { String Cuvalue =
	 * row.getCell(j).getStringCellValue(); data[i - 1][j] = Cuvalue;
	 * System.out.println("@@@@@@@@@@@@@@@@" + Cuvalue);
	 * 
	 * }
	 * 
	 * }
	 * 
	 * workbook.close(); return data; }
	 */

}
