package com.poly.test_Junit;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;

import com.poly.dao.UserDao;
import com.poly.models.User;
import java.util.List;

public class loginTestJunit {
	UserDao usDao = new UserDao();

	public loginTestJunit() {
	}

	@BeforeClass
	public static void setUpClass() {
		System.out.println("@BeforeClass");
	}

	@AfterClass
	public static void tearDownClass() {
		System.out.println("@AfterClass");
	}

	@Before
	public void setUp() {
		System.out.println("@Before ");
	}

	@After 
	public void tearDown() throws Exception {
		System.out.println("@After ");
	}

	//////////////// **************login************///////////////////////

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test() // test Login successfully to the Admin page
	public void testAdminLoginSuccess() {
		System.out.println("testLoginAdminSuccess");
		try {
			String user = "tuan";
			String pass = "tuan";
			boolean expected = true;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test // test Login faill to the Admin page
	public void testAdminLoginFail() {
		System.out.println("testAdminLoginFail");
		collector.addError(new Throwable("User Invaliad admin"));
		try {
			String user = "usernew";
			String pass = "usernew";
			boolean expected = false;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);

		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test // test Login successfully to the customer page
	public void testCustomerLoginSuccess() {
		System.out.println("testLoginCustomerSuccess");
		try {
			String user = "tuannhanvien";
			String pass = "1";
			boolean expected = true;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test // test Login faill to the customer page
	public void testCustomerLoginFaill() {
		System.out.println("testLoginCustomerSuccess");
		collector.addError(new Throwable("User Invaliad customer"));
		try {
			String user = "tuannhanvien1";
			String pass = "tuannhanvien123";
			boolean expected = true;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);
		} catch (Throwable e) {
			collector.addError(e);
		}

	}

	@Test // test Login fail
	public void testAdminLoginFaill() {
		System.out.println("testLoginFaill");
		assertFalse(UserDao.checkkLogin("tuan", ""));
		assertFalse(UserDao.checkkLogin("", "tuan"));
		assertFalse(UserDao.checkkLogin("tuan", "tuan1"));
		assertFalse(UserDao.checkkLogin("tuan1", "tuan"));
		assertFalse(UserDao.checkkLogin("tuan1", "tuan1"));
	}
	
	@Test // test FindByName
	public void testFindByName() {
		System.out.println("testFindByName");
		List<User> list = usDao.fillAll();
		String user = "tuan";
		User expected = usDao.findByName(user);
		
		assertEquals(expected.getUsername(), user);
		assertTrue(list != null);
	}

	@Test // test FindByName
	public void testFindByNameNull() {
		System.out.println("testFindByName");
		String user = "";
		User expected = null;
		User result = usDao.findByName(user);
		assertEquals(expected, result);
	}
	


}
