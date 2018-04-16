package by.mitsko.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MyMailTest {
 	  private WebDriver driver;
		
		
      @Test
      public void f() throws InterruptedException   {
		  
		  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		      		  
		  driver.get("https://mail.ru");
		  
		  WebElement login = driver.findElement(By.id("mailbox:login"));
	      login.sendKeys("mariyamitko");
	      
	      WebElement password = driver.findElement(By.id("mailbox:password"));
	      password.sendKeys("ZcysqGthtw13");
	      
	      WebElement submit = driver.findElement(By.id("mailbox:submit"));
	      submit.click();
	      Thread.sleep(5000);
	      
    	  WebElement letter = driver.findElement(By.xpath("//*[@id='b-toolbar__left\']//span"));
  		  letter.click();
  		  
  		  Thread.sleep(5000);
  		  
  		  WebElement adress = driver.findElement(By.xpath("//textarea[@data-original-name='To']"));
		  adress.sendKeys("artemkaptur@mail.ru");
		
		  WebElement topic = driver.findElement(By.xpath("//input[@name='Subject']"));
		  topic.sendKeys("MyLetter");
		
		  WebElement fr = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
		  driver.switchTo().frame(fr);
		  
		  WebElement text = driver.findElement(By.xpath("//*[@id='tinymce']"));
		  text.sendKeys("Hello!");
          
		  driver.switchTo().defaultContent();
		  
		  WebElement send = driver.findElement(By.xpath("//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"));
		  send.click();
		 
		  
		
		
		
}


  
}
