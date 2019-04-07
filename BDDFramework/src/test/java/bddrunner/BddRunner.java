package bddrunner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
					features="src/main/java/features",
					glue = {"src/test/java/bddStepDef"}
						
				)
public class BddRunner {

}
