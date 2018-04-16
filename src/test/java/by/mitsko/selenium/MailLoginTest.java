package by.mitsko.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;

public class MailLoginTest {
	
  
public void f() throws InterruptedException {
	  
	  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();
	  
	  driver.get("https://mail.ru");
	  Thread.sleep(2000);
	  
	  WebElement login = driver.findElement(By.id("mailbox:login"));
      login.sendKeys("TATHTP");
      
      WebElement password = driver.findElement(By.id("mailbox:password"));
      password.sendKeys("Klopik123");
      
      WebElement submit = driver.findElement(By.id("mailbox:submit"));
      submit.click();
       
      WebDriverWait wait = new WebDriverWait(driver, 10);
      ExpectedCondition conditionClick =  ExpectedConditions.elementToBeClickable(By.id("PH_user-email"));
	  WebElement element = wait.until(conditionClick);
	  
      WebElement user = driver.findElement(By.id("PH_user-email"));
      Assert.assertEquals(user.getText(), "tathtp@mail.ru");
     
      driver.close();
      
  }
  
	  
  
  }

