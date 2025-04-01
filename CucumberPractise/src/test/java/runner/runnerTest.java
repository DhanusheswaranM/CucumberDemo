package runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty" , "html:target/cucumber-reports/CucumberForSauceDemoForJunit.html" }, 
features="src/test/resources/com/features/SauceDemo.feature" , 
glue="stepDefinitions")
public class runnerTest {

}
