package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This class consists of all generic methods related to file operations
 * @author Aditya M
 * @return 
 * 
 */
public class FileUtility {
	/**
	 * 
	 * @param Key
	 * @return
	 * @throws Exception
	 */
	
	public String readDataFromPropertyFile(String Key) throws Exception 
	{
		FileInputStream fis=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\Selenium Programs\\E21.AutomationFramework\\src\\test\\resources\\CommonData.properties");
		Properties p=new Properties();
		p.load(fis);
		String value=p.getProperty(Key);
		return value;
		
	}
	public String readDataFromExcelFile(String sheetname, int rowNo, int celNo) throws Exception
	{
		FileInputStream fise=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\Selenium Programs\\E21.AutomationFramework\\src\\test\\resources\\E21 AutomationFramework.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		String value = wb.getSheet(sheetname).getRow(rowNo).getCell(celNo).getStringCellValue();
		return value;
	}
	public double readNumericDataFromExcel(String sheetname, int rowNo, int celNo) throws Exception
	{
		FileInputStream fise=new FileInputStream("C:\\Users\\DELL\\OneDrive\\Desktop\\New folder\\Selenium Programs\\E21.AutomationFramework\\src\\test\\resources\\E21 AutomationFramework.xlsx");
		Workbook wb = WorkbookFactory.create(fise);
		double value = wb.getSheet(sheetname).getRow(rowNo).getCell(celNo).getNumericCellValue();
		return value;
	}
}

