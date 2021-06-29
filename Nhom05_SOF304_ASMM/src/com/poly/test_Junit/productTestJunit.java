package com.poly.test_Junit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import com.poly.dao.ProductDao;
import com.poly.models.Product;
import com.poly.models.User;

public class productTestJunit {
	ProductDao prdao = new ProductDao();

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

	//////////////// **************product************///////////////////////
	@Test // test insert new Product
	public void testInsertNewProductSuccess() {
		System.out.println("test addNewProductSuccess");
		prdao.addNewProduct("Iphone12", 12000, "Apple", "iphone12.jpg", 1);
		Product newProduct = prdao.findByName("Iphone12");
		assertEquals(newProduct.getName(), "Iphone12");
	}

	@Test // test Updated ProductID
	public void testUpdateProductNameIDSuccess() {
		System.out.println("test updateProductNameSuccess");
		prdao.findById(23);
		prdao.updateNewProduct("Iphone12Up", 22000, "Applee", "iphone12.jpg", 1);
		Product productUpdate = prdao.findById(23);
		assertEquals(productUpdate.getName(), "Iphone12Up");
	}

	@Test // test delete productID
	public void deleteProductIDSuccess() {
		System.out.println("test deleteProductIDSuccess");
		int idproduct = 31;
		boolean expected = true;
		boolean result = prdao.deleteProduct(idproduct);
		assertEquals(expected, result);
	}

	@Test // test find Product by name
	public void testFindUserByProductName() {
		System.out.println("testfindUserByProductName");
		String name = "laptop";
		Product product = prdao.findByName(name);
		assertTrue(product != null);
	}

	@Test // test see all product
	public void testProductFillAll() {
		System.out.println("test productFillAll");
		List<Product> list = prdao.fillAll();
		assertTrue(list != null);
	}

	@Test
	public void addProductFaill() {

		try {
			Product product = new Product();
			product.setName(null);
			product.setPrice(12000);
			product.setNote("Chinh Hang!**");
			prdao.insertProduct(product);

		} catch (Exception e) {
			fail("Product không được để trống");
		}
	}

	@Test
	public void updateUserFaill() {
		Product product = prdao.findById(1);
		try {
			product.setName("vanteonew");
			product.setPrice(12000);
			product.setNote("Chinh Hang!**");
			prdao.updateProduct(product);

		} catch (Exception e) {
			fail("update không hợp lệ");
		}
	}
}
