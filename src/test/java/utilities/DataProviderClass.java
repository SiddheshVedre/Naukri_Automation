package utilities;

import org.testng.annotations.DataProvider;
import java.io.IOException;

//  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  Collect Data from Provided Source & Passed to needed Classes  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<
public class DataProviderClass {
	
    //  ----------------------------  DataProvider : AllData  -------------------------------------------------------------------
	// >>>>>>>>>>>>>>>>>>>>>>>>> Excel File DATA : Naukri_Automation_Details.xlsx  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    @DataProvider(name = "AllData") //--------  Username, Password, Designation, Location, Applications, Experience  -----------
    public Object[][] AllData() throws IOException {

        // >>>>>>>>>>>>>>>>>>>>>>>  Path to the Excel file  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        String filePath = ".\\TestData\\Naukri_Automation_Details.xlsx";
        String sheetName = "LoginData";
        
        //  >>>>>>>>>>>>>>>>>>>>>>  Define Rows & Cells  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    	int RowNumber = 1;
    	int Cells = 6;
    	
    	// >>>>>>>>>>>>>>>>>>>>>>>  Create an instance of ExcelUtility to read the Excel file : ExcelUtility.java  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<       
        ExcelUtility excel = new ExcelUtility(filePath, sheetName);


        //  >>>>>>>>>>>>>>>>>>>>>>  Specific Selected DATA From Excel File  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        Object[][] data = excel.getCellData(RowNumber, Cells);

        // >>>>>>>>>>>>>>>  Close the Excel workbook  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        excel.close();

       // >>>>>>>>>>>>>>>  Return Specific Cell Data  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return data;
    }
    
    
    
    //  ----------------------------  DataProvider : LoginData  --------------------------------------------------------
    //  >>>>>>>>>>>>>>>>>>>>>>>>>>>>  Excel File DATA : Naukri_Automation_Details.xlsx  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< 
    @DataProvider(name = "LoginData") //  --------------  Username, Password  ---------------
    public Object[][] LoginData() throws IOException {

    	// >>>>>>>>>>>>>>>>>>>>>>>  Path to the Excel file  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        String filePath = ".\\TestData\\Naukri_Automation_Details.xlsx";
        String sheetName = "LoginData";
        
        //  >>>>>>>>>>>>>>>>>>>>>>  Define Rows & Cells  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    	int RowNumber = 2;
    	int Cells = 2;
       

    	// >>>>>>>>>>>>>>>>>>>>>>>  Create an instance of ExcelUtility to read the Excel file : ExcelUtility.java  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        ExcelUtility excel = new ExcelUtility(filePath, sheetName);

        //  >>>>>>>>>>>>>>>>>>>>>>  Specific Selected DATA From Excel File  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        Object[][] data = excel.getCellData(RowNumber, Cells);

        // >>>>>>>>>>>>>>>  Close the Excel workbook  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        excel.close();

        // >>>>>>>>>>>>>>>  Return Specific Cell Data  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
        return data;
    }
    
    
    
    
    
    
}

