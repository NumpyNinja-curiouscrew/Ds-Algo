package utils;

	
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

	public class ExcelUtils {
		public static String filePath = "src/test/resources/TestData.xlsx";

	    public static List<String> getAllSheetNames(String filePath) throws IOException {
	        List<String> sheetNames = new ArrayList<>();
	        try (FileInputStream fis = new FileInputStream(filePath);
	             Workbook workbook = new XSSFWorkbook(fis)) {
	            int sheetsCount = workbook.getNumberOfSheets();
	            for (int i = 0; i < sheetsCount; i++) {
	                sheetNames.add(workbook.getSheetName(i));
	            }
	        }
	        return sheetNames;
	    }

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
	

	public static String readSheetName(String name) {
        try {
            List<String> sheets = getAllSheetNames(filePath);
            for (String sheetName : sheets) {
                // Example logic: return the sheet which contains "Test"
                if (sheetName.contains(name)) {
                    return sheetName;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return null;
	}
	}


