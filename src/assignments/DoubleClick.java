package assignments;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DoubleClick {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://selenium-prd.firebaseapp.com/");
		driver.manage().window().maximize();
	}

	@Test
	public void doubleClickTest() throws InterruptedException {
		// login into the page
		driver.findElement(By.xpath("//input[@id='email_field']")).sendKeys("admin123@gmail.com");
		driver.findElement(By.xpath("//input[@id='password_field']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()='Login to Account']")).click();

		//
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='dropdown']/button[normalize-space()='Intractions']")));

		WebElement doubleClick = driver.findElement(By.xpath("//a[text()='Double Click']"));

		Actions action = new Actions(driver);
		action.moveToElement(element).pause(2000).click(doubleClick).pause(3000).build().perform();

		Thread.sleep(3000);

		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='dropdown']/button[normalize-space()='Intractions']")));

		WebElement doubleClick1 = driver.findElement(By.xpath("//a[text()='Double Click']"));

		Actions action1 = new Actions(driver);
		action1.moveToElement(element1).pause(2000).click(doubleClick1).pause(3000).build().perform();

		WebElement doubleClick2 = driver.findElement(By.xpath("//button[text()='Double Click']"));
		Actions actions = new Actions(driver);

		for (int i = 0; i < 5; i++) { // Loop 10 times for 10 double clicks
			actions.doubleClick(doubleClick2).perform();
			Thread.sleep(1000);
		}

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}

}
