package handlings;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle {
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setUp() throws InterruptedException
	{
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}
	@Test
	public void multipleWindowHandleTest() throws InterruptedException
	{
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		
		driver.findElement(By.xpath("//input[@value='Search']")).click();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
