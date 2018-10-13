package com.fsoft.project.dao;

import java.sql.SQLException;

public interface OrderProductDao {
	int getCurrentIdentity() throws SQLException;
}
