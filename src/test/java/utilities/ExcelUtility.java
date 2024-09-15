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
    public Object[][] ExcelReader() throws IOException {

        // File and workbook setup
        File excelFile = new File(".\\TestData\\Naukri_Automation_Details.xlsx");
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet("LoginData");
        

        // Fetch the number of cells (columns) in the 2nd row
        
        int numOfCell = sheet.getRow(1).getLastCellNum();	

        // Create a two-dimensional array to store the second row's data (1 row x numOfCell columns)
        Object[][] data = new Object[1][numOfCell];

        // Process only the second row (index 1 in zero-based index)
        for(int j = 0; j < numOfCell; j++ ) {
            DataFormatter df = new DataFormatter();
            // Store values from the 2nd row (index 1) in the array
            data[0][j] = df.formatCellValue(sheet.getRow(1).getCell(j));				
        }

        // Close the workbook and stream
        workbook.close();
        fis.close();

        // Return the data as Object[][]
        return data;
    }
}
