package javascriptexecutorandscreenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ScreenshotTest2 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();
		
	}
	@Test
	public void screenshotTest() throws IOException
	{
		//takes screenshot first haighlight element username
		 WebElement username=driver.findElement(By.xpath("//input[@id='username']"));
		 username.sendKeys("sasikumar");
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].style.border='3px solid red'",username);
		 try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File srcFile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir")+"\\Adactin2.png"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
