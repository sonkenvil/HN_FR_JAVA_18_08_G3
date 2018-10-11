/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;

/**
 * @author hungcoutinho
 *
 */
public class SessionAction implements SessionAware {

	private int productId;
	private SessionMap<String, Object> session;
	private ProductService productService;
	private boolean addProduct = false;

	@SuppressWarnings("unchecked")
	public String addProductToSession() {
		List<Product> listP = (List<Product>) session.get(WebConstants.LIST_PRODUCT);
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			Product product = productService.getProductById(productId);
			if (product != null) {
				listP.add(product);
				System.out.println(listP.size() + " " + product.getProductName());
				addProduct = true;
				session.put(WebConstants.LIST_PRODUCT, listP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		// TODO Auto-generated method stub
		this.session = (SessionMap<String, Object>) session;
	}

	public boolean isAddProduct() {
		return addProduct;
	}

	public void setAddProduct(boolean addProduct) {
		this.addProduct = addProduct;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

}
