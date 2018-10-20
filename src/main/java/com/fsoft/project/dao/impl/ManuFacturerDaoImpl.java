package com.fsoft.project.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.project.dao.ManuFacturerDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.utils.constants.QueryConstants;

public class ManuFacturerDaoImpl implements ManuFacturerDao{

	PreparedStatement ps=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	Connection conn=null;
	public static Logger LOG=Logger.getLogger(ManuFacturerDaoImpl.class);
	
	@Override
	public int addManuFacturer(String name) throws SQLException, Exception {
		int result=0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				ps = conn.prepareStatement(QueryConstants.ADD_MANUFACTURER);
				ps.setString(1, name);
				result=ps.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			LOG.error("error at addFactory",e);
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
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
				ps=conn.prepareStatement(QueryConstants.ALL_MANUFACTURER);
				rs = ps.executeQuery();
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
			LOG.error("error at list factory",e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
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
				ps = conn.prepareStatement(QueryConstants.UPDATE_MANUFACTURER);
				ps.setString(1, name);
				ps.setString(2, hidden);
				result= ps.executeUpdate();
			}
			conn.commit();

		} catch (SQLException e) {
			LOG.error("error at update factory",e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
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
				ps=conn.prepareStatement(QueryConstants.DELETE_MANUFACTURER);
				ps.setString(1, Name);
				result = ps.executeUpdate();
			}
			conn.commit();

		} catch (SQLException e) {
			LOG.error("error at update factory",e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return result;
	}
}
