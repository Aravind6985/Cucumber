package Page_Objects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Search_Customer_Page_NOP {
	
	public WebDriver driver;
	
	By email_Scr=By.name("SearchEmail");
	By fname_Scr=By.name("SearchFirstName");
	By lname_Scr=By.name("SearchLastName");
	By DOBMonth_Scr=By.name("SearchMonthOfBirth");
	By DOBDay_Scr=By.name("SearchDayOfBirth");
	By reg_frm_Scr=By.name("SearchRegistrationDateFrom");
	By reg_to_Scr=By.name("SearchRegistrationDateTo");
	By act_frm_Scr=By.name("SearchLastActivityFrom");
	By act_to_Scr=By.name("SearchLastActivityTo");
	By cmpny_Scr=By.name("SearchCompany");
	By ip_Scr=By.name("SearchIpAddress");
	By roles_Scr=By.xpath("//*[@class='k-multiselect-wrap k-floatwrap']");
	By role_cncl_Scr=By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]");
	By role1_Scr=By.xpath("//li[contains(text(),'Administrators')]");
	By role2_Scr=By.xpath("//li[contains(text(),'Forum Moderators')]");
	By role3_Scr=By.xpath("//li[contains(text(),'Guests')]");
	By role4_Scr=By.xpath("//li[contains(text(),'Registered')]");
	By role5_Scr=By.xpath("//li[contains(text(),'Vendors')]");
	By srch_btn_Scr=By.xpath("//*[@id='search-customers']");
	By table_Scr=By.xpath("//*[@id='customers-grid']");
	By table_row_Scr=By.xpath("//*[@id='customers-grid']/tbody/tr");
	
	By table_clmn_Scr=By.xpath("//*[@id='customers-grid']/tbody/tr/td");
	
	
	public Search_Customer_Page_NOP(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void email_set(String mail)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(email_Scr).sendKeys(mail);
	}
	
	public void fname_set(String name) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(fname_Scr).sendKeys(name);
	}
	
	public void lname_set(String name) throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(lname_Scr).sendKeys(name);
	}
	
	public void search() throws InterruptedException
	{
		driver.findElement(srch_btn_Scr).click();
		Thread.sleep(2000);
	}
	
	public int row_no()
	{
		List<WebElement>table_row=driver.findElements(table_row_Scr);
		return(table_row.size());
	}
	
	public int column_no()
	{
		List<WebElement>table_colum=driver.findElements(table_clmn_Scr);
		return(table_colum.size());
	}
	
	public boolean serch_cust_email(String mail)
	{
		boolean flag=false;
		for(int i=1;i<=row_no();i++)
		{
			List<WebElement> emailid=driver.findElements(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[2]"));
			for(WebElement email : emailid)
			{
				String id=email.getText();
				System.out.println("Mail id in search list: "+id);
				if(id.equals(mail))
				{
					flag=true;
				}
			}
		}
		return flag;
	}
	
	public boolean serch_cust_name(String fname, String lname)
	{
		boolean flag=false;
		for(int i=1;i<=row_no();i++)
		{
			List<WebElement> nameList=driver.findElements(By.xpath("//*[@id=\"customers-grid\"]/tbody/tr["+i+"]/td[3]"));
			for(WebElement fullname : nameList)
			{
				String nm=fullname.getText();
				System.out.println("Name in search list: "+nm);
				String name1[]=nm.split(" ");
				if(name1[0].equals(fname) && name1[1].equals(lname))
				{
					flag=true;
				}
			}
		}
		return flag;
	}

}
