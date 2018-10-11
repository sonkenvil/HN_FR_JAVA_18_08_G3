package com.fsoft.project.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.entity.LineItem;
import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionSupport;



public class ShoppingCartAction extends ActionSupport implements SessionAware{

	private static final long serialVersionUID = 5461960535747406087L;
	
	private Map<String,Object> session;
	private List<LineItem> listLineItem;
	 @Override
	public String execute() throws Exception {
		 	List<LineItem> lineItems = new ArrayList<>();
			Product product = null;
			LineItem lineItem = null;
			for(int i = 0 ; i < 4 ; i ++) {
				product = new Product();
				product.setProductName("Iphone 6 - " + i );
				product.setPrice(699);
				lineItem = new LineItem();
				lineItem.setProduct(product);
				lineItem.setNumberProduct(i+1);
				lineItems.add(lineItem);
			}
			listLineItem = lineItems;
			System.out.println(listLineItem.size());
		return WebConstants.SUCCESS;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public List<LineItem> getListLineItem() {
		return listLineItem;
	}
	public void setListLineItem(List<LineItem> listLineItem) {
		this.listLineItem = listLineItem;
	}
}
