package runnerclass;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
					features="/MavenTest/src/test/java/FeatureFiles/DriverTest.feature",
					glue = {"/MavenTest/src/test/java/StepDefinition"}
						
				)
public class Runnerui {
	
	

}
