package com.fsoft.project.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.entity.LineItem;
import com.fsoft.project.utils.constants.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class CheckoutAction extends ActionSupport implements SessionAware{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6639946862164365278L;

	private List<LineItem> listItem;
	private Map<String,Object> session;
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Object object = session.get(Constants.LIST_LINE_ITEM);
		if(object != null) {
			listItem = (List<LineItem>) object;
		}
		System.out.println("checkout");
		session.put(Constants.PAGE_INDEX, Constants.CHECKOUT);
		return Action.SUCCESS;
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
	
}
