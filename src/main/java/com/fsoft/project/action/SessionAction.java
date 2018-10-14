/**
 * 
 */
package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
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
	private Map<Integer, Integer> listLineItem;
	private int cartNumber;
	private int numberProductDetail;

	@SuppressWarnings("unchecked")
	public String addProductToSession() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		List<Product> listP = (List<Product>) session.getAttribute(WebConstants.LIST_PRODUCT);
		if (listP == null) {
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
			/*
			 * LineItem Product include number
			 */
			listLineItem = (Map<Integer, Integer>) session.getAttribute(WebConstants.LIST_LINEITEM);
			if (listLineItem == null) {
				listLineItem = new HashMap<>();
			}

			for (int i = 0; i < listP.size(); i++) {
				if (numberProductDetail == 0) {
					int number = 1;
					if (listLineItem.get(listP.get(i).getId()) == null) {
						listLineItem.put(listP.get(i).getId(), number);
					}
					for (int j = i + 1; j < listP.size(); j++) {
						if (listP.get(i).getId() == listP.get(j).getId()) {
							listP.remove(j);
							number = listLineItem.get(listP.get(i).getId());
							listLineItem.put(listP.get(i).getId(), ++number);
						}
					}
				}else {
					if(listLineItem.get(listP.get(i).getId()) == null) {
						listLineItem.put(listP.get(i).getId(), numberProductDetail);
					}
					for (int j = i + 1; j < listP.size(); j++) {
						int number;
						if (listP.get(i).getId() == listP.get(j).getId()) {
							listP.remove(j);
							number = listLineItem.get(listP.get(i).getId());
							number += numberProductDetail;
							listLineItem.put(listP.get(i).getId(), number);
						}
					}
				}
			}
			session.setAttribute(WebConstants.LIST_LINEITEM, listLineItem);
			if (numberProductDetail == 0)
				session.setAttribute(Constants.CART_NUMBER, ++cartNumber);
			else {
				int numberProduct = (int) session.getAttribute(Constants.CART_NUMBER);
				cartNumber = numberProduct + numberProductDetail;
				session.setAttribute(Constants.CART_NUMBER, cartNumber);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public int getNumberProductDetail() {
		return numberProductDetail;
	}

	public void setNumberProductDetail(int numberProductDetail) {
		this.numberProductDetail = numberProductDetail;
	}

	public String getNumberProduct() {
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		Object object = session.getAttribute(Constants.CART_NUMBER);
		if (object != null)
			cartNumber = (int) object;
		return Action.SUCCESS;
	}

	public int getCartNumber() {
		return cartNumber;
	}

	public void setCartNumber(int cartNumber) {
		this.cartNumber = cartNumber;
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
