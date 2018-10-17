/**
 * 
 */
package com.fsoft.project.dao;

import java.math.BigDecimal;
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

	List<Product> getListProductRelated(Product product) throws SQLException;

	List<Product> selectListProductByValue(int categoryID, String sortName, String sortPrice, BigDecimal priceMin,
			BigDecimal priceMax, int offset, int fetch) throws SQLException;

	int getTotalProductSelectByValue(int categoryId, BigDecimal priceMin, BigDecimal priceMax) throws SQLException;

}
