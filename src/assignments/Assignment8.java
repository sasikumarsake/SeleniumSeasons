package assignments;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Assignment8 {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();  // Maximize before loading
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // Prevent infinite loading
		driver.get("https://demo.guru99.com/test/guru99home/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@Test
	public void assignmentTest() {
		// Wadriveril JMeter image is clickable
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'Jmeter')]")))
		.build()
		.perform();
		//wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//img[@src='Jmeter720.png']"))).click();
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
