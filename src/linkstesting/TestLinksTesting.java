package linkstesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestLinksTesting {
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://ultimateqa.com/dummy-automation-websites/#1_SauceDemo_E-Commerce");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println(allLinks.size());
		
		for (WebElement temp : allLinks) {
			System.out.println(temp.getText());
		}
		driver.quit();
	}

}
