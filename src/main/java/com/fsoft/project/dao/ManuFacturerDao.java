/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;

import com.fsoft.project.entity.ManuFacturer;

/**
 * @author hungcoutinho
 *
 */
public interface ManuFacturerDao {

	ManuFacturer getManuFacturerById(int id) throws SQLException;
	
}
