package StepDefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import genericMethods.BaseClassGeneric;

public class DriverStepDefinition extends BaseClassGeneric {
	
	BaseClassGeneric bcg = new BaseClassGeneric();
	
	@Given("^Click on home page link$")
	public void click_on_home_page_link() throws Throwable {
	
		navigateHome_page();
		clk_homepageobj();
	}

	@Then("^Verify text in open window$")
	public void verify_text_in_open_window() throws Throwable {
	    
		switchwindow();
		childwindow();
	}

	@Then("^Close the child window$")
	public void close_the_child_window() throws Throwable {
	    
		closethewindow();
		
	}

	@Then("^Verify the text from parent window$")
	public void verify_the_text_from_parent_window() throws Throwable {
		//navigatetohom(driver);
		getparenttxt();
	    
	}
	
	

}
