package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelSheetHandling {
	
	public static String filePath = "src/test/resources/TestData.xlsx";

		public static Map<String, String> readExcelRow(String scenarioName,String sheetName) {
	       
	        Map<String, String> testData = new HashMap<>();

	        try (FileInputStream fis = new FileInputStream(filePath);
	        		Workbook workbook = new XSSFWorkbook(fis)) {
	            Sheet sheet = workbook.getSheet(sheetName);
	            Row header = sheet.getRow(0); // row 1 has the headers (0-based index)

	            for (int i = 1; i <= sheet.getLastRowNum(); i++) {
	                Row row = sheet.getRow(i);
	                if (row.getCell(0).getStringCellValue().equalsIgnoreCase(scenarioName)) {
	                    for (int j = 1; j < row.getLastCellNum(); j++) {
	                        String key = header.getCell(j).getStringCellValue();
	                        String value = row.getCell(j).getStringCellValue();
	                        testData.put(key, value);
	                    }
	                
	            }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return testData;
	    }
	}


