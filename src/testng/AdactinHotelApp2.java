package testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AdactinHotelApp2 {
	
	WebDriver driver;
	String URL="https://adactinhotelapp.com/";
	@Test
	public void LoginTest() throws InterruptedException
	{
		driver.findElement(By.id("username")).sendKeys("Sashikumar");
		driver.findElement(By.id("password")).sendKeys("Sashikumar@47");
		driver.findElement(By.id("login")).click();
		Thread.sleep(4000);
	}
	
	
	@Test(dependsOnMethods="LoginTest")
	public void SearchHotelTest() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.id("location")).sendKeys("Sydney");
		driver.findElement(By.id("hotels")).sendKeys("Hotel Sunshine");
		driver.findElement(By.id("room_type")).sendKeys("Deluxe");
		driver.findElement(By.id("room_nos")).sendKeys("2 - Two");
		WebElement datePick=driver.findElement(By.id("datepick_in"));
		datePick.clear();
		datePick.sendKeys("05/03/2025");
		
		WebElement datePickOut=driver.findElement(By.id("datepick_out"));
		datePickOut.clear();
		datePickOut.sendKeys("06/03/2025");
		
		driver.findElement(By.id("adult_room")).sendKeys("2 - Two");
		driver.findElement(By.id("child_room")).sendKeys("1 - One");
		driver.findElement(By.id("Submit")).click();
		
		Thread.sleep(2000);
		driver.findElement(By.id("radiobutton_0")).click();
		driver.findElement(By.id("continue")).click();
		Thread.sleep(4000);
	}
	
	@Test(dependsOnMethods="SearchHotelTest")
	public void BookAHotelTest() throws InterruptedException
	{
		driver.findElement(By.id("first_name")).sendKeys("Sashikumar");
		driver.findElement(By.id("last_name")).sendKeys("kumarskh");
		driver.findElement(By.id("address")).sendKeys("BTP TAPksjgdkjfkaj");
		driver.findElement(By.id("cc_num")).sendKeys("1234567890123456");
		driver.findElement(By.id("cc_type")).sendKeys("American Express");
		driver.findElement(By.id("cc_exp_month")).sendKeys("January");
		Select select =new Select(driver.findElement(By.id("cc_exp_year")));
		select.selectByVisibleText("2015");
		
		driver.findElement(By.id("cc_cvv")).sendKeys("977");
		driver.findElement(By.id("book_now")).click();
		Thread.sleep(5000);
	}
		
	@BeforeClass
	public void StartBrowser()
	{
		System.out.println("Starting the browser..!!");
		driver=new ChromeDriver();
		driver.get(URL);
		driver.manage().window().maximize();
	}
	
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("Closing the browser..!!");
	}
}
