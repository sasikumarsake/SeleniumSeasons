package chromeopenwithswitchifelse;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.remote.Browser;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOpen_SwitchStatement {

	public static void main(String[] args) {


		System.out.println("Opening Browser");
		Scanner s1=	new Scanner(System.in);
		String callBrowser=s1.next();

		WebDriver driver = null;

		switch (callBrowser) {
		case "chrome":
			//WebDriverManager.chromedriver();
			driver = new ChromeDriver();
			System.out.println("Launched Chrome using switch-case.");
			break;
		case "firefox":
			//WebDriverManager.firefoxdriver();
			driver = new FirefoxDriver();
			System.out.println("Launched Firefox using switch-case.");
			break;
		case "edge":
			//WebDriverManager.edgedriver();
			driver = new EdgeDriver();
			System.out.println("Launched Edge using switch-case.");
			break;
		default:
			System.out.println("Invalid browser name!");
			System.exit(0);
		}
		
		//Suggested by ChatGPT
		// Close the scanner to prevent resource leak
		s1.close();
		
		//Suggested by ChatGPT
		// Perform any operations with the driver if needed
		if (driver != null) {
			driver.get("https://motherson.workvivo.com/"); // Open Google as an example
			driver.quit();
		}

	}
}
