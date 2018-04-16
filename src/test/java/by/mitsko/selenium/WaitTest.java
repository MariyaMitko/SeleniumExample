package by.mitsko.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class WaitTest {
  @Test
  public void f() {
	  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.switchTo().frame("");

	  driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	  
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.DAYS);
	  
	  WebDriverWait wait = new WebDriverWait(driver, 10);
	  ExpectedCondition condition  = ExpectedConditions.alertIsPresent();
	//  WebElement element = (WebElement) wait.until(condition); 
	  
	  ExpectedCondition conditionClick =  ExpectedConditions.elementToBeClickable(By.id("el1"));
	//  WebElement element2 = (WebElement) wait.until(conditionClick); 
	  
	//  WebElement myDynamicElement = (new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.id("myDynamicElement")));
  }
}
