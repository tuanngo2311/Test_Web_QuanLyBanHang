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
import org.testng.annotations.Test;

public class loginTestNG {
	WebDriver driver;

	String appURL = "http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp";
	String currentUsersDir = System.getProperty("user.dir");
	String path = "D:\\FPT Politechnic\\kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe";

	public loginTestNG() {
	}

	@BeforeClass
	public void setUpClass() {
		System.out.println("@BeforeClass");
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", path);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
//		driver.get(appURL);
	}

	@AfterClass
	public void tearDownClass() {
		System.out.println("@AfterClass");
//		driver.close();
	}

	@BeforeMethod
	public void setUpMethod() throws Exception {
		System.out.println("@BeforeMethod");
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		System.out.println("@AfterMethod");
	}

	/////// ******login*******//////////////
    @Test(description = "", priority = 1)//don't enter login information 
    public void TestLoginNotInformation() throws Exception{
		 System.out.println("@Test");
		 driver.navigate().to(appURL);
			Thread.sleep(1200);
			driver.findElement(By.name("txtName")).sendKeys("");
			
			Thread.sleep(1200);
			driver.findElement(By.name("txtPass")).sendKeys("");
			
			Thread.sleep(3000);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(3000);
			
    		String curURL= driver.getCurrentUrl();
	        String expectedTitle = "Nhom04 - Login or Logout";
	        String actualTitle = driver.getTitle();
          Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp"));
	}

    @Test(description = "", priority = 2)//Enter incorrect login information
    public void TestLoginFail() throws Exception{
		 System.out.println("@Test");
		 driver.navigate().to(appURL);
			Thread.sleep(1200);
			driver.findElement(By.name("txtName")).sendKeys("userNew");
			
			Thread.sleep(1200);
			driver.findElement(By.name("txtPass")).sendKeys("userNew");
			
			Thread.sleep(3000);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(3000);
			
		    String curURL= driver.getCurrentUrl();
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp"));
	}

	@Test(description = "", priority = 3)// test page customer (0)
	public void testCustomerLoginFaill() throws Exception{
		try {
			driver.navigate().to(appURL);
			Thread.sleep(1200);
			driver.findElement(By.name("txtName")).sendKeys("tuannhanvien1");
			
			Thread.sleep(1200);
			driver.findElement(By.name("txtPass")).sendKeys("123");
			
			Thread.sleep(3000);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(3000);
			
			String curURL= driver.getCurrentUrl();
			String expectedTitle = "Index khách hàng";
			String actualTitle = driver.getTitle();
		    Assert.assertEquals(expectedTitle, actualTitle);
		    assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/indexKH.jsp"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "", priority = 4)// test page customer (0)
	public void testCustomerLoginSuccess() throws Exception{
		try {
			driver.navigate().to(appURL);
			Thread.sleep(1200);
			driver.findElement(By.name("txtName")).sendKeys("tuannhanvien");
			
			Thread.sleep(1200);
			driver.findElement(By.name("txtPass")).sendKeys("1");
			
			Thread.sleep(3000);
			driver.findElement(By.name("btnLogin")).click();
			Thread.sleep(3000);
			
			String curURL= driver.getCurrentUrl();
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/indexKH.jsp"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}

	@Test(description = "", priority = 5)// test page admin (1) ok
	public void testAdminLoginFail() throws Exception {
		driver.navigate().to(appURL);
		Thread.sleep(1200);
		driver.findElement(By.name("txtName")).sendKeys("tuan");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("tuan123");
		
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
		
		String curURL= driver.getCurrentUrl();
		String expectedTitle = "Index Admin";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/dashboard.jsp"));
	}

	@Test(description = "", priority = 6)// test page admin (1)
	public void testAdminLoginSuccess() throws Exception {
		driver.navigate().to(appURL);
		Thread.sleep(1200);
		driver.findElement(By.name("txtName")).sendKeys("tuan");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("tuan");
		
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
		
		String curURL= driver.getCurrentUrl();
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/dashboard.jsp"));
	}

	@Test(description = "", priority = 7)// test page admin (1) ok
	public void testAdminLogoutSuccess() throws Exception {
		driver.navigate().to(appURL);
		Thread.sleep(1200);
		driver.findElement(By.name("txtName")).sendKeys("tuan");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("tuan");
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("txtLogout")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("logoutAD")).click();
		Thread.sleep(3000);
		
		String curURL= driver.getCurrentUrl();
		String expectedTitle = "Nhom04 - Login or Logout";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp"));	
	}

	@Test(description = "", priority = 8)// test page Customer (0) ok
	public void testCustomerLogoutSuccess() throws Exception {
		driver.navigate().to(appURL);
		Thread.sleep(1200);
		driver.findElement(By.name("txtName")).sendKeys("tuannhanvien");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("1");
		Thread.sleep(3000);
		driver.findElement(By.name("btnLogin")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("logoutKH")).click();
		Thread.sleep(3000);
		
		String curURL= driver.getCurrentUrl();
		String expectedTitle = "Nhom04 - Login or Logout";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp"));	
	}

	@Test(description = "", priority = 9)// do not get the old link to import ok
	public void testOldLinkToImportSuccess() throws Exception {
		Thread.sleep(3000);
		driver.navigate().to("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_user.jsp");
		Thread.sleep(3000);
		String curURL= driver.getCurrentUrl();
		String expectedTitle = "Nhom04 - Login or Logout";
		String actualTitle = driver.getTitle();
	    Assert.assertEquals(expectedTitle, actualTitle);
		assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp"));	
	}
}
