package com.poly.test_Junit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.poly.dao.UserDao;
import com.poly.models.Product;
import com.poly.models.User;

public class userTestJunit {
	UserDao userDAO = new UserDao();

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

	//////////////// **************user************///////////////////////

	@Test // test insert new User
	public void testInsertNewUserSuccess() {
		System.out.println("test addNewUserSuccess");
		userDAO.insertNewUser("vantoan", "vantoan1", "cao van toan", "toanvc@gmail.com", "0123456789", 0);
		User newUser = userDAO.findByName("vantoan");
		assertEquals(newUser.getUsername(), "vantoan");
	}

	@Test // test Updated UserID
	public void updateUserNameIDSuccess() {
		System.out.println("test updateUserNameSuccess");
		userDAO.findById(33);
		userDAO.updateNewUser("vantoanupdate", "vantoanupdate", "vantoanupdate", "toanvc@gmail.com", "0123456789", 0);

		User userUpdate = userDAO.findById(33);
		assertEquals(userUpdate.getUsername(), "vantoanupdate");
	}
	
	@Test // test Updated UserID->faill
	public void updateUserNameIDFaill() {
		System.out.println("test updateProductNameSuccess");
		userDAO.findById(238);
		userDAO.updateNewUser("vantoanupdate", "vantoanupdate", "vantoanupdate", "toanvc@gmail.com", "0123456789", 0);
		User userUpdate = userDAO.findById(238);
		assertEquals(userUpdate.getUsername(), "vantoanupdate");
	}

	@Test // test delete UserID
	public void deleteUserIDSuccess() {
		System.out.println("test deleteUserIDSuccess");
		int iduser = 31;
		boolean expected = true;
		boolean result = userDAO.deleteUser(iduser);
		assertEquals(expected, result);
	}

	@Test // test find User by name Success
	public void testfindUserByUserNameSuccess() {
		System.out.println("test findUserByUserNameSuccess");
		String user = "tuan";
		User userr = userDAO.findByName(user);
		assertTrue(userr != null);
	}

	@Test // test see all users
	public void testFillAll() {
		System.out.println("test FillAll");
		List<User> list = userDAO.fillAll();
		assertTrue(list != null);
	}
	
	@Test
	public void addUserFaill() {
		User user = new User();
		user.setUsername(null);
		user.setPassword("1234567");
		try {
			userDAO.insertUser(user);
			
		} catch (Exception e) {
			fail("User không được để trống");
		}	
	}
	
	@Test
	public void updateUserFaill() {
		 User user = userDAO.findById(1);
		try {
			user.setUsername("vanteonew");
			user.setPassword("1234567");
			user.setFullname(" teo@123!.");
			userDAO.updateUser(user);
			
		} catch (Exception e) {
			fail("update không hợp lệ");
		}	
	}
}