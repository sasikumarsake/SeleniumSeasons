package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class EbayDropDownTesting {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();

		driver.get("https://www.ebay.com/");

		driver.manage().window().maximize();

		driver.findElement(By.id("gh-cat")).sendKeys("MUsic");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("gh-ac")).sendKeys("Harry Potter");
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("gh-search-btn")).click();
		
		Thread.sleep(3000);
		
		System.out.println(driver.getTitle());
		
		driver.quit();
		
	}

}
