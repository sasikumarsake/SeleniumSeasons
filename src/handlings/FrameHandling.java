package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

	}

	@Test
	public void dragandDropTest() throws InterruptedException {

		// to swritch to iframes/frame
		// driver.switchTo().frame(0);

		// by using string
		// driver.switchTo().frame("demo-frame"); //==>
		// org.openqa.selenium.NoSuchFrameException: No frame element found by name or
		// id demo-frame

		// by using webelement
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));

		WebElement srcImagePath = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement desctImagePath = driver.findElement(By.xpath("//div[@id='droppable']"));
		Actions action = new Actions(driver);
		action.dragAndDrop(srcImagePath, desctImagePath).build().perform();

	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
