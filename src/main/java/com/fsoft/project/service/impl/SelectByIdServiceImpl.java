package com.fsoft.project.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.SelectByIdDao;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.service.SelectByIdService;

public class SelectByIdServiceImpl implements SelectByIdService {

	SelectByIdDao selectByIdDao; 
	
	
	public SelectByIdServiceImpl(SelectByIdDao selectByIdDao) {
		super();
		this.selectByIdDao = selectByIdDao;
	}

	@Override
	public List<Category> idCategory() throws SQLException, Exception {
		
		return selectByIdDao.idCategory();
	}

	@Override
	public List<ManuFacturer> idManuFacturer() throws SQLException, Exception {
		
		return selectByIdDao.idManuFacturer();
	}

}
