package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    // >>>>>>>>>>>>>>>>>>>>>  Constructor to load the Excel file and select a specific sheet  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public ExcelUtility(String filePath, String sheetName) throws IOException {
    	
        FileInputStream fis = new FileInputStream(new File(filePath));
        workbook = new XSSFWorkbook(fis);
        sheet = workbook.getSheet(sheetName);
    }

    
    
    // >>>>>>>>>>>>>>>>>>>>>>>>>>  Get Data from a specific row  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public Object[][] getRowData(int rowIndex) {
    	
        int numOfCells = sheet.getRow(rowIndex).getLastCellNum();
        Object[][] rowData = new Object[1][numOfCells];

        DataFormatter df = new DataFormatter();  // Helps to format the data properly
        for (int j = 0; j < numOfCells; j++) {
            rowData[0][j] = df.formatCellValue(sheet.getRow(rowIndex).getCell(j));
        }

        return rowData;
    }
    
    
    
    //  >>>>>>>>>>>>>>>>>>>>>>>>>>  Get Data From Cells  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public Object[][] getCellData(int rowIndex, int numOfCells) {
    	
        // Get the row from the sheet based on rowIndex
        XSSFRow row = sheet.getRow(rowIndex);

        // Create an array to hold the data from the specified number of cells
        Object[][] cellData = new Object[1][numOfCells];  // 1 row x numOfCells columns

        DataFormatter formatter = new DataFormatter();  // Formatter to get cell values as String

        // Loop through the specified number of cells
        for (int cellIndex = 0; cellIndex < numOfCells; cellIndex++) {
            // Get the cell value, format it, and store it in the array
            cellData[0][cellIndex] = formatter.formatCellValue(row.getCell(cellIndex));
        }

        return cellData;  // Return the fetched data
    }

    
    
    


    
    
    //  >>>>>>>>>>>>>>>>>>  Method to close the workbook  <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
    public void close() throws IOException {
        if (workbook != null) {
            workbook.close();
        }
    }
}
