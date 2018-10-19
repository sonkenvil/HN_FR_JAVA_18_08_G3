/**
 * 
 */
package com.fsoft.project.dao;

import java.util.List;

import com.fsoft.project.entity.Category;

/**
 * @author hungcoutinho
 *
 */
public interface CategoryDao {

	Category getCategoryById(int id);
	
	List<Category> getListCategory();
	
}
