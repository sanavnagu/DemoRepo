package bddStepDef;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.testng.asserts.SoftAssert;

import configFile.CSVCheck;
import configFile.ReadExcelFile;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BddStepDefinition 
{
	
	
	@Given("^I am in Login page of the application$")
	public void i_am_in_Login_page_of_the_application() throws Throwable {
	   
	}

	@When("^I Enter the \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_Enter_the_and(String arg1, String arg2) throws Throwable {
	    
	}

	@Then("^I should Navigate to home page$")
	public void i_should_Navigate_to_home_page() throws IOException
	{
		ReadExcelFile objExcelFile = new ReadExcelFile();
		
		CSVCheck csvobj = new CSVCheck();
		//Prepare the path of excel file

		String filePath = System.getProperty("user.dir")+"/src/test/resources/Data";

		//Call read file method of the class to read data

		System.out.println("Excel file path : "+ filePath);

		objExcelFile.readExcel(filePath,"LoginPage.xlsx","Data");
		
		
		csvobj.csvFilecompare();
		
			
		
	}
}
