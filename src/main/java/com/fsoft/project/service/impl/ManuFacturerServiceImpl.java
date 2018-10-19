package com.fsoft.project.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.dao.ManuFacturerDao;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.service.ManuFacturerService;


public class ManuFacturerServiceImpl implements ManuFacturerService{

	private ManuFacturerDao manuFacturerDao;

	public ManuFacturerServiceImpl(ManuFacturerDao manuFacturerDao) {
		super();
		this.manuFacturerDao = manuFacturerDao;
	}

	@Override
	public int addManuFacturer(String name) throws SQLException, Exception {

		return manuFacturerDao.addManuFacturer(name);
	}

	@Override
	public List<ManuFacturer> allManuFacturer() throws SQLException, Exception {

		return manuFacturerDao.allManuFacturer();
	}

	@Override
	public String updateManuFacturer(String name, String hidden) throws SQLException, Exception {

		return manuFacturerDao.updateManuFacturer(name, hidden);
	}

	@Override
	public int deleteManuFacturer(String Name) throws SQLException, Exception {

		return manuFacturerDao.deleteManuFacturer(Name);
	}



}
