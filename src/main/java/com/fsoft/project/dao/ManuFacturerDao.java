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

	public int addManuFacturer(String name) throws SQLException, Exception;

	public List<ManuFacturer> allManuFacturer() throws SQLException, Exception;

	public int updateManuFacturer(String name, String hidden) throws SQLException, Exception;

	public int deleteManuFacturer(String Name) throws SQLException, Exception;

}
