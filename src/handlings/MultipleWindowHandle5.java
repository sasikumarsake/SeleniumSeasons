package handlings;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle5 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://adactinhotelapp.com/");
	}

	@Test
	public void multipleWindowHandleTest() {
		String homeWindowHandle = driver.getWindowHandle();

		// Click Google Play button and switch to new window
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		switchToNewWindow("Not Found");

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@value='Search']")).click();

		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// Click iOS button and switch to new window
		driver.findElement(By.xpath("//img[contains(@src,'ios-button')]")).click();
		switchToNewWindow("TestFlight - Apple");

		// Scroll and click on Terms of Service
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,10000)");

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Terms of Service']"))).click();

		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// Switch to Apple Legal page
		switchToNewWindow("Legal - Apple Media Services - Apple");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Choose your country/region']")))
				.click();

		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);
	}

	/**
	 * Switches to a newly opened window that matches the expected title.
	 */
	private void switchToNewWindow(String expectedTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(expectedTitle)) {
				System.out.println("Switched to window: " + expectedTitle);
				return;
			}
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
