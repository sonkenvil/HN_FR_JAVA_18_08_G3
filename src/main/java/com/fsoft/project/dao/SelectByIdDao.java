package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;

public interface SelectByIdDao {

	public List<Category> idCategory() throws SQLException, Exception;
	
	public List<ManuFacturer> idManuFacturer() throws SQLException, Exception;
	
	
}
