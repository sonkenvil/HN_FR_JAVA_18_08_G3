/**
 * 
 */
package com.fsoft.project.service;

import java.sql.SQLException;

import com.fsoft.project.entity.Category;

/**
 * @author hungcoutinho
 *
 */
public interface CategoryService {

	Category getCategoryById(int id) throws SQLException;
	
}
