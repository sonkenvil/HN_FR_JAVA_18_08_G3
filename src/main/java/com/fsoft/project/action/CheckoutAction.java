package com.fsoft.project.action;

import java.util.Calendar;
import java.util.List;

import com.fsoft.project.base.BaseAction;
import com.fsoft.project.dao.impl.LineItemDaoImpl;
import com.fsoft.project.dao.impl.OrderProductDaoImpl;
import com.fsoft.project.entity.LineItem;
import com.fsoft.project.entity.Member;
import com.fsoft.project.entity.OrderProduct;
import com.fsoft.project.service.LineItemService;
import com.fsoft.project.service.OrderProductService;
import com.fsoft.project.service.impl.LineItemServiceImpl;
import com.fsoft.project.service.impl.OrderProductServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.fsoft.project.utils.constants.DateUtils;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class CheckoutAction extends BaseAction implements Preparable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6639946862164365278L;

	private List<LineItem> listItem;
	private boolean message;
	private OrderProductService orderService;
	private LineItemService lineService;
	
	@Override
	public void prepare() throws Exception {
		orderService = new OrderProductServiceImpl(new OrderProductDaoImpl());
		lineService = new LineItemServiceImpl(new LineItemDaoImpl());
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public String execute() throws Exception {
		Object object = getSession().get(Constants.LIST_LINE_ITEM);
		if (object != null) {
			listItem = (List<LineItem>) object;
		}
		getSession().put(Constants.PAGE_INDEX, Constants.CHECKOUT);
		return Action.SUCCESS;
	}

	@SuppressWarnings("unchecked")
	public String confirmPayment() {
		int affectedOrder = 0;
		int affectedLineItem = 0;
		listItem = (List<LineItem>) getSession().get(Constants.LIST_LINE_ITEM);
		
		OrderProduct order = new OrderProduct();
		Member member = (Member) getSession().get(Constants.MEMBER);
		order.setTotalPrice(totalPrice(listItem));
		order.setMember(member);
		order.setCreateDate(DateUtils.getDate());
		affectedOrder = orderService.addOrderProduct(order);
		
		affectedLineItem = lineService.addLineItem(listItem);
		if(affectedOrder != 0 && affectedLineItem != 0) {
			 message = true;
			 getSession().remove(Constants.LIST_LINE_ITEM);
			 getSession().remove(WebConstants.LIST_PRODUCT);
			 getSession().remove(WebConstants.LIST_LINEITEM);
			 getSession().remove(Constants.CART_NUMBER);
		}else 
			message = false;
		return Action.SUCCESS;
	}
	
	private int totalPrice(List<LineItem> list) {
		int sum = 0;
		for(LineItem i : list) {
			sum += i.getNumberProduct() * i.getProduct().getPrice();
		}
		return sum;
	}
	

	public boolean isMessage() {
		return message;
	}

	public void setMessage(boolean message) {
		this.message = message;
	}

	public List<LineItem> getListItem() {
		return listItem;
	}

	public void setListItem(List<LineItem> listItem) {
		this.listItem = listItem;
	}
}
