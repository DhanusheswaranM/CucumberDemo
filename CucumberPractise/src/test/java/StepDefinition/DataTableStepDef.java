package StepDefinition;
import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DataTableStepDef {
	WebDriver driver ;

@Given("User is on the OrangeHRM application")
public void user_is_on_the_orange_hrm_application() {
	driver = new ChromeDriver();
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
}

@When("User enters the valid Credentials")
public void user_enters_the_valid_credentials(io.cucumber.datatable.DataTable dataTable){
	List<List<String>> listoption = dataTable.asLists(String.class);
	String userName = listoption.get(0).get(0);
	String passWord = listoption.get(0).get(1);
	driver.findElement(By.name("username")).sendKeys(userName);
	driver.findElement(By.name("password")).sendKeys(passWord);
	
	driver.findElement(By.xpath("//form[@class='oxd-form']/div[3]/button")).submit();
    
}

@Then("User should be able to login successfully and new page will open")
public void user_should_be_able_to_login_successfully_and_new_page_will_open() {

	String expectedDashboardText = "Dashboard";
	WebElement dashboardText = driver.findElement(By.xpath("//header[@class='oxd-topbar']/div/div/span/h6"));
	Assert.assertTrue(dashboardText.getText().contains(expectedDashboardText));
	driver.quit();
}


@Then("User is able to visible the errorMessage")
public void user_is_able_to_visible_the_error_message(io.cucumber.datatable.DataTable userTable) {
	
	List<Map<String,String>> user = userTable.asMaps(String.class , String.class);
	
	for(Map<String , String> form:user) {
		String UserName = form.get("Username");
		System.out.println("Username : "+UserName);
		driver.findElement(By.name("username")).sendKeys(UserName);
		
		String PassWord = form.get("Password");
		System.out.println("Password : "+PassWord);
		driver.findElement(By.name("password")).sendKeys(PassWord);
		
		driver.findElement(By.xpath("//form[@class='oxd-form']/div[3]/button")).submit();
		
		String actualError = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/p")).getText();
		String expectedError = user.get(0).get("ErrorMessage");
		
		System.out.println("Actual Error : "+actualError);
		Assert.assertTrue(expectedError.contains(actualError));
		
		
	}
	driver.quit();
	
}




}
