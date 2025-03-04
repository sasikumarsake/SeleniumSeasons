package linkstesting;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkesTestingDemo2 {

	public static void main(String[] args) throws InterruptedException {

		
	WebDriver driver=new ChromeDriver();
	driver.get("https://adactinhotelapp.com/");
	driver.manage().window().maximize();
	
	//collect all links in the home page
	List<WebElement> allLinkesInHomePage=driver.findElements(By.tagName("a"));
	
	System.out.println(allLinkesInHomePage.size());
	
	//using for each loop
	System.out.println("Using the For each Loop..!");
	for(WebElement temp : allLinkesInHomePage)
	{
		System.out.println(temp.getText());
	}
	
	
	//using for loop
	
	System.out.println("Using the For Loop..!");
	for (int i=0;i<allLinkesInHomePage.size();i++)
	{
		System.out.println(allLinkesInHomePage.get(i).getText());
	}
	
		driver.quit();

	}

}
