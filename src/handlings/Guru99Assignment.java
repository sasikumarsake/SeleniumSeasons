package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Guru99Assignment {
	
	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/guru99home/");
		driver.manage().window().maximize();
		

	}

	@Test
	public void guru99AssignmentTest() throws InterruptedException {

		Thread.sleep(5000);
		driver.switchTo().frame(driver.findElement(By.xpath("a077aa5e")));
		
		driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
		
		Thread.sleep(4000);
		
		
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
	
}
