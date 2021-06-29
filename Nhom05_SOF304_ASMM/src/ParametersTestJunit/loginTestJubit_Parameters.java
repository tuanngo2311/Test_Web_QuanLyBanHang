package ParametersTestJunit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import com.poly.dao.UserDao;
import com.poly.models.User;

@RunWith(value = Parameterized.class)
public class loginTestJubit_Parameters {

	UserDao usDao = new UserDao();

	private String user;
	private String pass;

	public loginTestJubit_Parameters(String user, String pass) {
		super();
		this.user = user;
		this.pass = pass;
	}

	@Parameterized.Parameters
	public static Collection data() {
		Object[][] data = new Object[][] { 
			{ "tuan", "" }, 
			{ "", "tuan" }, 
			{ "tuan", "tuan1" },
			{ "tuan1", "1" }, 
			{ "tuan1", "tuan1" }, 
			{ "tuan", "1" },

			{ "tuannhanvien", "" }, 
			{ "", "tuannhanvien" }, 
			{ "tuannhanvien", "tuannhanvien123" },
			{ "tuannhanvien1", "1" }, 
			{ "tuannhanvien1", "tuannhanvien1" }, 
			{ "tuannhanvien", "1" }, };
		return Arrays.asList(data);
	}

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Test
	public void testAdminLoginFaill() {
		try {
			boolean expected = true;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test // test Login faill to the customer page
	public void testCustomerLoginFaill() {
		try {
			boolean expected = true;
			boolean result = UserDao.checkkLogin(user, pass);
			assertEquals(expected, result);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test
	public void testFindByName() {
		try {
			System.out.println("testFindByName");
			List<User> list = usDao.fillAll();
			User expected = usDao.findByName(user);

			assertEquals(expected.getUsername(), user);
			assertTrue(list != null);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}
}
