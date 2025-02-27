package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElemenetMethods6 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://adactinhotelapp.com/index.php");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("Sashikumar");
		
		driver.findElement(By.id("password")).sendKeys("Sashikumar@47");
		
		driver.findElement(By.id("login")).click();
		
		Thread.sleep(3000);
		
		driver.navigate().back();
		
		driver.findElement(By.linkText("New User Register Here")).click();
		
		driver.findElement(By.id("username")).submit();
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
