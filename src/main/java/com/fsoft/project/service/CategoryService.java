/**
 * 
 */
package com.fsoft.project.service;

import java.util.List;

import com.fsoft.project.entity.Category;

/**
 * @author hungcoutinho
 *
 */
public interface CategoryService {

	Category getCategoryById(int id);
	
	List<Category> getListCategory();
	
}
