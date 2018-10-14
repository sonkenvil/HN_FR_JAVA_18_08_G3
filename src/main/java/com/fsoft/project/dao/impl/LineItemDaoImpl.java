package com.fsoft.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.LineItemDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.LineItem;
import com.fsoft.project.entity.OrderProduct;
import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.QueryConstants;

public class LineItemDaoImpl implements LineItemDao{
	private Connection connection;
	private PreparedStatement ps;
	@Override
	public int addLineItem(List<LineItem> listItem) throws SQLException {
		/*
		 *  private OrderProduct order;
			private Product product;
			private int numberProduct;*/
		int affected = 0;
		connection = DbHelper.getConnection();
		if(connection != null) {
			ps = connection.prepareStatement(QueryConstants.ADD_LINEITEM);
			for(LineItem i : listItem) {
				affected ++;
				ps.setInt(1, i.getOrder().getId());
				ps.setInt(2, i.getProduct().getId());
				ps.setInt(3, i.getNumberProduct());
				ps.executeUpdate();
			}
		}
		return affected;
	}

}
