/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.impl.ImageDetailDaoImpl;
import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.ImageDetail;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ImageDetailService;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ImageDetailServiceImpl;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.opensymphony.xwork2.Action;

/**
 * @author hungcoutinho
 *
 */
public class ProductAction implements SessionAware{

	private int productId;
	private ProductService productService;
	private ImageDetailService imageDetailService;
	private Product product;
	private List<ImageDetail> listImageDetail;
	private List<Product> listRelateProduct;
	private Map<String,Object> session;
	
	public ProductAction() throws SQLException {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		imageDetailService = new ImageDetailServiceImpl(new ImageDetailDaoImpl());
	}
	public String execute() throws SQLException {
		if(productId == 0) productId = (int) session.get(Constants.PRODUCT);
		product = productService.getProductById(productId);
		listImageDetail = imageDetailService.getListImageDetailByProductId(productId);
		listRelateProduct = productService.getListProductRelated(product);
		String name = product.getProductName();
		session.put(Constants.PRODUCT, productId);
		session.put(Constants.PAGE_INDEX, Constants.PRODUCT_DETAIL);
		return Action.SUCCESS;
	}
	
	public String productDetail() throws SQLException {
		Object object = session.get(Constants.PRODUCT);
		if(object != null) {
			int productId = (int) object;
			product = productService.getProductById(productId);
			listImageDetail = imageDetailService.getListImageDetailByProductId(productId);
			listRelateProduct = productService.getListProductRelated(product);
			return Action.SUCCESS;
		}
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

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
