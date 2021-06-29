package com.poly.test_TestNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameters_insertUser {
	WebDriver driver;
	String appURL = "http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp";
//		String currentUsersDir = System.getProperty("user.dir");
	String path = "D:\\FPT Politechnic\\kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe";

	@BeforeClass
	public void setUpClass() {
		System.out.println("@BeforeClass");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(appURL);
	}

	@BeforeMethod
	public void setUpMethod() throws Exception {
		System.out.println("@BeforeMethod");
		driver.navigate().to(appURL);
		Thread.sleep(1200);
		driver.findElement(By.name("txtName")).sendKeys("caokhai");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("caokhai");

		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		System.out.println("click-btnLogin");
		Thread.sleep(3000);

		driver.findElement(By.name("txtDashboard")).click();
		System.out.println("click-txtDashboard");
		Thread.sleep(3000);
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("@AfterClass");
//			driver.close();
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		System.out.println("@AfterMethod");
	}

	@Parameters({ "username", "password", "fullname", "email", "phone" })
	@Test(description = "", priority = 1) // test addUser page admin ->ok
	public void testInsertserAdminSuccess_pr(String username, String password, String fullname, String email,
			String phone) throws Exception {

		driver.findElement(By.name("addUser")).click();
		System.out.println("click-addUser");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='username']")).sendKeys(username);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='password']")).sendKeys(password);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='fullname']")).sendKeys(fullname);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='email']")).sendKeys(email);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@name='phone']")).sendKeys(phone);

		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@value='0']")).click();

		Thread.sleep(3000);
		driver.findElement(By.name("_type")).click();
		
		String curURL= driver.getCurrentUrl();
        String expectedTitle = "Show user";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_user.jsp"));
	}

}
