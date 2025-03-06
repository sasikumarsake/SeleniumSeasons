package toolsqa;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class NewTest1 {
	WebDriver driver;

	@Test
	public void loginTest() throws InterruptedException {



		driver.findElement(By.id("username")).sendKeys("Sasikumar");
		driver.findElement(By.id("password")).sendKeys("Sasikumar@123");
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);

		String Errormessage = "Invalid Login details or Your Password might have expired. Click here to reset your password";
		WebElement ExpectedMessage = driver
				.findElement(By.xpath("//b[text()='Invalid Login details or Your Password might have expired. ']"));
		String ActualMessage = ExpectedMessage.getText();
		
		// Assertion
				Assert.assertEquals(ActualMessage, Errormessage, "Error message does not match!");
				
				System.out.println("Error Is Getting : "+ActualMessage);
	}

	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Starting Test On Chrome Browser");
		String baseUrl = "https://adactinhotelapp.com/";

		driver = new ChromeDriver();
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
		System.out.println("Finished Test On Chrome Browser");
	}

}
