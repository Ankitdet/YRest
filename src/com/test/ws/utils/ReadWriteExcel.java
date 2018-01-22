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

import com.fasterxml.uuid.Logger;

public class ReadWriteExcel {

	// 500 at time
	public static List<Object[]> getExcelSheetData(String string) {
		
		Logger.logInfo("method called getExcelSheetData() of :"+ReadWriteExcel.class.getName());
		List<Object[]> arrayList = new ArrayList<Object[]>(500);
		
		try {
			FileInputStream file = new FileInputStream(new File(string));
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			// Get the Desired sheet
			XSSFSheet sheet = workbook.getSheetAt(0);
			int i = sheet.getPhysicalNumberOfRows();
			// Increment over rows
			for (Row row : sheet) {
				Object[] obj = new Object[25];
				// get ROW
				// Iterate and get the cells from the row
				Iterator cellIterator = row.cellIterator();
				// Loop till you read all the data
				int z = 0;
				while (cellIterator.hasNext()) {
					if(z == 25) break;
					Cell cell = (Cell) cellIterator.next();
					Object object = getCellValueAsString(cell);
					
					if(object == null)
						obj[z++] = "";
					else
						obj[z++] = object;
				}
				arrayList.add(obj);
			}
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return arrayList;
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
			/*
			 * case Cell.CELL_TYPE_BLANK: strCellValue = ""; break;
			 */
			}
		}
		return strCellValue;
	}
}
