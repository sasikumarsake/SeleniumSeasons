package handlings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FrameHandling2 {

	WebDriver driver;

	@BeforeMethod
	public void SetUp() {
		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();

	}

	@Test
	public void dragandDropTest() throws InterruptedException {

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']")));
		
		WebElement srcimageOne=driver.findElement(By.xpath("//img[@alt='The peaks of High Tatras']"));
		WebElement destPlace=driver.findElement(By.xpath("//div[@id='trash']"));
		
		Thread.sleep(4000);
		
		Actions dragDrop=new Actions(driver);
		dragDrop.dragAndDrop(srcimageOne, destPlace).build().perform();
		
		Thread.sleep(4000);
		
	}

	@AfterMethod
	public void TearDown() throws InterruptedException {
		driver.quit();
		Thread.sleep(2000);
	}
}
