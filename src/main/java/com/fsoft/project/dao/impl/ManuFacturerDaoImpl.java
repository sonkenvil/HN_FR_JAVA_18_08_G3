package com.fsoft.project.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.project.dao.ManuFacturerDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.utils.constants.QueryConstants;

public class ManuFacturerDaoImpl implements ManuFacturerDao{

	PreparedStatement ps=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	Connection conn=null;
	
	@Override
	public int addManuFacturer(String name) throws SQLException, Exception {
		
		int result=0;
		try {
			conn=DbHelper.getConnection();
			if(conn!=null) {
				ps = conn.prepareStatement(QueryConstants.ADD_MANUFACTURER);
				
				ps.setString(1, name);
				result=ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return result;
	}

	@Override
	public List<ManuFacturer> allManuFacturer() throws SQLException, Exception {
List<ManuFacturer> listManuFacturer = new ArrayList<ManuFacturer>();
		
		try {
			
			conn=DbHelper.getConnection();
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
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return listManuFacturer;
	}

	@Override
	public String updateManuFacturer(String name, String hidden) throws SQLException, Exception {
		
		try {
			conn=DbHelper.getConnection();
			if(conn!=null) {
				ps = conn.prepareStatement(QueryConstants.UPDATE_MANUFACTURER);
				ps.setString(1, name);
				ps.setString(2, hidden);
				ps.executeUpdate();
			}
			return "Update Successful";
			
		} catch (Exception e) {
			e.printStackTrace();
			return e.getMessage();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		
		
	}

	@Override
	public int deleteManuFacturer(String Name) throws SQLException, Exception {
		
		conn=DbHelper.getConnection();
		DbHelper.getConnection().setAutoCommit(false);
		int i = 0;
		try {
			ps=conn.prepareStatement(QueryConstants.DELETE_MANUFACTURER);
			ps.setString(1, Name);
			i = ps.executeUpdate();
			return i;
	
		} catch (Exception e) {
			e.printStackTrace();
			DbHelper.getConnection().rollback();
			return 0;
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
	}

}
