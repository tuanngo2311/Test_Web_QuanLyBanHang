package fpoly;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class testLogin_insert {
	public WebDriver driver;
	public UIMap uimap;
	public UIMap datafile;
	public String workingDir;

	HSSFWorkbook workbook;

	HSSFSheet sheet;

	Map<String, Object[]> TestNGResults;
	public static String driverPath = "C:\\Users\\Administrator\\Desktop";
	@Test(description = "Opens the TestNG DEmo Website for login Test", priority = 1)
	public void LaunchWebsite() throws Exception {

		try {
			driver.get("http://localhost:8080/Nhom05_SOF304_ASMM/login.jsp");
			driver.manage().window().maximize();
			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("2", new Object[] { 1d, "Navigate to demo website", "Site gets opened", "Fail" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Fill the Login Details", priority = 2)
	public void FillLoginDetails() throws Exception {

		try {
			WebElement Username = driver.findElement(uimap.getLocator("Username_field"));
			Username.sendKeys(datafile.getData("txtName"));

			WebElement Password = driver.findElement(uimap.getLocator("Password_field"));
			Password.sendKeys(datafile.getData("txtPass"));

			Thread.sleep(1000);

			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (username/password)",
					"Login details gets filled", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { 2d, "Fill Login form data (username/password)",
					"Login details gets filled", "Fail" });
			AssertJUnit.assertTrue(false);
		}
	}

	@Test(description = "Perform Login", priority = 3)
	public void DoLogin() throws Exception {

		try {
			WebElement login = driver.findElement(uimap.getLocator("Login_button"));
			login.click();

			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify welcom message", "Login success", "Pass" });
		} catch (Exception e) {
			TestNGResults.put("4",
					new Object[] { 3d, "Click Login and verify welcom message", "Login success", "Fail" });
			AssertJUnit.assertTrue(false);
		}
	}

	// insert User
	@Test(description = "insertDM", priority = 4)
	public void testinsertUser() throws Exception {
		try {
			driver.findElement(By.name("txtDashboard")).click();
			System.out.println("click-txtDashboard");
			Thread.sleep(3000);
			driver.findElement(By.name("addUser")).click();
			System.out.println("click-addUser");


			WebElement usernamee = driver.findElement(uimap.getLocator("username_us"));
			usernamee.sendKeys(datafile.getData("username"));
			
			WebElement passwordd= driver.findElement(uimap.getLocator("password_us"));
			passwordd.sendKeys(datafile.getData("password"));
			
			WebElement fullnamee = driver.findElement(uimap.getLocator("fullname_us"));
			fullnamee.sendKeys(datafile.getData("fullname"));
			
			WebElement emaill = driver.findElement(uimap.getLocator("email_us"));
			emaill.sendKeys(datafile.getData("email"));
			
			WebElement phonee = driver.findElement(uimap.getLocator("phone_us"));
			phonee.sendKeys(datafile.getData("phone"));
			
			driver.findElement(By.xpath("//input[@value='0']")).click();
			
			WebElement insertt = driver.findElement(uimap.getLocator("insert_us"));
			insertt.click();
			
			TestNGResults.put("6", new Object[] { 4d, "Insert DM form data", "Insert details gets filled", "Pass" });

		} catch (Exception e) {
			TestNGResults.put("6", new Object[] { 4d, "Insert DM form data", "Insert details gets filled", "Fail" });
			AssertJUnit.assertTrue(false);
		}
	}

	@BeforeClass(alwaysRun = true)
	public void suiteSetUp() {
		workbook = new HSSFWorkbook();

		sheet = workbook.createSheet("TestNG Result Summary");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		TestNGResults.put("1", new Object[] { "STT", "Hành Động", "Kết quả mong đợi  ", "Kết quả thực tế" });

		try {
			workingDir = System.getProperty("user.dir");
			datafile = new UIMap(workingDir + "\\Resources\\datafile.properties");

			uimap = new UIMap(workingDir + "\\Resources\\locator.properties");

			System.setProperty("webdriver.chrome.driver", "D:\\FPT Politechnic\\kiểm thử nâng cao\\TaiNguyen\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		} catch (Exception e) {
			throw new IllegalStateException("Can't start the Firefox Web Driver", e);
		}

	}

	@AfterClass
	public void suiteTearDown() {
		Set<String> keyset = TestNGResults.keySet();
		int rownum = 0;
		for (String key : keyset) {
			Row row = sheet.createRow(rownum++);
			Object[] objArr = TestNGResults.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}
		}
		try {
			FileOutputStream out = new FileOutputStream(new File("SaveTestNGResultToExcel.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfully saved Selenium WebDriver TestNG result to Excel File");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
