package Step_Defenitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import Page_Objects.Add_Customer_Page_NOP;
import Page_Objects.Login_Page_NOP;
import Page_Objects.Search_Customer_Page_NOP;

public class NOP_Base_Steps {
	
	public WebDriver driver;
	public Login_Page_NOP lp;
	public Add_Customer_Page_NOP addcust;
	public Search_Customer_Page_NOP searhcust;
	
	
	//To generate random string for unique email id
	public static String randomstring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return generatedString1;
	}
	
	

}
