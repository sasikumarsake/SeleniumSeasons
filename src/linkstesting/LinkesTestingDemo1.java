package linkstesting;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class LinkesTestingDemo1 {

	public static void main(String[] args) throws InterruptedException {
		
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://adactinhotelapp.com/");
	
	driver.manage().window().maximize();
	
	System.out.println(driver.findElement(By.linkText("Forgot Password?")).isDisplayed());
	
	driver.findElement(By.linkText("Forgot Password?")).click();
	
	System.out.println(driver.getTitle());
	
	Thread.sleep(3000);
	
	System.out.println(driver.findElement(By.linkText("Go back to Login page")).isDisplayed());
	
	driver.findElement(By.linkText("Go back to Login page")).click();
	
	System.out.println(driver.getTitle());
	
	Thread.sleep(3000);
	
	driver.quit();

	}

}
