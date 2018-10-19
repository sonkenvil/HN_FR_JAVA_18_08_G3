package com.fsoft.project.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.CategoryDao;
import com.fsoft.project.entity.Category;
import com.fsoft.project.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{

	CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		super();
		this.categoryDao = categoryDao;
	}

	@Override
	public int addCategory(String name) throws SQLException, Exception {
		return categoryDao.addCategory(name);
	}

	@Override
	public List<Category> allCategory() throws SQLException, Exception {
		
		return categoryDao.allCategory();
	}

	@Override
	public int updateCategory(String name, String hidden) throws SQLException, Exception {
		
		return categoryDao.updateCategory(name, hidden);
	}

	@Override
	public int deleteCategory(String Name) throws SQLException, Exception {
		
		return categoryDao.deleteCategory(Name);
	}

	
}
