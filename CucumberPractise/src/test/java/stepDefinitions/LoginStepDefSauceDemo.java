package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefSauceDemo {
	
	public WebDriver driver ;
	@Before("@ChromeBrowser")
	public void BeforeChrome() {
		System.out.println("------------Chrome browser opening------------");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Before("@FireFoxBrowser")
	public void BeforeFireFox() {
		System.out.println("$$$$$$$$$$$$$FireFox browser opening$$$$$$$$$$$$$");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Before("@EdgeBrowser")
	public void BeforeEdge() {
		System.out.println("*************Edge browser opening*************");
		driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	
	@Before
	public void setup() {
		System.out.println("----------Before Executing----------");
		
	}
	@Given("the user in on Login page")
	public void the_user_in_on_login_page() {
		
		driver.get("https://www.saucedemo.com/v1/index.html");
	}

	@When("the user provides the valid username")
	public void the_user_provides_the_valid_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_user");
	}

	@When("the user provides the valid password")
	public void the_user_provides_the_valid_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_sauce");
	}

	@When("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
		WebElement loginbtn = driver.findElement(By.id("login-button"));
		loginbtn.click();
	}

	@Then("the user is able to visible the ProductText in the same page")
	public void the_user_is_able_to_visible_the_product_text_in_the_same_page() {
		WebElement productPage = driver.findElement(By.xpath("//*[@id=\"inventory_filter_container\"]/div"));
		String productPageTxt = productPage.getText();
		String expectedProductPageTxt = "Products";
		Assert.assertTrue(productPageTxt.contains(expectedProductPageTxt));
		System.out.println("Loggedin successfully");
		driver.quit();
	}

	@When("the user provides the blank username")
	public void the_user_provides_the_blank_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("");
	}

	@Then("the user is able to visible the error message")
	public void the_user_is_able_to_visible_the_error_message() {
		WebElement error = driver.findElement(By.xpath("//div[@id=\"login_button_container\"]/div/form/h3"));
		System.out.println("---------------"+error.getText()+"---------------");
		driver.quit();
	}

	@When("the user provides the blank password")
	public void the_user_provides_the_blank_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("");
	}

	@When("the user provides the invalid username")
	public void the_user_provides_the_invalid_username() {
		WebElement username = driver.findElement(By.id("user-name"));
		username.sendKeys("standard_users");
	}

	@When("the user provides the invalid password")
	public void the_user_provides_the_invalid_password() {
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("secret_saucess");
	}
	
	@After
	public void teardown() {
		System.out.println("----------Before Executing----------");
	}
	
	@After("@ChromeBrowser")
	public void AfterChrome() {
		System.out.println("------------Chrome browser closed------------");
	}
	
	@After("@FireFoxBrowser")
	public void AfterFireFox() {
		System.out.println("$$$$$$$$$$$$$FireFox browser closed$$$$$$$$$$$$$");
	}
	
	@After("@EdgeBrowser")
	public void AfterEdge() {
		System.out.println("*************Edge browser closed*************");
	}


}
