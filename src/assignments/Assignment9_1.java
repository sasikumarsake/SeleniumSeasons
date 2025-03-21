package assignments;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class Assignment9_1 {
    
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/V4/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void alertsTest() {
        login("mngr589366", "yjahunA");
        deleteAccount("1234567890");
    }

    private void login(String userId, String password) {
        driver.findElement(By.name("uid")).sendKeys(userId);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.name("btnLogin")).click();
    }

    private void deleteAccount(String accountNumber) {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Delete Account"))).click();
        driver.findElement(By.name("accountno")).sendKeys(accountNumber);
        driver.findElement(By.name("AccSubmit")).click();

        // Handle first alert
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alert.getText(), "Do you really want to delete this Account?");
        alert.accept();
        System.out.println("Printed Text is : "+alert.getText());

        // Handle second alert
        alert = wait.until(ExpectedConditions.alertIsPresent());
        assertEquals(alert.getText(), "Account does not exist");
        alert.accept();
        System.out.println("Printed Text is : "+alert.getText());
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
