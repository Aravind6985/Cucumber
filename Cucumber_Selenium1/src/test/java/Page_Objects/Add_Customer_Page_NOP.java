package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Add_Customer_Page_NOP {
	
	public WebDriver driver;
	
	By customers_menu=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/a");
	By customers_btn=By.xpath("/html/body/div[3]/aside/div/div[4]/div/div/nav/ul/li[4]/ul/li[1]/a/p");
	By add_new_cust_btn=By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	By cust_email=By.name("Email");
	By cust_pass=By.name("Password");
	By cust_fname=By.name("FirstName");
	By cust_lname=By.name("LastName");
	By cust_male=By.id("Gender_Male");
	By cust_female=By.id("Gender_Female");
	By cust_DOB=By.name("DateOfBirth");
	By cust_cmpny=By.name("Company");
	By cust_tax=By.xpath("//*[@id=\"IsTaxExempt\"]");
	By cust_newsletter=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[9]/div[2]/div/div[1]/div/div/input");
		By news_1=By.xpath("//li[contains(text(),'Your store name')]"); 		 //Your store name
		By news_2=By.xpath("//li[contains(text(),'Test store 2')]");  			 //Test store 2
	By cust_role=By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/div");
		By role_1=By.xpath("//li[contains(text(),'Administrators')]");			 //Administrators
		By role_2=By.xpath("//li[contains(text(),'Forum Moderators')]");		 //Forum Moderators
		By role_3=By.xpath("//li[contains(text(),'Guests')]");					 //Guests
		By role_4=By.xpath("//li[contains(text(),'Registered')]");				 //Registered
		By role_5=By.xpath("//li[contains(text(),'Vendors')]");					 //Vendors
	By cust_vendor=By.xpath("//*[@id=\"VendorId\"]");
		By vendor_1=By.xpath("//*[@id=\"VendorId\"]/option[1]");				 //Not a vendor
		By vendor_2=By.xpath("//*[@id=\"VendorId\"]/option[2]");				 //Vendor 1
		By vendor_3=By.xpath("//*[@id=\"VendorId\"]/option[3]");				 //Vendor 2
	By cust_active=By.name("Active");
	By cust_admin_comment=By.name("AdminComment");
	By save_btn=By.name("save");
	By save_cont_btn=By.name("save-continue");
	By back=By.xpath("/html/body/div[3]/div[1]/form/div[1]/h1/small/a");
	
	public Add_Customer_Page_NOP(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String Page_Title()
	{
		return driver.getTitle();
	}
	
	public void customer_menu()
	{
		driver.findElement(customers_menu).click();
	}
	
	public void customer_menu_btn()
	{
		driver.findElement(customers_btn).click();
	}
	
	public void add_new_cust()
	{
		driver.findElement(add_new_cust_btn).click();
	}
	
	public void new_cust_credetials(String email, String pass)
	{
		driver.findElement(cust_email).sendKeys(email);
		driver.findElement(cust_pass).sendKeys(pass);
	}
	
	public void new_cust_name(String f_name, String l_name)
	{
		driver.findElement(cust_fname).sendKeys(f_name);
		driver.findElement(cust_lname).sendKeys(l_name);
	}
	
	public void DOB(String dob)
	{
		driver.findElement(cust_DOB).sendKeys(dob);
	}
	
	public void cmpny_name(String company_name)
	{
		driver.findElement(cust_cmpny).sendKeys(company_name);
	}
	
	public void admin_comment(String admin_cmt)
	{
		driver.findElement(cust_admin_comment).sendKeys(admin_cmt);
	}
	
	public void tax()
	{
		driver.findElement(cust_tax).click();
	}
	
	public void active()
	{
		driver.findElement(cust_active).click();
	}
	
	public void gender(String gender) throws InterruptedException
	{
		Thread.sleep(1000);
		if(gender.equals("Male"))
			driver.findElement(cust_male).click();
		else if(gender.equals("Female"))
			driver.findElement(cust_female).click();
		else
			driver.findElement(cust_male).click();		//default
	}
	
	public void vendor_manager(String vendor_name) throws InterruptedException
	{
		WebElement vendor=driver.findElement(cust_vendor);
		Thread.sleep(1000);
		Select vendor_sel=new Select(vendor);
		vendor_sel.selectByVisibleText(vendor_name);
	}
	
	public void cust_roles(String role) throws InterruptedException
	{
		if(!role.equals("Vendors"))
		{
			driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		}
		driver.findElement(cust_role).click();
		WebElement role_list;
		Thread.sleep(1000);
		if(role.equals("Administrators"))
			role_list=driver.findElement(role_1);
		
		else if(role.equals("Forum Moderators"))
			role_list=driver.findElement(role_2);
		
		else if(role.equals("Guests"))
			role_list=driver.findElement(role_3);
		
		else if(role.equals("Registered"))
			role_list=driver.findElement(role_4);
		
		else if(role.equals("Vendors"))
			role_list=driver.findElement(role_5);
		else
			role_list=driver.findElement(role_3);		//default
		role_list.click();
	}
	
	public void newsletter(String news_letter) throws InterruptedException
	{
		driver.findElement(cust_newsletter).click();
		WebElement newsletter;
		
		if(news_letter.equals("Your store name"))
			newsletter=driver.findElement(news_1);
		
		else if(news_letter.equals("est store 2"))
			newsletter=driver.findElement(news_2);
		
		else
			newsletter=driver.findElement(news_1);		//default
		Thread.sleep(500);
		newsletter.click();
	}
	
	public void save() throws InterruptedException
	{
		driver.findElement(save_btn).click();
		Thread.sleep(1000);
	}
	
}
