package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginStepDefinition {
	WebDriver driver = new ChromeDriver();
	@Given("I am in the OrangeHRM login page")
	public void i_am_in_the_orange_hrm_login_page() {
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}

	@When("user should provide valid Username")
	public void user_should_provide_valid_username() {
		driver.findElement(By.name("username")).sendKeys("Admin");
	}

	@When("user should provide valid password")
	public void user_should_provide_valid_password() {
		driver.findElement(By.name("password")).sendKeys("admin123");
	}

	@When("user clicks the login button")
	public void user_clicks_the_login_button() {
		 driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")).click();
	   
	}

	@Then("user will see the DashboardText in the page")
	public void user_will_see_the_dashboard_text_in_the_page() {
		String str1 = "Dashboard";
		  String str2 = driver.findElement(By.xpath("//div[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[1]/span/h6")).getText();
		  Assert.assertEquals(str1, str2, "The webPage is wrong");
		  driver.close();

	}


}
