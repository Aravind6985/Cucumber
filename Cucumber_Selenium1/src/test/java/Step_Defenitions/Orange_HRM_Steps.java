package Step_Defenitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;


public class Orange_HRM_Steps {

	WebDriver driver;
	
	@Given("I launch edge browser") 
	public void i_launch_edge_browser() {
		driver=new EdgeDriver(); 
	}

	@When("I open orange HRM home page")
	public void i_open_orange_hrm_home_page() {
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@SuppressWarnings("deprecation")
	@Then("I verify that the logo is present")
	public void i_verify_that_the_logo_is_present() throws InterruptedException {
		Thread.sleep(2000);
		boolean status=driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
		Assert.assertEquals(true, status);
	}

	@Then("Close browser")
	public void close_browser() {
	    driver.quit();
	}
}