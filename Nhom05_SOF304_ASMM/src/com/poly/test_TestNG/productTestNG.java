package com.poly.test_TestNG;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class productTestNG {
	WebDriver driver;
	String appURL = "http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp";
	String currentUsersDir = System.getProperty("user.dir");
	String path = "D:\\FPT Politechnic\\kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe";

	public productTestNG() {
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
//		driver.close();
	}

	@AfterMethod
	public void tearDownMethod() throws Exception {
		System.out.println("@AfterMethod");
	}

	@Test(description = "", priority = 1) // test InsertProduct page admin
	public void testInsertProductAdminSuccess() throws Exception {
		try {
			driver.findElement(By.name("addProduct")).click();

			Thread.sleep(3000);
			WebElement uploadElement = driver.findElement(By.id("btnUploadfile"));
			uploadElement.sendKeys("C:\\Users\\Administrator\\Desktop\\Nhom05_SOF304_Assignment\\Nhom05_SOF304_ASMM\\WebContent\\images\\ip12.jpg");
			driver.findElement(By.id("sendUploadfile_file")).click();

			Thread.sleep(3000);
			driver.findElement(By.name("name")).sendKeys("Iphone 12 pro");

			Thread.sleep(3000);
			driver.findElement(By.name("price")).sendKeys("28490000");

			Thread.sleep(3000);
			driver.findElement(By.name("note")).sendKeys("Chinh Hang (NV/A)");

			Thread.sleep(3000);
			Select drpCountry = new Select(driver.findElement(By.id("selectID")));
			drpCountry.selectByVisibleText("Dien Thoai");

			Thread.sleep(3000);
			WebElement click = driver.findElement(By.xpath("//*[@id='insertProduct']"));
			click.click();
			String curURL = driver.getCurrentUrl();
			String expectedTitle = "Show product";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_product.jsp"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test(description = "", priority = 2) // test update product  admin
	public void testUpdateProductAdminSuccess() throws Exception {
		try {
			driver.findElement(By.name("showProduct")).click();

			Thread.sleep(3000);
			driver.findElement(By.id("update_product")).click();

			Thread.sleep(3000);
			driver.findElement(By.name("name")).clear();
			driver.findElement(By.name("name")).sendKeys("Tu Lanh SHARP");

			Thread.sleep(3000);
			driver.findElement(By.name("price")).clear();
			driver.findElement(By.name("price")).sendKeys("5190000");

			Thread.sleep(3000);
			driver.findElement(By.name("note")).clear();
			driver.findElement(By.name("note")).sendKeys("Thai Lan");

			Thread.sleep(3000);
			Select drpCountry = new Select(driver.findElement(By.id("selectID")));
			drpCountry.selectByVisibleText("Tu Lanh");

			Thread.sleep(3000);
			driver.findElement(By.id("EXE_UPDATE_product")).click();
			
			String curURL = driver.getCurrentUrl();
			String expectedTitle = "Show product";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_product.jsp"));

			System.out.println("tc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(description = "", priority = 3) // test delete product trang admin ->0k
	public void testdeleteProductAdminSuccess() throws Exception {
		try {
			driver.findElement(By.name("showProduct")).click();

			Thread.sleep(3000);
			driver.findElement(By.id("delete_product")).click();// delete product á»Ÿ Ä‘áº§u table
			String curURL = driver.getCurrentUrl();
			String expectedTitle = "Show product";
			String actualTitle = driver.getTitle();
			Assert.assertEquals(expectedTitle, actualTitle);
			assertTrue(curURL.equals("http://localhost:8080/Nhom05_SOF304_ASMM/tables/show_product.jsp"));

			System.out.println("tc");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
