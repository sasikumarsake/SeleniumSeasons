package miscellenousactions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragandDrop {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();

	}

	@Test
	public void dragandDropTest() throws InterruptedException {
		
		//to swritch to iframes/frame
		driver.switchTo().frame(0);
		
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.xpath("//div[@id='draggable']")),
				driver.findElement(By.xpath("//div[@id='droppable']"))).build().perform();

	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
