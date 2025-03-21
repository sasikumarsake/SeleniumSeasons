package assignments;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;

public class Assignment9 {
	
	
	/*
	 * Assignment:
	 * 
	 * https://demo.guru99.com/V4/
	 * 
	 * User ID : mngr589366 Password : yjahunA
	 * 
	 * --> after login_input --> Click on "Delete Customer" --> enter some
	 * "Customer ID	" in textbox --> Click on "Submit"
	 * 
	 * --> Check the text on alert to be
	 * "Do you really want to delete this Customer?"
	 * 
	 * --> Click on "Ok" button on alert
	 * 
	 * --> on the new alert now , check the text to be "Customer does not exist!!"
	 * 
	 * --> Click on "Ok" button on alert
	 */
	
	WebDriver driver;
	
	@BeforeMethod
	public void SetUp()
	{
		driver=new ChromeDriver();
		driver.get("https://demo.guru99.com/V4/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void alertsTest() throws InterruptedException
	{
		//login into account
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys("mngr589366");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("yjahunA");
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
		
		Thread.sleep(5000);
		//click the delete account button
		driver.findElement(By.xpath("//a[text()='Delete Account']")).click();
		
		//enter account number
		driver.findElement(By.xpath("//input[@name='accountno']")).sendKeys("1234567890");
		
		//click submit button 
		driver.findElement(By.xpath("//input[@name='AccSubmit']")).click();
		
		Thread.sleep(3000);
		
		Alert alert=driver.switchTo().alert();
		assertEquals(alert.getText(), "Do you really want to delete this Account?");
		alert.accept();
		
		Thread.sleep(5000);
		
		//new alert will appaear again in the window , read the text
		Alert al=driver.switchTo().alert();
		assertEquals(al.getText(), "Account does not exist");
		al.accept();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
