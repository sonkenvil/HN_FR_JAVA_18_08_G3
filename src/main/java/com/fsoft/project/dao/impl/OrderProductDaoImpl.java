package com.fsoft.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fsoft.project.dao.OrderProductDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.utils.constants.QueryConstants;

public class OrderProductDaoImpl implements OrderProductDao{
	private Connection connection;
	private PreparedStatement ps;
	private ResultSet rs;
	@Override
	public int getCurrentIdentity() throws SQLException {
		int current = 0;
		connection = DbHelper.getConnection();
		if(connection != null) {
			ps = connection.prepareStatement(QueryConstants.CURRENT_ORDER);
		    rs = ps.executeQuery();
		    while(rs.next()) {
		    	current = rs.getInt(1);
		    }
		}
		return current;
	}
}
