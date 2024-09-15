package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExcelUtility {
	
	

	@DataProvider(name = "ExcelData")
	public  String[][] ExcelReader() throws IOException {
		
		File excelFile = new File(".\\TestData\\Naukri_Automation_Details.xlsx");
		FileInputStream fis = new FileInputStream(excelFile);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("LoginData");
		
		
		int numOfRows  = sheet.getPhysicalNumberOfRows();
		int numOfCell = sheet.getRow(0).getLastCellNum();	
		
		String [][] data = new String [numOfRows][numOfCell];
		for (int i = 0; i < numOfRows -1; i++ ) {
			for(int j = 0; j < numOfCell; j++ ) {
				
				DataFormatter df = new DataFormatter();
		
				data[i][j] = df.formatCellValue(sheet.getRow(i+ 1).getCell(j));				
			}
			
			
		}
		
		
		workbook.close();
		fis.close();
		
		
		return data;
		
	}
	

	
}
