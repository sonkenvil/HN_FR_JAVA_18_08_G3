package com.fsoft.project.service;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;

public interface SelectByIdService {

	public List<Category> idCategory() throws SQLException, Exception;

	public List<ManuFacturer> idManuFacturer() throws SQLException, Exception;

}
