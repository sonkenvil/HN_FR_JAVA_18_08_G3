/**
 * 
 */
package com.fsoft.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	private ResultSet rs;

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
	
	@Override
	public int addManuFacturer(String name) throws SQLException, Exception {
		int result=0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre = conn.prepareStatement(QueryConstants.ADD_MANUFACTURER);
				pre.setString(1, name);
				result=pre.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
		
		} finally {
			DbHelper.closeConnection(conn, pre);
			conn.rollback();
		}
		return result;
	}

	@Override
	public List<ManuFacturer> allManuFacturer() throws SQLException, Exception {
		List<ManuFacturer> listManuFacturer = new ArrayList<ManuFacturer>();
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre=conn.prepareStatement(QueryConstants.ALL_MANUFACTURER);
				rs = pre.executeQuery();
				int i = 0;
				if (rs != null) {
					while (rs.next()) {
						i++;
						ManuFacturer manuFacturer = new ManuFacturer();
						manuFacturer.setId(i);
						manuFacturer.setName(rs.getString("Name"));
						listManuFacturer.add(manuFacturer);
					}
				}
			}
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, pre,rs);
		}
		return listManuFacturer;
	}

	@Override
	public int updateManuFacturer(String name, String hidden) throws SQLException, Exception {
		int result=0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre = conn.prepareStatement(QueryConstants.UPDATE_MANUFACTURER);
				pre.setString(1, name);
				pre.setString(2, hidden);
				result= pre.executeUpdate();
			}
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, pre, rs);
		}
		return result;
	}

	@Override
	public int deleteManuFacturer(String Name) throws SQLException, Exception {

		int result =0;
		try {
			conn=DbHelper.getConnection();
			DbHelper.getConnection().setAutoCommit(false);
			if(conn!=null) {
				pre=conn.prepareStatement(QueryConstants.DELETE_MANUFACTURER);
				pre.setString(1, Name);
				result = pre.executeUpdate();
			}
			conn.commit();

		} catch (SQLException e) {
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn,pre);
		}
		return result;
	}

}
