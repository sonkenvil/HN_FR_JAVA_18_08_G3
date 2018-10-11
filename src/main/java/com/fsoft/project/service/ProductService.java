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

}
