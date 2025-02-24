package chromeopenwithswitchifelse;

import java.util.Scanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class ChromeOpen_IfElseStatement2 {

	public static void main(String[] args) {


		System.out.println("Opening the Browser..!");
        Scanner s1 = new Scanner(System.in);
        System.out.print("Enter browser name (chrome/firefox/edge): ");
        String browser = s1.next();
        s1.close();

        WebDriver driver = null;

        if (browser.equals("chrome")) {
            //WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
           //WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("edge")) {
            //WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser name!");
            
        }

        if (driver != null) {
            driver.get("https://adactinhotelapp.com/"); // Open Google
            System.out.println("Browser launched successfully!");
            driver.quit();
        }


	}

}
