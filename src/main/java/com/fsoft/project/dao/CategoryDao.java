package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Category;

public interface CategoryDao {

	
	public int addCategory(String name) throws SQLException, Exception;

	public List<Category> allCategory() throws SQLException, Exception;
	
	public int updateCategory(String name, String hidden)
			throws SQLException, Exception;
	
	public int deleteCategory(String  Name) throws SQLException, Exception;
	
}
