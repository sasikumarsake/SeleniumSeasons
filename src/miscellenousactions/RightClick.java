package miscellenousactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RightClick {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		driver.manage().window().maximize();

	}

	@Test
	public void rightClickTest() {
		Actions  action=new Actions(driver);
		action.contextClick(driver.findElement(By.xpath("//span[text()='right click me']")))
		.pause(2000)
		.keyDown(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.keyDown(Keys.DOWN)
		.pause(3000)
		.keyDown(Keys.ENTER)
		.pause(3000)
		.build().perform();
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
