package javascriptexecutorandscreenshots;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AssignmentScreenshotTake {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.irctc.co.in/nget/train-search");
        driver.manage().window().maximize();
    }

    @Test
    public void assignmentScreenshotTakeTest() throws IOException, InterruptedException {
        String homeWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[@href='https://www.facebook.com/IRCTCofficial/']")).click();
        Thread.sleep(4000);

        Set<String> allWindows = driver.getWindowHandles();
        for (String tempo : allWindows) {
            driver.switchTo().window(tempo);
            if (driver.getTitle().contains("IRCTC | New Delhi | Facebook")) {
                break;
            }
        }

        // Locate the correct input field
        WebElement fbemail = driver.findElement(By.name("email")); // Fixed locator
        fbemail.sendKeys("sasikumarsake");

        // Highlight the element
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].style.border='5px solid pink'", fbemail);

        // Take Screenshot
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File(System.getProperty("user.dir") + "\\IRCTCFacebook.png"));

        driver.switchTo().window(homeWindow);
        Thread.sleep(4000);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
