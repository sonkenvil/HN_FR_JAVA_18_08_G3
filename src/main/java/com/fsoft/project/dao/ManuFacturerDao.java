package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.ManuFacturer;

public interface ManuFacturerDao {

	public int addManuFacturer(String name) throws SQLException, Exception;

	public List<ManuFacturer> allManuFacturer() throws SQLException, Exception;

	public String updateManuFacturer(String name, String hidden)
			throws SQLException, Exception;

	public int deleteManuFacturer(String  Name) throws SQLException, Exception;
}
