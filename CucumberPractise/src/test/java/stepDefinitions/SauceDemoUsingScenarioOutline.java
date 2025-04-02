package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SauceDemoUsingScenarioOutline {
	WebDriver driver ;
	
	
	@Given("the user is on the login page for login")
	public void the_user_is_on_the_login_page_for_login() {
			System.out.println("------------Chrome browser opening------------");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@When("the user enters the username as {string}")
	public void the_user_enters_the_username_as(String username) {

		WebElement usernamefield = driver.findElement(By.id("user-name"));
		usernamefield.sendKeys(username);
	}

	@When("the user enters the password as {string}")
	public void the_user_enters_the_password_as(String password) {

		WebElement passwordfield = driver.findElement(By.id("password"));
		passwordfield.sendKeys(password);
	
	}

	@Then("the user should be see an error message in the same page {string}")
	public void the_user_should_be_see_an_error_message_in_the_same_page(String errorMsg) {

		WebElement error = driver.findElement(By.xpath("//div[@id=\"login_button_container\"]/div/form/h3"));
		System.out.println("---------------"+error.getText()+"---------------");
		Assert.assertTrue(error.getText().contains(errorMsg));
		driver.quit();
	}
	
	@When("the user click the login button")
	public void the_user_click_the_login_button() {

		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
	}



}
