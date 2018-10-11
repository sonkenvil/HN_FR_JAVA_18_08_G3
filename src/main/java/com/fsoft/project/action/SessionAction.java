/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

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
public class SessionAction {

	private int productId;
	private ProductService productService;
	private boolean addProduct = false;

	@SuppressWarnings("unchecked")
	public String addProductToSession() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		List<Product> listP = (List<Product>) session.getAttribute(WebConstants.LIST_PRODUCT);
		if(listP == null) {
			listP = new LinkedList<>();
		}
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			Product product = productService.getProductById(productId);
			if (product != null) {
				listP.add(product);
				addProduct = true;
				session.setAttribute(WebConstants.LIST_PRODUCT, listP);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public boolean getAddProduct() {
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
