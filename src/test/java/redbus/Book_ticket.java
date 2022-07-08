package redbus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Book_ticket {
	public static WebDriver driver;
	@Test
	public static void booking() throws InterruptedException
	{
			System.setProperty("webdriver.chrome.driver", "D:\\Automatin_Software\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("https://www.redbus.in/");
		 	driver.findElement(By.id("src")).sendKeys("hyd" );
		 	//driver.findElement(By.xpath("//*[@class='selected']")).click();
		 	Thread.sleep(2000);
		 	driver.findElement(By.id("src")).sendKeys(  Keys.ARROW_DOWN+" " +Keys.ENTER);
			Thread.sleep(5000);
			driver.findElement(By.id("dest")).sendKeys("nellore");
			Thread.sleep(2000);
			driver.findElement(By.id("dest")).sendKeys(Keys.ARROW_DOWN+"" +Keys.ENTER);
			
			driver.findElement(By.id("onward_cal")).click();
			driver.findElement(By.xpath("//table//tr/td[contains(text(),'14')]")).click();
			driver.findElement(By.id("search_btn")).click();
		    Thread.sleep(5000);
		    driver.findElement(By.xpath("//*[@title='SLEEPER']")).click();
		    driver.findElement(By.xpath("//*[@title='AC']")).click();
		    driver.findElement(By.xpath("//*[@class='button view-seats fr']")).click();
		    Thread.sleep(5000);
	}

	@AfterTest
	public void close()
{
	 driver.quit();
	}
}
