/**
 * 
 */
package com.fsoft.project.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.ProductDao;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;

/**
 * @author hungcoutinho
 *
 */
public class ProductServiceImpl implements ProductService {

	private ProductDao productDao;

	public ProductServiceImpl(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getListNewProduct() throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getListNewProduct();
	}

	@Override
	public List<Product> getListProduct(int n) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getListProduct(n);
	}

	@Override
	public int getTotalProduct() throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getTotalProduct();
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getProductById(id);
	}

	@Override
	public List<Product> getListProductByValue(String val) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getListProductByValue(val);
	}

	@Override
	public int addProduct(Product product) throws SQLException {
		return productDao.addProduct(product);
	}

	@Override
	public List<Product> allProduct() throws SQLException {
		
		return productDao.allProduct();
	}

	@Override
	public int updateProduct(Product product) throws SQLException, Exception {
		
		return productDao.updateProduct(product);
	}

	@Override
	public Product fetchProduct(int id) throws SQLException {
		
		return productDao.fetchProduct(id);
	}

	@Override
	public int deleteProduct(int id) throws SQLException, Exception {
		
		return productDao.deleteProduct(id);
	}

	

	

}
