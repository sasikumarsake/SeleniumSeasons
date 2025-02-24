package webelementmethods;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class WebElemenetMethods1 {

	public static void main(String[] args) throws InterruptedException {
		//WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		//launching the URL 
		driver.get("https://adactinhotelapp.com/");

		//maximize the browser
		driver.manage().window().maximize();

		driver.findElement(By.id("username")).sendKeys("Sashikumar");
		Thread.sleep(3000);
		
		driver.findElement(By.name("password")).sendKeys("Sashikumar@47");
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).click();	
		Thread.sleep(3000);
		
		driver.findElement(By.id("datepick_in")).clear();
		Thread.sleep(2000);
		driver.findElement(By.id("datepick_in")).sendKeys("16/02/2025");
		Thread.sleep(3000);
		driver.quit();
	}

}
