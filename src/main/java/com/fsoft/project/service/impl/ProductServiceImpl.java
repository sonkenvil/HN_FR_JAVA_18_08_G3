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

}
