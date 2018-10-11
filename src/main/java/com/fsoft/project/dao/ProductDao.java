/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Product;

/**
 * @author hungcoutinho
 *
 */
public interface ProductDao {

	List<Product> getListNewProduct() throws SQLException;

	List<Product> getListProduct(int n) throws SQLException;
	
	List<Product> getListProductByValue(String val) throws SQLException;

	int getTotalProduct() throws SQLException;

	Product getProductById(int id) throws SQLException;

}
