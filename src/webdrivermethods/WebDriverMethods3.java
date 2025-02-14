package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods3 {

	public static void main(String[] args) throws InterruptedException {

		//default constructor
		//browser start
		WebDriver driver=	new ChromeDriver();
		
		//manage() method
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.get("https://adactinhotelapp.com/");
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		//System.out.println(driver.getPageSource());
		
		System.out.println("-------------------");
		
		System.out.println("Printing the window handle value "+driver.getWindowHandle());
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getWindowHandles());
		
		driver.quit();
	}

}
