package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;


@CucumberOptions(plugin= {"pretty" , "html:target/cucumber-reports/CucumberForSauceDemoForTestNG.html" }, 
features="src/test/resources/com/features/SauceDemo.feature" , 
glue="stepDefinitions")
public class runnerTestNG extends AbstractTestNGCucumberTests {

}