package com.fsoft.project.service.impl;

import java.sql.SQLException;

import com.fsoft.project.dao.OrderProductDao;
import com.fsoft.project.entity.Member;
import com.fsoft.project.entity.OrderProduct;
import com.fsoft.project.service.OrderProductService;

public class OrderProductServiceImpl implements OrderProductService{
	private OrderProductDao orderProductDao;
	 public OrderProductServiceImpl(OrderProductDao dao) {
		orderProductDao = dao;
	}
	@Override
	public int getCurrentIdentity() throws SQLException {
		return orderProductDao.getCurrentIdentity();
	}
	@Override
	public int addOrderProduct(OrderProduct order) {
		return orderProductDao.addOrderProduct(order);
	}
}
