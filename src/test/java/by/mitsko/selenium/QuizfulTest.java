package by.mitsko.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class QuizfulTest {
  @Test
  public void f() throws InterruptedException{
	  System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
	  WebDriver driver = new ChromeDriver();

	 
	  
	    driver.get("http://www.quizful.net/LoginAction.registration");
		Thread.sleep(2000);

		WebElement login = driver.findElement(By.name("registrationForm.login"));
		login.sendKeys("MariaMM");
		
		
		WebElement password = driver.findElement(By.name("registrationForm.password"));
		password.sendKeys("qwert12345");
		
		
		WebElement repassword = driver.findElement(By.name("registrationForm.repassword"));
		repassword.sendKeys("qwert12345");
		
		
		WebElement email = driver.findElement(By.name("registrationForm.email"));
		email.sendKeys("mariyamitko3112@gmail.com");
		
		
		WebElement id = driver.findElement(By.name("registrationForm.corporate"));
		id.click();
		
		
		WebElement captcha = driver.findElement(By.name("registrationForm.captcha"));
		Thread.sleep(7000);
		captcha.click();
		
		WebElement confirm = driver.findElement(By.name("ok"));
		confirm.click();
		
	  
	    driver.get("http://www.quizful.net/LoginAction.loginForm");
        Thread.sleep(2000);
		
		WebElement loginConfinm = driver.findElement(By.name("loginForm.login"));
		loginConfinm.sendKeys("MariaMM");
		
		WebElement passwordConfinm = driver.findElement(By.name("loginForm.password"));
		passwordConfinm.sendKeys("qwert12345");
		
		WebElement confirm2 = driver.findElement(By.name("ok"));
		confirm2.click();
		
		
		
		

  }
}
