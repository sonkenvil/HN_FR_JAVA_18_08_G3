/**
 * 
 */
package com.fsoft.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.fsoft.project.dao.ManuFacturerDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.utils.constants.QueryConstants;

/**
 * @author hungcoutinho
 *
 */
public class ManuFacturerDaoImpl implements ManuFacturerDao {

	private Connection conn;
	private PreparedStatement pre;

	@Override
	public ManuFacturer getManuFacturerById(int id) throws SQLException {
		// TODO Auto-generated method stub
		ManuFacturer manuFacturer = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_MANUFACTURER_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("Id"), rs.getString("Name"), rs.getString("Description"));
			}
		}
		return manuFacturer;
	}

	@Override
	public List<ManuFacturer> getListManuFacturer() throws SQLException {
		// TODO Auto-generated method stub
		List<ManuFacturer> listM = null;
		conn = DbHelper.getConnection();
		if(conn != null) {
			listM = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_MANUFACTURER);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				listM.add(new ManuFacturer(rs.getInt("Id"), rs.getString("Name"), rs.getString("Description")));
			}
		}
		return listM;
	}

}
