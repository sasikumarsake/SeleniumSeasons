package extratopics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesForceShadowDOM {

	
	WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://salesforce.com/in/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper method to expand Shadow DOM
    private WebElement expandShadowRoot(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (WebElement) js.executeScript("return arguments[0].shadowRoot", element);
    }

    @Test
    public void testLoginAndClickSalesforce() {
        // Locate the first shadow host
        WebElement parentShadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("hgf-c360login")));
        WebElement parentShadowRoot = expandShadowRoot(parentShadowHost);

        // Locate the second shadow host inside the first one
        WebElement childShadowHost = parentShadowRoot.findElement(By.cssSelector("hgf-button.utility-button"));
        WebElement childShadowRoot = expandShadowRoot(childShadowHost);

        // Click the Login button
        WebElement loginButton = childShadowRoot.findElement(By.cssSelector("span[slot='source']"));
        loginButton.click();

        // Wait for the login dropdown and click the Salesforce link
        WebElement salesforceLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Salesforce')]")));
        salesforceLink.click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
