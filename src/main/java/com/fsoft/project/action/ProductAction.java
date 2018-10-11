/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;

/**
 * @author hungcoutinho
 *
 */
public class ProductAction {

	private int id;
	private ProductService productService;
	private Product product;

	public String execute() throws SQLException {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		product = productService.getProductById(id);
		return Action.SUCCESS;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	

}
