package configFile;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Comparefiles 
{

	    public static void main(String[] args) throws FileNotFoundException
	    {
	 
	        ArrayList<String> valuesInSheetOne = new ArrayList<String>();
	        ArrayList<String> valuesInSheetTwo = new ArrayList<String>();
	 
	        File sheet1 = new File("C:\\Users\\sanav\\Desktop\\csvData\\LotMaster.csv");
	        File sheet2 = new File("C:\\Users\\sanav\\Desktop\\csvData\\TaxLotMaster.csv");
	 
	        Scanner scannerForSheetOne = new Scanner(sheet1);
	        Scanner scannerForSheetTwo = new Scanner(sheet2);
	 
	        scannerForSheetOne.nextLine();
	        while (scannerForSheetOne.hasNextLine()) {
	            valuesInSheetOne.add(scannerForSheetOne.nextLine().split(",")[1]);
	        }
	 
	        scannerForSheetTwo.nextLine();
	        while (scannerForSheetTwo.hasNextLine()) {
	            valuesInSheetTwo.add(scannerForSheetTwo.nextLine().split(",")[1]);
	        }
	 
	        int iteration = 0;
	 
	        System.out.printf("%-6s%-6s%-6s\n","LotMaster", "    ", "TaxLotMaster");
	        System.out.println();
	 
	        for (String value : valuesInSheetOne) {
	            if(valuesInSheetOne.get(iteration).compareToIgnoreCase(valuesInSheetTwo.get(iteration)) != 0) {
	                System.out.printf("%-7s%-6s%-7s\n",valuesInSheetOne.get(iteration), " --> ", valuesInSheetTwo.get(iteration));
	            }
	            iteration++;
	        }
	    }
	
}
