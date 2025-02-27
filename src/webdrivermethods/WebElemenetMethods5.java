package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElemenetMethods5 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.facebook.com/login/");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("email")).submit();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
