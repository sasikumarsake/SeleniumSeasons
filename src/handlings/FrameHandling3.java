package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling3 {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://www.angelfire.com/super/badwebs/");
		driver.manage().window().maximize();

	}

	@Test
	public void dragandDropTest() throws InterruptedException {

		driver.switchTo().frame("main");
		
		driver.findElement(By.xpath("//a[@href='monkeyspaw.htm']")).click();
		
		Thread.sleep(4000);
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("contents");
		
		driver.findElement(By.xpath("//a[@href='http://www.useit.com/alertbox/9612.html']")).click();
		Thread.sleep(4000);
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
