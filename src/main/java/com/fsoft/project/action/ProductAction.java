/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.impl.ImageDetailDaoImpl;
import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.ImageDetail;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ImageDetailService;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ImageDetailServiceImpl;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;

/**
 * @author hungcoutinho
 *
 */
public class ProductAction {

	private int productId;
	private ProductService productService;
	private ImageDetailService imageDetailService;
	private Product product;
	private List<ImageDetail> listImageDetail;
	private List<Product> listRelateProduct;

	public String execute() throws SQLException {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		product = productService.getProductById(productId);
		return Action.SUCCESS;
	}

	public String listImageDetail() throws SQLException {
		imageDetailService = new ImageDetailServiceImpl(new ImageDetailDaoImpl());
		listImageDetail = imageDetailService.getListImageDetailByProductId(productId);
		return Action.SUCCESS;
	}
	
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ImageDetail> getListImageDetail() {
		return listImageDetail;
	}

	public void setListImageDetail(List<ImageDetail> listImageDetail) {
		this.listImageDetail = listImageDetail;
	}

	public List<Product> getListRelateProduct() {
		return listRelateProduct;
	}

	public void setListRelateProduct(List<Product> listRelateProduct) {
		this.listRelateProduct = listRelateProduct;
	}

}
