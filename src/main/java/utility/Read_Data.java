package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read_Data 
{
	public static String Readpropertyfile(String Value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Users\\Sudhir\\eclipse-workspace\\selenium_framework\\src\\main\\java\\config\\config.Properteis");
		prop.load(file);
		return prop.getProperty(Value);
	}
	public static String Readexcel(int rownum , int colnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\Sudhir\\eclipse-workspace\\selenium_framework\\Test_Data\\Excel_Data_Fetch.xlsx");
		Sheet es = WorkbookFactory.create(file).getSheet("Sheet1");
		String value = es.getRow(rownum).getCell(colnum).getStringCellValue();
		return value;
	}

}
