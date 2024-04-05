package Step_Defenitions;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import Page_Objects.Add_Customer_Page_NOP;
import Page_Objects.Login_Page_NOP;
import Page_Objects.Search_Customer_Page_NOP;
import io.cucumber.java.en.*;

public class NOP_Steps extends NOP_Base_Steps{

	//Login Test Step Definition
		
	@Given("Lunch Edge Browser")
	public void lunch_edge_browser() {
		driver=new EdgeDriver();
		lp=new Login_Page_NOP(driver);
	}

	@When("Open URL {string}")
	public void open_url(String URL) {
		driver.manage().window().maximize();
		driver.get(URL); 
	}

	@When("Enter Email as {string} and Password as {string}")
	public void enter_email_as_and_password_as(String email, String pass) {
		lp.logindetails(email, pass);
	}

	@When("Click on Login")
	public void click_on_login() {
		lp.login();
	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessfull."))
		{
			driver.close();
			Assert.assertTrue(false);
		}
		else
		{
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			Assert.assertEquals(title, driver.getTitle());
		}
			
	}

	@When("Click on logout link")
	public void click_on_logout_link() throws InterruptedException {
		lp.logout();
		Thread.sleep(2000);
	}

	@Then("Close Browser")
	public void close_browser() {
		driver.quit();
	}
	
	//Customer Details Step Definition...
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() {
		addcust=new Add_Customer_Page_NOP(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", addcust.Page_Title());
	}
	
	@When("User click on customers menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(2000);
		addcust.customer_menu();
	}
	
	@When("Click on customer menu item")
	public void click_on_customer_menu_item() throws InterruptedException {
		Thread.sleep(2000);
		addcust.customer_menu_btn();
	}
	
	@When("Click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		Thread.sleep(2000);
		addcust.add_new_cust();
	}
	
	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.Page_Title());
	}
	
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email=randomstring()+"@gmail.com";
		addcust.new_cust_credetials(email, "qwerty@123");
		addcust.new_cust_name("Aravind", "Raj");
		addcust.DOB("07/08/1995");
		addcust.cmpny_name("Luminar");
		addcust.admin_comment("New Employee for QA");
		addcust.tax();
		//addcust.active();
		addcust.gender("Male");
		addcust.vendor_manager("Not a vendor");
		addcust.newsletter("");
		addcust.cust_roles("Guest");
	}
	
	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		addcust.save();
	}
	
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String message) throws InterruptedException {
		Thread.sleep(2000);
		System.out.println(message);
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains(message));
	}
	
	//Search Customer Details using email Step Definition...
	
	@When("Enter customer email")
	public void enter_customer_email() {
		searhcust=new Search_Customer_Page_NOP(driver);
		searhcust.email_set("victoria_victoria@nopCommerce.com");
	}
	
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		searhcust.search();
	}
	
	@Then("User should find customer email in the table")
	public void user_should_find_customer_email_in_the_table() {
		boolean status=searhcust.serch_cust_email("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	}
	
	//Search Customer Details using name Step Definition...
	
	@When("Enter customer First Name")
	public void enter_customer_first_name() throws InterruptedException {
		searhcust=new Search_Customer_Page_NOP(driver);
		searhcust.fname_set("Victoria");
	}
	
	@When("Enter customer Last Name")
	public void enter_customer_last_name() throws InterruptedException {
		searhcust.lname_set("Terces");
	}
	
	@Then("User should find name in the table")
	public void user_should_find_name_in_the_table() {
		boolean status=searhcust.serch_cust_name("Victoria", "Terces");
		Assert.assertEquals(true, status);
	}

}
