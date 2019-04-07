package configFile;


import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CompareExcel {

	public static void main(String[] args) {
		try {
			// get input excel files
			FileInputStream excellFile1 = new FileInputStream(new File("C:\\Users\\sanav\\Downloads\\LotMaster_20190312.xlsx"));
			FileInputStream excellFile2 = new FileInputStream(new File("C:\\Users\\sanav\\Downloads\\taxlotappacc_20190312.xlsx"));

			//FileInputStream excellFile1 = new FileInputStream(new File("C:\\Users\\sanav\\Downloads\\LotMaster_20190312.csv"));
			//FileInputStream excellFile2 = new FileInputStream(new File("C:\\Users\\sanav\\Downloads\\taxlotappacc_20190312.csv"));

			
			
			
			// Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook1 = new XSSFWorkbook(excellFile1);
			XSSFWorkbook workbook2 = new XSSFWorkbook(excellFile2);

			// Get first/desired sheet from the workbook
			XSSFSheet sheet1 = workbook1.getSheetAt(0);
			XSSFSheet sheet2 = workbook2.getSheetAt(0);

			// Compare sheets
			if (compareTwoSheets(sheet1, sheet2)) {
				System.out.println("\n\nThe two excel sheets are Equal");
			} else {
				System.out.println("\n\nThe two excel sheets are Not Equal");
			}

			// close files
			excellFile1.close();
			excellFile2.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Compare Two Sheets
	public static boolean compareTwoSheets(XSSFSheet sheet1, XSSFSheet sheet2) {

		boolean equalSheets = true;

		Map<String, Double> tracker1 = new HashMap<String, Double>();

		for (Row row : sheet1) {
			if (row.getRowNum() != 0) {
				/* TODO for getting the index in excel handle in lines with "row.getCell(0)"
				 * A - 0
				 * B -1
				 * C -2 and so on
				 *
				 * Here row.getCell(0) --> is the Asset and row.getCell(1) ---> is Value
				 * */
				try {
					String rowKey =row.getCell(1).toString();
					double count = tracker1.containsKey(rowKey)
							? tracker1.get(rowKey) : 0;
					// Update tracker by incrementing the counter

					tracker1.put(rowKey, row.getCell(4).getNumericCellValue() + count);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					equalSheets = false;
					System.out.println("###############Sheet1 Exception############>>>>"+row.getRowNum()+",Cell---->"+row.getCell(1)+",Error--->"+e.getMessage());
				}

			}
		}
		System.out.println(">>>>>>>Sheet1 with assets and its sum() of assets Value>>>>>>>>" + tracker1.toString());
		Map<String, Double> tracker2 = new HashMap<String, Double>();

		for (Row row : sheet2) {
			if (row.getRowNum() != 0) {
				/* TODO for getting the index in excel handle in lines with "row.getCell(0)"
				 * A - 0
				 * B -1
				 * C -2 and so on
				 *
				 * Here row.getCell(0) --> is the Asset and row.getCell(1) ---> is Value
				 * */
				try {

					String rowKey2 =row.getCell(3).toString();
					double count = tracker2.containsKey(rowKey2)
							? tracker2.get(rowKey2) : 0;

					tracker2.put(rowKey2, row.getCell(12).getNumericCellValue() + count);
				} catch (Exception e) {
					equalSheets = false;
					System.out.println("#########Sheet2 Exception##################>>>>"+row.getRowNum()+",Error--->"+e.getMessage());
				}
			}

		}
		System.out.println(">>>>>>>>Sheet2 with assets and its sum() of assets >>>>>>>" + tracker2.toString()+"\n\n");
		if (tracker2.size() == tracker1.size()) {

			for (String key : tracker2.keySet()) {
				if (!(tracker1.get(key).equals(tracker2.get(key)))) {
					System.out.println(">>>>>>>>Mismatch with Asset>>>>>>>" + key + ", the values in sheet 1 is :"
							+ tracker1.get(key) + ", and the value in sheet 2 is : " + tracker2.get(key));
					equalSheets = false;
				}
			}
		}else{
			System.out.println(">>>>>>>>ALERT Size Mismatch Sheet 1 size of assets is :"+tracker1.size()+" and Sheet 2 size of assets is :"+tracker2.size()+" \n\n");
			equalSheets = false;
		}

		return equalSheets;
	}


}
