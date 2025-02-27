package dropdowntesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo3 {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		//WebElement drop=driver.findElement(By.id("searchDropdownBox"));
		
		//new Select(driver.findElement(By.id("searchDropdownBox"))).selectByIndex(12);
		 //new Select(driver.findElement(By.id("searchDropdownBox"))).selectByValue("search-alias=digital-music");
		 new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Music");
		 
		Thread.sleep(3000);
		
		driver.quit();
		
	}
}
