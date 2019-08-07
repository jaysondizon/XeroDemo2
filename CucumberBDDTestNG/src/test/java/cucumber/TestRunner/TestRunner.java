package cucumber.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(  
	    features = "src/test/java/features",
	    glue="cucumber.StepDefinitions",
	    tags = {"@AddBankAccountTesting"},
	    plugin = { "pretty", "html:target/site/cucumber-pretty","json:target/cucumber.json" },
	    monochrome = true)
public class TestRunner extends AbstractTestNGCucumberTests {

}
