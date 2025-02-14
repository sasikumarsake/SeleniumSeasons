package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverMethods1 {

	public static void main(String[] args) throws InterruptedException {

		//default constructor
		//browser start
		WebDriver driver=	new ChromeDriver();
		
		Thread.sleep(3000);
		
		//get method
		driver.get("https://www.facebook.com/");
		
		Thread.sleep(3000);
		
		//close
		//driver.close();
		
		//quit
		driver.quit();
	}

}
