package com.fsoft.project.service;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Category;

public interface CategoryService {

	public int addCategory(String name) throws SQLException, Exception;

	public List<Category> allCategory() throws SQLException, Exception;
	
	public int updateCategory(String name, String hidden)
			throws SQLException, Exception;
	
	public int deleteCategory(String Name) throws SQLException, Exception;
	
}
