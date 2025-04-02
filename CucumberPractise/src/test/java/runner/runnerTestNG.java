package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;

@CucumberOptions(
    plugin = {"pretty", "json:target/cucumber-reports/CucumberForSauceDemoForTestNG.json"},
    features = "src/test/resources/com/features/SauceDemo.feature",
    glue = "stepDefinitions"
)
public class runnerTestNG extends AbstractTestNGCucumberTests {

}
