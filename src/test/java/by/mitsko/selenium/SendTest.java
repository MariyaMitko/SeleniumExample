package by.mitsko.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SendTest {
	
	private WebDriver driver;
	
		
          @Test
          public void f() throws InterruptedException   {
    		  
    		  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
    		  WebDriver driver = new ChromeDriver();
    		      		  
    		  driver.get("https://mail.ru");
    		  
    		  WebElement login = driver.findElement(By.id("mailbox:login"));
    	      login.sendKeys("TATHTP");
    	      
    	      WebElement password = driver.findElement(By.id("mailbox:password"));
    	      password.sendKeys("Klopik123");
    	      
    	      WebElement submit = driver.findElement(By.id("mailbox:submit"));
    	      submit.click();
    	      Thread.sleep(5000);
    	      
        	  WebElement letter = driver.findElement(By.xpath("//*[@id='b-toolbar__left\']//span"));
      		  letter.click();
      		  
      		  Thread.sleep(5000);
      		  
      		  WebElement adress = driver.findElement(By.xpath("//textarea[@data-original-name='To']"));
    		  adress.sendKeys("mariyamitko@mail.ru");
    		
    		  WebElement topic = driver.findElement(By.xpath("//input[@name='Subject']"));
    		  topic.sendKeys("MyLetter");
    		
    		  WebElement fr = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
    		  driver.switchTo().frame(fr);
    		  
    		  WebElement text = driver.findElement(By.xpath("//*[@id='tinymce']"));
    		  text.sendKeys("Hello!");
	          
    		  driver.switchTo().defaultContent();
    		  
    		  WebElement send = driver.findElement(By.xpath("//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"));
    		  send.click();
    		  
    		  WebElement output = driver.findElement(By.xpath("//*[@id='b-nav_folders']/div/div[2]/a/span"));
    		  output.click();
    		  
    		  
    		  
    		  WebElement myLetter = driver.findElement(By.xpath("//*[@id='b-letters']/div/div[5]/div/div[2]/div[2]/div/a/div[4]/div[3]/div[2]"));
    		  myLetter.click();
    		  
    		     		  
    		  Thread.sleep(10000);
    		  WebElement contact = driver.findElement(By.xpath("//*[@id='b-letter']/div[2]/div[3]/div[3]/div[2]/div[1]/span/span[1]"));
    		  Assert.assertEquals(contact.getText(), "Артем Каптур");
    		
    		
    		
  }
}
