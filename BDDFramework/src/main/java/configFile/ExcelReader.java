package configFile;


import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
		public final static String EXCELFILELOCATION = "C:\\Users\\sanav\\eclipse-workspace\\BDDFramework\\src\\test\\resources\\Data\\LoginPage.xlsx";

		private static FileInputStream fis;
		private static XSSFWorkbook workbook;
		private static XSSFSheet sheet;
		private static XSSFRow row;

		public static void loadExcel() throws Exception
		{
			System.out.println("Loading Excel Data....");
		
			File file = new File(EXCELFILELOCATION);
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet("Data");
			fis.close();
		}
		
		public static Map<String, Map<String, String>> getDataMap() throws Exception
		{
			if(sheet == null)
			{
				loadExcel();
			}
			Map<String, Map<String, String>> superMap = new HashMap<String, Map<String, String>>();
			Map<String, String> mymap = new HashMap<String, String>();
			
			for(int i=1; i<sheet.getLastRowNum() +1; i++)
			{
				row = sheet.getRow(i);
				String keyCell = row.getCell(0).getStringCellValue();
				
				int colNum = row.getLastCellNum();
				for(int j=1;j<colNum; j++)							
				{
					String value = row.getCell(j).getStringCellValue();
					mymap.put(keyCell, value);
				}
				
				superMap.put("MASTERDATA",mymap);
			}
			
			return superMap;
			
		}
		
		public static String getValue(String key) throws Exception
		{
			Map<String, String> myval = getDataMap().get("MASTERDATA");
			String retvalue = myval.get(key);
			return retvalue;
			
		}
		
		
		public static void main(String arg[]) throws Exception
		
		{
			
			
			System.out.println(getValue("UserName"));
			
			
		}
				
	
	

}
