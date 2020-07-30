package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class ExcelHandler {
	XSSFWorkbook wb = null;

	public ExcelHandler(String path) {
		
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(fis);
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		if (wb != null) {
			System.out.println("Connection Success");
		}

	}

	public String readXLData(String sheetname, int rowindex, String ColName) {
		int xlColumnCount = getXLColumnCount(sheetname);
		int colindex = 0;
		String celltext = null;
		for (int i = 0; i < xlColumnCount; i++) {
			if (wb.getSheet(sheetname).getRow(0).getCell(i).getStringCellValue().equals(ColName)) {
				colindex = i;
				celltext = readXLData(sheetname, rowindex, colindex);
				break;
			}
		}

		return celltext;

	}

	@SuppressWarnings("deprecation")
	public String readXLData(String sheetname, int rowindex, int colindex) {
		// Read a cell from wb
		// sheetname, rowindex, colindex
		XSSFCell cell = wb.getSheet(sheetname).getRow(rowindex).getCell(colindex);

		String celltext = null;

		if (cell == null) {
			celltext = "";
		} else if (cell.getCellType()== CellType.STRING) {
			celltext = cell.getStringCellValue();

		} else if (cell.getCellType() == CellType.NUMERIC) {
			System.out.println("No");
			double numericCellValue = cell.getNumericCellValue();
			celltext = String.valueOf(numericCellValue);
		} else if (cell.getCellType() == CellType.BOOLEAN) {
			System.out.println("Bool");
			boolean booleanCellValue = cell.getBooleanCellValue();
			celltext = String.valueOf(booleanCellValue);
		} else {
			celltext = "";
		}

		return celltext;
	}


	public void writeXLData(String sheetname, int rowindex, int colindex, String value) throws Exception {
		// write the values to excel
		
		XSSFRow row = wb.getSheet(sheetname).getRow(rowindex);
		if (row == null) {
			row = wb.getSheet(sheetname).createRow(rowindex);
		}
		XSSFCell cell2 = row.getCell(colindex);
		if (cell2 == null) {
			cell2 = row.createCell(colindex);
		}
		cell2.setCellValue(value);

	}

	public int getXLRowCount(String sheetname) {
		// Get the number of rows
		int lastRowNum = wb.getSheet(sheetname).getLastRowNum();

		return lastRowNum;
		
	}

	public int getXLColumnCount(String sheetname) {
		// Get the number of column
		int lastCellNum = wb.getSheet(sheetname).getRow(0).getLastCellNum();

		return lastCellNum;
	}

	public void saveXLFile(String path) {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			wb.write(fout);
			fout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
