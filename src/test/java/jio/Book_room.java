package jio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Book_room {
public static WebDriver driver;
	

	@Test
	public static void testing() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Automatin_Software\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.tridenthotels.com/");

	//driver.findElement(By.xpath("//*[contains(text(),'Find your hotel')]")).click();
	Thread.sleep(5000);
	//driver.findElement(By.id("hotelNav1")).click();
	//Thread.sleep(5000);
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Find your hotel')]"))).build().perform();
	//move to an element
//	IWebElement l = driver.FindElement(By.name("txtnam"));
//	a.MoveToElement(l).Perform();
	Thread.sleep(30000);
	driver.quit();
	}

}
