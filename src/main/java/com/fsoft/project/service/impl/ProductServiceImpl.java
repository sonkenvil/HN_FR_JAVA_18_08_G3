/**
 * 
 */
package com.fsoft.project.service.impl;

import java.math.BigDecimal;
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
	public List<Product> getListProductRelated(Product product) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getListProductRelated(product);
	}

	@Override
	public List<Product> selectListProductByValue(int categoryId, String sortName, String sortPrice,
			BigDecimal priceMin, BigDecimal priceMax, int offset, int fetch) throws SQLException {
		// TODO Auto-generated method stub
		return productDao.selectListProductByValue(categoryId, sortName, sortPrice, priceMin, priceMax, offset, fetch);
	}

	@Override
	public int getTotalProductSelectByValue(int categoryId, BigDecimal priceMin, BigDecimal priceMax)
			throws SQLException {
		// TODO Auto-generated method stub
		return productDao.getTotalProductSelectByValue(categoryId, priceMin, priceMax);
	}

}
