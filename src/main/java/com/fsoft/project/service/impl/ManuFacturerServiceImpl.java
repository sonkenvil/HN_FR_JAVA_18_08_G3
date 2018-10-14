/**
 * 
 */
package com.fsoft.project.service.impl;

import java.sql.SQLException;

import com.fsoft.project.dao.ManuFacturerDao;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.service.ManuFacturerService;

/**
 * @author hungcoutinho
 *
 */
public class ManuFacturerServiceImpl implements ManuFacturerService{

	private ManuFacturerDao manuFacturerDao;
	
	public ManuFacturerServiceImpl(ManuFacturerDao manuFacturerDao) {
		this.manuFacturerDao = manuFacturerDao;
	}
	
	@Override
	public ManuFacturer getManuFacturerById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return manuFacturerDao.getManuFacturerById(id);
	}

}