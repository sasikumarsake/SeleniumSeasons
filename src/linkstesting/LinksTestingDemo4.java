package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LinksTestingDemo4 {
	public static void main(String[] args) throws InterruptedException {

WebDriver driver= new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000);
		
		//Collecting the links through the webelement store
		
		WebElement block=driver.findElement(By.xpath("//div[text()='Make Money with Us']/parent::div"));
		
		List<WebElement> allLinks=block.findElements(By.tagName("a"));
		
		for(int i=0;i<allLinks.size();i++)
		{
			System.out.println(allLinks.get(i).getText());
			allLinks.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			Thread.sleep(2000);
			driver.navigate().back();
			Thread.sleep(2000);
			
			
		}
		
		
		driver.quit();
	}

}
