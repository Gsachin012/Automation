package exelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFShape;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	//Apache Poi - HSSFWorkbook - xls files
	//XSSFWorkbook - xlsx files

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		File file = new File("C:\\Selenium - Dec batch\\Book1.xlsx");
		FileInputStream fis = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(0);
		
		System.out.println(cell.getStringCellValue());
	
		System.out.println(row.getCell(1));
		System.out.println(row.getCell(2));
		System.out.println(row.getCell(3));
		
		System.out.println(sheet.getLastRowNum());  //this will consider all rows i.e even empty rows, index starts from 0
		System.out.println(row.getLastCellNum());
		
		System.out.println(sheet.getPhysicalNumberOfRows());  //this will return only number of rows with actual data - index starts from 1
	
	
	}
	
	
	
//	public static List<String> getData(int rownum)
//	{
//		
//		List<String> list = new ArrayList<String>();
//		
//		return list;
//		
//	}
//	
//	
//	public static Object[][] getData()
//	{
//		Object[][] obj = new Object[sheet.getLastRowNum()][row.getLastCellNum()]
//			
//				
//				
//				return obj;
//	}
}
