package handlings;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowHandle2 {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeMethod
	public void setUp() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(3000);
	}

	@Test
	public void multipleWindowHandleTest() throws InterruptedException {

		String homeWindowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();

		Set<String> allWindows = driver.getWindowHandles();

		Iterator<String> it = allWindows.iterator();
		while (it.hasNext()) {
			driver.switchTo().window(it.next());

			if (driver.getTitle().equals("Not Found")) {
				break;
			}
		}

		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium");

		driver.findElement(By.xpath("//input[@value='Search']")).click();
		Thread.sleep(3000);

		// switch to home window

		driver.switchTo().window(homeWindowHandle);

		Thread.sleep(3000);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
