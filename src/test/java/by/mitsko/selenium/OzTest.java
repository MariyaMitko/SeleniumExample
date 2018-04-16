package by.mitsko.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OzTest {
	
	@Test
	public void f() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();

	  driver.get("http://oz.by");
	  Thread.sleep(2000);
	  
	  WebElement someElement = driver.findElement(By.name("q"));
	  someElement.sendKeys("Java");
		someElement.submit();
	  
	  List<WebElement> elements = driver.findElements(By.className("item-type-card__title"));
	  
	
	  for (WebElement el: elements){
	   System.out.println(el.getText());
	  	  }
	  
	  System.out.println("Count of books: " + elements.size());
	  
	  Thread.sleep(5000);
	  driver.close();
	} 
}
