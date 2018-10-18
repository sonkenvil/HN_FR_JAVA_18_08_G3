package com.fsoft.project.service;

import java.sql.SQLException;

import com.fsoft.project.entity.Member;
import com.fsoft.project.entity.OrderProduct;

public interface OrderProductService {
	int getCurrentIdentity() throws SQLException;
	
	int addOrderProduct(OrderProduct order);
}
