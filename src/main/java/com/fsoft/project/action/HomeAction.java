package com.fsoft.project.action;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.impl.ProductDaoImpl;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.ProductService;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.opensymphony.xwork2.Action;

/**
 * @author hungcoutinho
 *
 */
public class HomeAction {

	private List<Product> listNewProduct;
	private List<Product> listProduct;
	private int totalPages;
	private int currentPage;
	private int productId;
	ProductService productService = null;

	public String execute() {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			listNewProduct = productService.getListNewProduct();
			int totalProduct = productService.getTotalProduct();
			totalPages = (totalProduct % 8 == 0) ? (totalProduct / 8) : (totalProduct / 8 + 1);
			listProduct = productService.getListProduct(0);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String listProduct() {
		productService = new ProductServiceImpl(new ProductDaoImpl());
		try {
			listProduct = productService.getListProduct((currentPage - 1) * 8);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Action.SUCCESS;
	}

	public String addProductToSession() {
		productService = new ProductServiceImpl(new ProductDaoImpl());
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

}
