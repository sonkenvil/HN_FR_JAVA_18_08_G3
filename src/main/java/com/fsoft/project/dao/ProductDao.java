/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;

/**
 * @author hungcoutinho
 *
 */
public interface ProductDao {

	List<Product> getListNewProduct() throws SQLException;

	List<Product> getListProduct(int n) throws SQLException;

	int getTotalProduct() throws SQLException;

	Category getCategoryById(int id) throws SQLException;

	ManuFacturer getManuFacturerById(int id) throws SQLException;

	Product getProductById(int id) throws SQLException;

}
