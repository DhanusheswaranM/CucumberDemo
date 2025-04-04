package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber-reports/CucumberForDataTableOutlineForTestNG.json"},
    features = "src/test/resources/com/features/DataTable.feature",
    glue = "StepDefinition"
//    ,tags = ("not @Regression")
)
public class runnerTestNG extends AbstractTestNGCucumberTests {

}