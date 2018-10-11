package com.fsoft.project;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;

import junit.framework.TestCase;

/**
 * @author hungcoutinho
 *
 */
public class TestProductService extends TestCase{
/*
	@Test
	public void testGetListNewProduct() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListNewProduct();
		assertTrue(listP.size() == 5);
	}

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
	
	@Test
	public void testGetProductByValue() throws SQLException {
		ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
		List<Product> listP = productService.getListProductByValue("x");
		assertTrue(listP != null);
	}
}
