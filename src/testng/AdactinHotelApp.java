package testng;

import org.testng.annotations.Test;

public class AdactinHotelApp {
	
	@Test
	public void loginTest()
	{
		System.out.println("Browser Stsrted..");
		System.out.println("App Launched..");
		System.out.println("Login Successfull.");
		System.out.println("Browser Closed..");
	}
	
//	@Test(priority = 3,enabled = false)
//	public void registrationTest()
//	{
//		System.out.println("Browser Stsrted..");
//		System.out.println("App Launched..");
//		System.out.println("Registration Successfull.");
//		System.out.println("Browser Closed..");
//	}
	@Test(priority = 1,enabled=false)
	public void registrationTest()
	{
		System.out.println("Browser Stsrted..");
		System.out.println("App Launched..");
		System.out.println("Registration Successfull.");
		System.out.println("Browser Closed..");
	}
	@Test(priority = 1)
	public void abcTest()
	{
		System.out.println("Browser Stsrted..");
		System.out.println("App Launched..");
		System.out.println("abc Successfull.");
		System.out.println("Browser Closed..");
	}
	
	@Test(dependsOnMethods="registrationTest")
	public void changePasswordTest()
	{
		System.out.println("Browser Stsrted..");
		System.out.println("App Launched..");
		System.out.println("changePassword Successfull.");
		System.out.println("Browser Closed..");
	}

}
