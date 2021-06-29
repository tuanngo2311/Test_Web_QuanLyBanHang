package com.poly.test_TestNG;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.poly.dao.UserDao;
import com.poly.models.User;

public class userTestNG {
	WebDriver driver;
	String appURL = "http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp";
	String currentUsersDir = System.getProperty("user.dir");
	String path = "D:\\FPT Politechnic\\kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe";

	public userTestNG() {
	}

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
		driver.findElement(By.name("txtName")).sendKeys("tuan");
		Thread.sleep(1200);
		driver.findElement(By.name("txtPass")).sendKeys("tuan");

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
		driver.close();
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		System.out.println("@AfterMethod");
	}

	////////////////////// *******user******************/////////////
	
	
	@Test(description = "", priority = 1) // test InsertUser page admin
	public void testInsertUserAdminSuccess() throws Exception {
		try {
			driver.findElement(By.name("addUser")).click();
			System.out.println("click-addUser");
			Thread.sleep(3000);
			driver.findElement(By.name("username")).sendKeys("Thu Thao");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).sendKeys("nguyenthuthao");
			Thread.sleep(3000);
			driver.findElement(By.name("fullname")).sendKeys("Nguyen Thu Thao");
			Thread.sleep(3000);
			driver.findElement(By.name("email")).sendKeys("thaont@gmail.com");
			Thread.sleep(3000);
			driver.findElement(By.name("phone")).sendKeys("0985678652");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value='0']")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("_type")).click();
			Thread.sleep(3000);
    		String curURL= driver.getCurrentUrl();
	        String expectedTitle = "Show user";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_user.jsp"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(description = "", priority = 2) // test updateUser page admin->ok
	public void testUpdateUserAdminSuccess() throws Exception {
		try {	
			driver.findElement(By.name("showUser")).click();	
			Thread.sleep(3000);
			driver.findElement(By.id("update_user")).click();
			Thread.sleep(3000);
			driver.findElement(By.name("username")).clear();
			driver.findElement(By.name("username")).sendKeys("lananhUp");
			Thread.sleep(3000);
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys("nguyenlananhUp");
			Thread.sleep(3000);
			driver.findElement(By.name("fullname")).clear();
			driver.findElement(By.name("fullname")).sendKeys("Nguyen Lan Anh Up");
			Thread.sleep(3000);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys("anhnlupdate@gmail.com");
			Thread.sleep(3000);
			driver.findElement(By.name("phone")).clear();
			driver.findElement(By.name("phone")).sendKeys("0999912398");
			Thread.sleep(3000);
			driver.findElement(By.xpath("//input[@value='0']")).click();
			Thread.sleep(3000);
			driver.findElement(By.id("EXE_UPDATE_user")).click();
			Thread.sleep(3000);
    		String curURL= driver.getCurrentUrl();
	        String expectedTitle = "Show user";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_user.jsp"));
			
			System.out.println("tc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "", priority = 3) // test deleteUser page admin ->ok
	public void testdeleteUserAdminSuccess() throws Exception {
		try {
			driver.findElement(By.name("showUser")).click();
			
			Thread.sleep(3000);
			driver.findElement(By.id("delete_user")).click();// delete user á»Ÿ Ä‘áº§u table
			Thread.sleep(3000);
			
    		String curURL= driver.getCurrentUrl();
	        String expectedTitle = "Show user";
	        String actualTitle = driver.getTitle();
	        Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_user.jsp"));
			
			System.out.println("tc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
