/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.ManuFacturer;

/**
 * @author hungcoutinho
 *
 */
public interface ManuFacturerDao {

	ManuFacturer getManuFacturerById(int id) throws SQLException;
	
	List<ManuFacturer> getListManuFacturer() throws SQLException;
	
}
