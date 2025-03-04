package linkstesting;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkesTestingDemo3 {

	public static void main(String[] args) throws InterruptedException {


		WebDriver driver=new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
		driver.manage().window().maximize();

		List<WebElement> AllLinks= driver.findElements(By.tagName("a"));

		System.out.println(AllLinks.size());

		for(int i=0;i<AllLinks.size();i++)
		{
			System.out.println(AllLinks.get(i).getText());
			AllLinks.get(i).click();
			Thread.sleep(3000);
			System.out.println(driver.getCurrentUrl());
			System.out.println("---------------------");
			driver.navigate().back();
		}
		driver.quit();
	}

}
