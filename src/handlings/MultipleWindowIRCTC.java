package handlings;

import java.util.Set;

import javax.swing.event.SwingPropertyChangeSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MultipleWindowIRCTC {

	WebDriver driver;
	WebDriverWait wait;
	String irctcURL = "https://www.irctc.co.in/nget/train-search";

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.get(irctcURL);
		driver.manage().window().maximize();
	}

	@Test
	public void multiupleWindowHandlingIRCTCTest() throws InterruptedException {
		String homeWindowHandle = driver.getWindowHandle();

		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();

		switchToWindow("IRCTC | New Delhi  | Facebook");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the whastapp
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial whatsapp']")).click();

		switchToWindow("IRCTC Official | WhatsApp Channel");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the youtube
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial youtube']")).click();

		switchToWindow("(45) IRCTC OFFICIAL - YouTube");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Instragram
		driver.findElement(By.xpath("//a[@href='https://instagram.com/irctc.official?igshid=yyg5byow704l']")).click();

		switchToWindow("Login • Instagram");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Linkedin
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial linkedin']")).click();

		switchToWindow("(24) IRCTC OFFICIAL: Overview | LinkedIn");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Linkedin
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial telegram']")).click();

		switchToWindow("Telegram: Contact @IRCTC_Official");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Linkedin
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial pinterest']")).click();

		switchToWindow("Pinterest ct");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Linkedin
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial tumblr']")).click();

		switchToWindow("@irctcofficial on Tumblr");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

		// click on the Linkedin
		driver.findElement(By.xpath("//a[@alt='IRCTCofficial twitter']")).click();

		switchToWindow("Sign In - Google Accounts");
		Thread.sleep(3000);
		// Switch back to home window
		driver.switchTo().window(homeWindowHandle);

	}

	private void switchToWindow(String expectedTitle) throws InterruptedException{
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			driver.switchTo().window(window);
			if (driver.getTitle().contains(expectedTitle)) {
				Thread.sleep(3000);
				System.out.println("Switched to window: " + expectedTitle);
				break;
			}
		}

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
