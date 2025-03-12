package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDropAssignment {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://emicalculator.net/#google_vignette");
		driver.manage().window().maximize();

	}

	@Test
	public void dragAndDropAssignmentTest() throws InterruptedException {
		Actions action = new Actions(driver);
		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loanamountslider']//child::span")), 80, 0).build()
				.perform();
		Thread.sleep(5000);

		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loaninterestslider']/child::span")), 150, 0)
				.build().perform();
		Thread.sleep(5000);

		action.dragAndDropBy(driver.findElement(By.xpath("//div[@id='loantermslider']/child::span")), -80, 0).build()
				.perform();
		Thread.sleep(5000);
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
