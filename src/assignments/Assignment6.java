package assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment6 {

	public static void main(String[] args) throws InterruptedException{

		/*
		 * Assignment : 6
		 * in https://adactinhotelapp.com/
		 * write the scripts to input registration data from Two Dimensiinal array
		 * after entering the data click register and navigate back
		 * send the code/screenshot to below email id flmtechteam.testing@gmail.com
		 */
		WebDriver driver=new ChromeDriver();

		driver.get("https://adactinhotelapp.com/");
		driver.manage().window().maximize();

		driver.findElement(By.linkText("New User Register Here")).click();

		Thread.sleep(3000);

		String[][] adactinHotelApp = new String[1][6];

		System.out.println(adactinHotelApp.length);

		for(int i=0;i<adactinHotelApp.length;i++) {

			for(int j=0;j<adactinHotelApp[i].length;j++)
			{
				System.out.print(adactinHotelApp[i][j]+"\t");
			}
			System.out.println();
		}

		String Username=adactinHotelApp[0][0]="Sasikumar";
		String Password=adactinHotelApp[0][1]="Sasi@123";
		String ConfirmPassword=adactinHotelApp[0][2]="Sasi@123";
		String FullName=adactinHotelApp[0][3]="SasikumarSIVA";
		String EmailAddress=adactinHotelApp[0][4]="Sasikumar@gmail.com";

		driver.findElement(By.id("username")).sendKeys(Username);
		driver.findElement(By.id("password")).sendKeys(Password);
		driver.findElement(By.id("re_password")).sendKeys(ConfirmPassword);
		driver.findElement(By.id("full_name")).sendKeys(FullName);
		driver.findElement(By.id("email_add")).sendKeys(EmailAddress);
		
		driver.findElement(By.id("Submit")).click();
		
		Thread.sleep(3000);
		
		for(int i=0;i<adactinHotelApp.length;i++) {

			for(int j=0;j<adactinHotelApp[i].length;j++)
			{
				System.out.print(adactinHotelApp[i][j]+"\t");
			}
			System.out.println();
		}
		
		driver.navigate().back();
		
		Thread.sleep(4000);
		
		driver.quit();

	}

}
