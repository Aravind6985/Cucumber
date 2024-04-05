package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait_Helper {
	
public WebDriver driver;
	
	public Wait_Helper(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void WaitForElement(WebElement element, Duration timeOutInSeconds)
	{
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}



}
