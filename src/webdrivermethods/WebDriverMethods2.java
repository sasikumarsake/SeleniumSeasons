package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods2 {

	public static void main(String[] args) throws InterruptedException {

		//default constructor
		//browser start
		WebDriver driver=	new ChromeDriver();
		
		//manage() method
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		driver.get("https://adactinhotelapp.com/");
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//img[contains(@src,'google-play')]")).click();
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
