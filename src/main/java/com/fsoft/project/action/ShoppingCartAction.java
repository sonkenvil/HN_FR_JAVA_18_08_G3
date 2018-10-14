package com.fsoft.project.action;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.OrderProductDao;
import com.fsoft.project.dao.impl.OrderProductDaoImpl;
import com.fsoft.project.entity.LineItem;
import com.fsoft.project.entity.Member;
import com.fsoft.project.entity.OrderProduct;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.OrderProductService;
import com.fsoft.project.service.impl.OrderProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingCartAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 5461960535747406087L;

	private Map<String, Object> session;
	private List<Product> listProduct;
	private List<LineItem> listItem;
	
	private OrderProductDao orderDao;
	private OrderProductService orderService;
	// send input editor number Product
	private int productId;
	private int number;
	private int refreshNumberCart;

	public ShoppingCartAction() {
		orderDao = new OrderProductDaoImpl();
		orderService = new OrderProductServiceImpl(orderDao);
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		session.put(Constants.PAGE_INDEX, Constants.SHOPPING_CART);
		Object object = session.get(WebConstants.LIST_PRODUCT);
		listProduct = (List<Product>) object;
		if (listProduct == null)
			return WebConstants.SUCCESS;
		listItem = getAllProductCart();
		session.put(Constants.LIST_LINE_ITEM, listItem);
		return WebConstants.SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String editNumberProduct() {
		Map<Integer, Integer> numberProduct = (Map<Integer, Integer>) session.get(WebConstants.LIST_LINEITEM);
		numberProduct.put(productId, number);
		int sum = 0;
		Set<Integer> keySet = numberProduct.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			sum += numberProduct.get(iterator.next());
		}
		refreshNumberCart = sum;
		session.put(Constants.CART_NUMBER, refreshNumberCart);
		listProduct = (List<Product>) session.get(WebConstants.LIST_PRODUCT);
		listItem = getAllProductCart();
		session.put(Constants.LIST_LINE_ITEM, listItem);
		return Action.SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String removeProduct() {
		Map<Integer, Integer> numberProduct = (Map<Integer, Integer>) session.get(WebConstants.LIST_LINEITEM);
		refreshNumberCart = (int) session.get(Constants.CART_NUMBER);
		refreshNumberCart -= numberProduct.get(productId);
		numberProduct.remove(productId);
		listProduct = (List<Product>) session.get(WebConstants.LIST_PRODUCT);
		for(int i = 0 ; i < listProduct.size() ; i++) {
			if(listProduct.get(i).getId() == productId) {
				listProduct.remove(i);
				break;
			}
		}
		session.put(WebConstants.LIST_LINEITEM, numberProduct);
		session.put(WebConstants.LIST_PRODUCT, listProduct);
		session.put(Constants.CART_NUMBER, refreshNumberCart);
		listItem = getAllProductCart();
		session.put(Constants.LIST_LINE_ITEM, listItem);
		return Action.SUCCESS;
	}
	public int getRefreshNumberCart() {
		return refreshNumberCart;
	}
	public void setRefreshNumberCart(int refreshNumberCart) {
		this.refreshNumberCart = refreshNumberCart;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	@SuppressWarnings("unchecked")
	private List<LineItem> getAllProductCart() {
		List<LineItem> list = new ArrayList<>();
		LineItem  lineItem = null;
		OrderProduct orderProduct = new OrderProduct();
		try {
			orderProduct.setId(orderService.getCurrentIdentity());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		Map<Integer, Integer> numberProduct = (Map<Integer, Integer>) session.get(WebConstants.LIST_LINEITEM);
		Set<Integer> keySet = numberProduct.keySet();
		Iterator<Integer> iterator = keySet.iterator();
		while(iterator.hasNext()) {
			int key = iterator.next();
			lineItem = new LineItem();
			lineItem.setOrder(orderProduct);
			lineItem.setProduct(getProduct(key));
			lineItem.setNumberProduct(numberProduct.get(key));
			list.add(lineItem);
		}
		return list;
	}
	
	private Product getProduct(int id) {
		Product product = null;
		for(Product i : listProduct) {
			if(i.getId() == id) {
				product = i;
				break;
			}
		}
		return product;
	}

	public List<LineItem> getListItem() {
		return listItem;
	}

	public void setListItem(List<LineItem> listItem) {
		this.listItem = listItem;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<Product> getListProduct() {
		return listProduct;
	}

	public void setListProduct(List<Product> listProduct) {
		this.listProduct = listProduct;
	}

}
