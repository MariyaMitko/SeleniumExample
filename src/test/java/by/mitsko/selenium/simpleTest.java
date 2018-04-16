package by.mitsko.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class simpleTest {
	@Test
	public void f() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("http://oz.by");
		Thread.sleep(2000);

		WebElement someElement = driver.findElement(By.name("q"));
		String str = someElement.getTagName();

		System.out.println(str);

		someElement.sendKeys("Java");
		someElement.submit();

		Thread.sleep(5000);
		driver.close();

	}
}
