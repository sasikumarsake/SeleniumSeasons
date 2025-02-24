package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElemenetMethods2 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).click();	
		
		System.out.println(driver.findElement(By.id("username_span")).getAttribute("class"));
		System.out.println(driver.findElement(By.id("username_span")).getAttribute("name"));
		
		System.out.println(driver.findElement(By.id("username_span")).getCssValue("font-size"));
		System.out.println(driver.findElement(By.id("username_span")).getCssValue("color"));
		System.out.println(driver.findElement(By.id("username_span")).getText());
		
		Thread.sleep(2000);
		driver.quit();
	}

}
