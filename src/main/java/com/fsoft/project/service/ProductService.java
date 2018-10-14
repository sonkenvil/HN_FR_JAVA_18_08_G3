/**
 * 
 */
package com.fsoft.project.service;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Product;

/**
 * @author hungcoutinho
 *
 */
public interface ProductService {

	List<Product> getListNewProduct() throws SQLException;

	List<Product> getListProduct(int n) throws SQLException;
	
	Product getProductById(int id) throws SQLException;

	int getTotalProduct() throws SQLException;
	
	List<Product> getListProductByValue(String val) throws SQLException;
	
	List<Product> getListProductRelated(Product product) throws SQLException;

	List<Product> searchListProductByValue(boolean sortByName,boolean sortByPrice,double minPrice,double maxPrice) throws SQLException;
}
