package by.mitsko.selenium;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class ChatWithFriendTest {

	private WebDriver driver;
	private int countReplays = 0;

	@Test
	public void chatWithFriend() throws InterruptedException {
		writeLetter("artemkaptur@mail.ru");

		if (checkAnswer()) {
			chatWithFriend();
		}
		Assert.assertTrue(countReplays == 3);
	}

	private void writeLetter(String email) {
		WebElement wtiteLetter = driver.findElement(By.xpath("//*[@id='b-toolbar__left\']//span"));
		wtiteLetter.click();

		WebElement recipient = driver.findElement(By.xpath("//textarea[@data-original-name='To']"));
		recipient.sendKeys(email);

		WebElement topic = driver.findElement(By.xpath("//input[@name='Subject']"));
		topic.sendKeys("Bla-bla-bla");

		WebElement frameChange = driver.findElement(By.xpath("//iframe[@allowtransparency='true']"));
		driver.switchTo().frame(frameChange);

		WebElement message = driver.findElement(By.xpath("//*[@id='tinymce']"));
		message.sendKeys("What a day! What a wonderful day!!");

		driver.switchTo().defaultContent();

		WebElement sendLetter = driver
				.findElement(By.xpath("//*[@id='b-toolbar__right']/div[3]/div/div[2]/div[1]/div"));
		sendLetter.click();
	}

	private void loginMail() {
		driver.get("https://mail.ru");

		WebElement login = driver.findElement(By.id("mailbox:login"));
		login.sendKeys("mariyamitko");

		WebElement password = driver.findElement(By.id("mailbox:password"));
		password.sendKeys("ZcysqGthtw13");

		WebElement submitButton = driver.findElement(By.id("mailbox:submit"));
		submitButton.click();
	}

	private boolean checkAnswer() throws InterruptedException {
		if (countReplays > 2) {
			return false;
		}

		Thread.sleep(5000);

		WebElement arrivedLetters = driver.findElement(By.xpath("//*[@id='b-nav_folders']/div/div[1]/a/span[2]"));
		arrivedLetters.click();

		String currentTime = new Date().getHours() + ":" + new Date().getMinutes();
		if (new Date().getMinutes() < 10) {
			currentTime = new Date().getHours() + ":0" + new Date().getMinutes();
		}

		WebElement letterArrivedTime = driver
				.findElement(By.xpath("//*[@id='b-letters']/div/div[2]/div/div[2]/div[1]/div/a/div[4]/div[1]/span"));

		WebElement senderEmail = driver
				.findElement(By.xpath("//*[@id='b-letters']/div/div[2]/div/div[2]/div[1]/div/a/div[4]/div[3]/div[2]"));

		if (letterArrivedTime.getText().equals(currentTime)
				&& senderEmail.getText().equals("Артем Каптур")) {
			countReplays++;
			return true;
		}

		return false;
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "d:/driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		loginMail();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}