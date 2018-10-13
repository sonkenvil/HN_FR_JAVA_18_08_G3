package com.fsoft.project.action;

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
import com.fsoft.project.entity.OrderProduct;
import com.fsoft.project.entity.Product;
import com.fsoft.project.service.OrderProductService;
import com.fsoft.project.service.impl.OrderProductServiceImpl;
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

	public ShoppingCartAction() {
		orderDao = new OrderProductDaoImpl();
		orderService = new OrderProductServiceImpl(orderDao);
	}
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Object object = session.get(WebConstants.LIST_PRODUCT);
		listProduct = (List<Product>) object;
		if (listProduct == null)
			return WebConstants.SUCCESS;
		listItem = getAllProductCart();
		return WebConstants.SUCCESS;
	}
	
	public String editNumberProduct() {
		Map<Integer, Integer> numberProduct = (Map<Integer, Integer>) session.get(WebConstants.LIST_LINEITEM);
		numberProduct.put(productId, number);
		return Action.SUCCESS;
	}
	public String removeProduct() {
		System.out.println("remove" + productId);
		Map<Integer, Integer> numberProduct = (Map<Integer, Integer>) session.get(WebConstants.LIST_LINEITEM);
		numberProduct.remove(productId);
		return Action.SUCCESS;
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
