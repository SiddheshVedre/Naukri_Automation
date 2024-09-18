package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

public class DataProviderClass {
	


	//Username, Password, Designation, Location, Applications, Experience
    @DataProvider(name = "AllData")
    public Object[][] AllData() throws IOException {

        // Path to the Excel file
        String filePath = ".\\TestData\\Naukri_Automation_Details.xlsx";
        String sheetName = "LoginData";
    	int RowNumber = 1;
    	int Cells = 6;
       

        // Create an instance of ExcelUtility to read the Excel file
        ExcelUtility excel = new ExcelUtility(filePath, sheetName);


        Object[][] data = excel.getCellData(RowNumber, Cells);

        // Close the Excel workbook
        excel.close();

        return data;
    }
    
    
    //Username & Password 
    @DataProvider(name = "LoginData")
    public Object[][] LoginData() throws IOException {

        // Path to the Excel file
        String filePath = ".\\TestData\\Naukri_Automation_Details.xlsx";
        String sheetName = "LoginData";
    	int RowNumber = 2;
    	int Cells = 2;
       

        // Create an instance of ExcelUtility to read the Excel file
        ExcelUtility excel = new ExcelUtility(filePath, sheetName);

   
        Object[][] data = excel.getCellData(RowNumber, Cells);

        // Close the Excel workbook
        excel.close();

        return data;
    }
    
    
    
    
    
    
}

