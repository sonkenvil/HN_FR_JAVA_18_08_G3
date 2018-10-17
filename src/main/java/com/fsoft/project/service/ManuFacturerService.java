/**
 * 
 */
package com.fsoft.project.service;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.ManuFacturer;

/**
 * @author hungcoutinho
 *
 */
public interface ManuFacturerService {

	ManuFacturer getManuFacturerById(int id) throws SQLException;
	
	List<ManuFacturer> getListManuFacturerService() throws SQLException;
	
}
