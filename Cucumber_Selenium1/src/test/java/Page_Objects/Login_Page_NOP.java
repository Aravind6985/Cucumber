package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login_Page_NOP {
	
	public WebDriver driver;
	
	By email=By.name("Email");
	By pass=By.name("Password");
	By loginbut=By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button");
	By logout=By.xpath("//*[@id=\"navbarText\"]/ul/li[3]/a");
	
	public Login_Page_NOP(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void logindetails(String mail, String Pass)
	{
		driver.findElement(email).clear();
		driver.findElement(email).sendKeys(mail);
		driver.findElement(pass).clear();
		driver.findElement(pass).sendKeys(Pass);
	}
	
	public void login()
	{
		driver.findElement(loginbut).click();
	}
	
	public void logout()
	{
		driver.findElement(logout).click();
	}

}
