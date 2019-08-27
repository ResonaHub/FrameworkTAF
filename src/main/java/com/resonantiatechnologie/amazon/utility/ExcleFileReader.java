package com.resonantiatechnologie.amazon.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcleFileReader {
	private static XSSFWorkbook workBook;
	private static XSSFSheet sheet;
	private static Row row;
	private static Cell cell;

	/* Reads username and pasword from file */
	public static Object[][] excleFileReader(String filepath, String sheetname) throws IOException {
		workBook = new XSSFWorkbook(filepath);
		sheet = workBook.getSheet(sheetname);
		int lastRowNum = sheet.getLastRowNum();
		Object[][] excleData = new Object[sheet.getLastRowNum()][sheet.getRow(1).getLastCellNum()];
		for (int i = 1; i < lastRowNum + 1; i++) {
			row = sheet.getRow(i);
			int lastCellNum = row.getLastCellNum();
			for (int j = 0; j < lastCellNum; j++) {
				cell = row.getCell(j);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_NUMERIC:
					excleData[i - 1][j] = String.valueOf(cell.getNumericCellValue());
					break;
				case Cell.CELL_TYPE_STRING:
					excleData[i - 1][j] = cell.getStringCellValue();
					break;
				default:
					System.out.println("Invalid data in Cell");
					break;
				}
			}
		}
		return excleData;
	} // end of method

	public static void setExcelFile(String filepath, String sheetname) throws Exception {
		workBook = new XSSFWorkbook(filepath);
		sheet = workBook.getSheet(sheetname);
	}

	public static String getCellData(int rownum, int colnum) throws Exception {
		cell = sheet.getRow(rownum).getCell(colnum);
		String cellData = cell.getStringCellValue();
		return cellData;
	}

} // end of class