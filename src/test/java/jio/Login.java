package jio;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class Login {
	public static WebDriver driver;
	

	@Test
	public static void testing() throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\Automatin_Software\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.get("https://www.tridenthotels.com/");

	//driver.findElement(By.xpath("//*[contains(text(),'Find your hotel')]")).click();
	Thread.sleep(10000);
	Actions a = new Actions(driver);
	a.moveToElement(driver.findElement(By.xpath("//*[contains(text(),'Find your hotel')]"))).build().perform();
	Thread.sleep(1000);
	driver.findElement(By.id("hotelNav1")).click();
	Thread.sleep(5000);

	driver.findElement(By.xpath("//div[@class='t-dates t-date-check-in']")).click();

	driver.findElement(By.xpath(
	"//th[contains(text(),'July 2022')]/ancestor::thead/following-sibling::tbody/descendant::tr//td[@data-t-date='1657650600000']"))
	.click();

	driver.findElement(By.xpath("//div[@class='dateWrap t-check-out']")).click();
	driver.findElement(By.xpath(
	"//th[contains(text(),'July 2022')]/ancestor::thead/following-sibling::tbody/descendant::tr//td[@data-t-date='1657996200000']"))
	.click();

	driver.findElement(By.xpath("//div[@class='roomsCount']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'01 Room')]")).click();
	driver.findElement(By.xpath("//div[@class='guestCount']")).click();
	driver.findElement(By.xpath("//div[contains(text(),'BOOK A STAY')]")).click();

	Select obj = new Select(driver.findElement(By.xpath("(//select[@class='needsclick select_hiddenInput'])[1]")));
	obj.selectByValue("rate");
	Select obj1 = new Select(driver.findElement(By.xpath("//select[@aria-labelledby='filter-bar-sort-by']")));
	obj1.selectByValue("priceHighestToLowest");
	Thread.sleep(5000);

	driver.findElement(By.xpath(
	"//a[@aria-label='Room details for Room with Breakfast and Dinner Deluxe Pool View Room']//parent::h3//following-sibling::div[@class='thumb-cards_wrapper']//descendant::button"))
	.click();
	Thread.sleep(15000);

	Select prefix = new Select(
	driver.findElement(By.xpath("//select[@aria-labelledby='guest-info-prefix-select-1']")));
	prefix.selectByValue("Mrs.");
	driver.findElement(By.xpath("//div[@class='guest-info_firstNameField input-field_container']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//input[@aria-label='First name is required.']")).sendKeys("AnushaSreekanth");

	Thread.sleep(5000);
	driver.close();

	}

	@AfterTest
	public void close(){
		driver.quit();
	}

}
