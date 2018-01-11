package com.test.ws.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteExcel {
	
	// 200 at time 
	public static List<Object[]> arrayList = new ArrayList<Object[]>(500);

	
	public static void main(String[] args) {
		try {
			
			
			FileInputStream file = new FileInputStream(new File("/home/elitecore/Downloads/yuvak_list.xlsx"));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get the Desired sheet
			XSSFSheet sheet = workbook.getSheetAt(0);

			// Increment over rows
			for (int j= 2 ;j<=500;j++) {
				Object[]  obj = new Object[15];
				// get ROW
				Row row = sheet.getRow(j);
				// Iterate and get the cells from the row
				Iterator cellIterator = row.cellIterator();
				// Loop till you read all the data
				for (int z = 0; z <= 20; z++) {
						Cell cell = (Cell) cellIterator.next();
						Object newObject = getCellValueAsString(cell);
						if (newObject != null) obj[z] = newObject;
				}
				arrayList.add(obj);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("deprecation")
	public static String getCellValueAsString(Cell cell) {

		String strCellValue = null;
		if (cell != null) {
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				strCellValue = cell.toString();
				break;
			case Cell.CELL_TYPE_NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					strCellValue = dateFormat.format(cell.getDateCellValue());
				} else {
					Double value = cell.getNumericCellValue();
					String longValue = String.valueOf(new BigDecimal(value).toBigInteger());
					strCellValue = new String(longValue.toString());
				}
				break;
			case Cell.CELL_TYPE_BOOLEAN:
				strCellValue = new String(new Boolean(cell.getBooleanCellValue()).toString());
				break;
			/*case Cell.CELL_TYPE_BLANK:
				strCellValue = "";
				break;*/
			}
		}
		return strCellValue;
	}
}
