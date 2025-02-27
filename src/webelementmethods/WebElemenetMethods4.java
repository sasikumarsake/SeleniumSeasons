package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElemenetMethods4 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.id("username")).isDisplayed());
		
		Thread.sleep(2000);
		
		driver.quit();
	}

}
