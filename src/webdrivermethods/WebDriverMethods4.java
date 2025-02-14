package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods4 {

	public static void main(String[] args) throws InterruptedException {

		//default constructor
		//browser start
		WebDriver driver=	new ChromeDriver();
		
		//manage() method
		driver.manage().window().maximize();
		
		Thread.sleep(1000);
		
		driver.get("https://adactinhotelapp.com/");
		
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("Forgot Password?")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
		driver.navigate().back();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().forward();
		
		System.out.println(driver.getTitle());
		
		driver.navigate().to("https://motherson.workvivo.com/");
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
