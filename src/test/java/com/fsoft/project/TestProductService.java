package com.fsoft.project;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;

import junit.framework.TestCase;

/**
 * @author hungcoutinho
 *
 */
public class TestProductService extends TestCase{

//	@Test
//	public void testGetListNewProduct() throws SQLException {
//		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
//		List<Product> listP = productService.getListNewProduct();
//		assertTrue(listP.size() == 5);
//	}
/*
	@Test
	public void testGetListProduct1() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProduct(0);
		assertTrue(listP.size() == 8);
	}
	
	@Test
	public void testGetListProduct2() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProduct(1);
		assertTrue(listP.size() == 8);
	}
	*/
	/*
	@Test
	public void testGetListProduct3() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProduct(5);
		assertTrue(listP.size() == 5);
	}
	
	@Test
	public void testGetTotalProduct() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		int total = productService.getTotalProduct();
		assertTrue(total == 10);
	}
	
	@Test
	public void testGetProductById() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		Product product = productService.getProductById(1);
		assertTrue(product != null);
	}
	
	*/
	
	/*
	@Test
	public void testGetProductByValue() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProductByValue("i");
		assertTrue(listP.size() > 0);
	}
	*/
	
	@Test
	public void testgetRelatedProduct() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProductRelated(new Product(1, "df", "dsf", new ManuFacturer(1, "dsf", "fgds"), new Category(1,"sdf"), Date.valueOf("2018-09-09"), "df", 10000000, "sdfsdf"));
		for(Product p : listP) {
			System.out.println(p.getId());
		}
		assertTrue(listP.size() == 4);
	}
	
}
