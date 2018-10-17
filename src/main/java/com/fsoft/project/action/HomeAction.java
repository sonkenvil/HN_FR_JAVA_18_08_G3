package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

/**
 * @author hungcoutinho
 *
 */
public class HomeAction implements SessionAware, Preparable {

	private List<Product> listNewProduct;
	private List<Product> listProduct;
	private int totalPages;
	private int currentPage;
	private int productId;
	private Map<String, Object> session;
	ProductService productService = null;
	
	public String execute() {
		session.put(Constants.PAGE_INDEX, Constants.INDEX);
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			listNewProduct = productService.getListNewProduct();
			int totalProduct = productService.getTotalProduct();
			totalPages = (totalProduct % 8 == 0) ? (totalProduct / 8) : (totalProduct / 8 + 1);
			listProduct = productService.getListProduct(0);
			if(session.get(Constants.CART_NUMBER) == null) {
				session.put(Constants.CART_NUMBER, 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String listProduct() {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			listProduct = productService.getListProduct((currentPage - 1) * 8);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String addProductToSession() {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		return Action.SUCCESS;
	}

	public String searchListProductByValue(boolean sortByName, boolean sortByPrice, double priceMin, double priceMax) {
		return Action.SUCCESS;
	}
	
	public List<Product> getListNewProduct() {
		return listNewProduct;
	}

	public void setListNewProduct(List<Product> listNewProduct) {
		this.listNewProduct = listNewProduct;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	@Override
	public void prepare() throws Exception {
		
	}

}
