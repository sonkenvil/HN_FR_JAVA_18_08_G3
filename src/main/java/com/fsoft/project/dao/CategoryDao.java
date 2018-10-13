/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;

import com.fsoft.project.entity.Category;

/**
 * @author hungcoutinho
 *
 */
public interface CategoryDao {

	Category getCategoryById(int id) throws SQLException;
	
}
