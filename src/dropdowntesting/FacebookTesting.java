package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FacebookTesting {
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.facebook.com/login.php/");

		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Sign up for Facebook")).click();
		
		driver.getTitle();
		
		new Select(driver.findElement(By.id("day"))).selectByVisibleText("2");

		new Select(driver.findElement(By.id("month"))).selectByVisibleText("Oct");
		
		new Select(driver.findElement(By.id("year"))).selectByVisibleText("2000");
		
		Thread.sleep(3000);
		
		driver.quit();

	}

}
