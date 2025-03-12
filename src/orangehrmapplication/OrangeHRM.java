package orangehrmapplication;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrangeHRM {
	
	WebDriver driver;
	
	@BeforeClass
	public void SetUP()
	{
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
	}
	
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@placeholder='Username' and @name = 'username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
		Thread.sleep(3000);
	}
	
	@Test(dependsOnMethods="LoginTest")
	public void CreateUser() throws InterruptedException
	{
		//After get login into the dashboard user wants to create a user data into portal
		driver.findElement(By.xpath("//a[contains(@href,'admin')]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()=' Add ']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//div[@class='oxd-select-text-input'])[1]")).sendKeys("admin");
		Thread.sleep(3000);
	}
	
	
	
	@AfterClass
	public void Teardown()
	{
	driver.quit();	
	}

}
