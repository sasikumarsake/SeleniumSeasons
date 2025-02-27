package webelementmethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class WebElemenetMethods3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");
		
		//maximize the browser
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("login")).click();	
		
		System.out.println(driver.findElement(By.id("username")).getLocation().getX());
		System.out.println(driver.findElement(By.id("username")).getLocation().getY());
		System.out.println("The Element height is:"+driver.findElement(By.id("username")).getSize().getHeight());
		System.out.println("The Element width is:"+driver.findElement(By.id("username")).getSize().getWidth());
		
		//using getRect
		
		System.out.println(driver.findElement(By.id("username")).getRect().getX());
		System.out.println(driver.findElement(By.id("username")).getRect().getY());
		System.out.println("The Element height is:"+driver.findElement(By.id("username")).getRect().getHeight());
		System.out.println("The Element width is:"+driver.findElement(By.id("username")).getRect().getWidth());
		Thread.sleep(2000);
		driver.quit();
	}

}
