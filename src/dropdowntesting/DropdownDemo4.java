package dropdowntesting;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo4 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");

		driver.manage().window().maximize();

		WebElement dropDownList = driver.findElement(By.id("searchDropdownBox"));

		List<WebElement> options = dropDownList.findElements(By.tagName("option"));
		
		System.out.println("Using For Each Loop");
		for (WebElement temp : options) {
			System.out.println(temp.getText());
		}

		System.out.println("Using Iterator");

		Iterator<WebElement> tempo = options.iterator();
		while (tempo.hasNext()) {
			System.out.println(tempo.next().getText());
		}
		driver.quit();

	}
}
