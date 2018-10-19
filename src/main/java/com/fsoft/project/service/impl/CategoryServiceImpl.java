/**
 * 
 */
package com.fsoft.project.service.impl;

import java.util.List;

import com.fsoft.project.dao.CategoryDao;
import com.fsoft.project.entity.Category;
import com.fsoft.project.service.CategoryService;

/**
 * @author hungcoutinho
 *
 */
public class CategoryServiceImpl implements CategoryService{

	private CategoryDao categoryDao;
	
	public CategoryServiceImpl(CategoryDao categoryDao) {
		this.categoryDao = categoryDao;
	}
	
	@Override
	public Category getCategoryById(int id){
		// TODO Auto-generated method stub
		return categoryDao.getCategoryById(id);
	}

	@Override
	public List<Category> getListCategory(){
		// TODO Auto-generated method stub
		return categoryDao.getListCategory();
	}

}
