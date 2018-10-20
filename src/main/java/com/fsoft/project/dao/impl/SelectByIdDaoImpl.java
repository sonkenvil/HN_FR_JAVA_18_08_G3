package com.fsoft.project.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.project.dao.SelectByIdDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.utils.constants.QueryConstants;

public class SelectByIdDaoImpl implements SelectByIdDao{

	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	CallableStatement cs;
	public static Logger LOG=Logger.getLogger(SelectByIdDaoImpl.class);
	
	@Override
	public List<Category> idCategory() throws SQLException, Exception {
		List<Category> listCategory = new ArrayList<Category>();
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				ps=conn.prepareStatement(QueryConstants.ID_CATEGORY);
				rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Category category = new Category();
						category.setId(rs.getInt("Id"));
						category.setName(rs.getString("Name"));
						listCategory.add(category);
					}
				}
			}
			conn.commit();

		} catch (SQLException e) {
			LOG.error("error at select by id Category", e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return listCategory;
	}

	@Override
	public List<ManuFacturer> idManuFacturer() throws SQLException, Exception {
		List<ManuFacturer> listManuFacturer = new ArrayList<ManuFacturer>();

		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				ps=conn.prepareStatement(QueryConstants.ID_MANUFACTURER);
				rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						ManuFacturer manuFacturer = new ManuFacturer();
						manuFacturer.setId(rs.getInt("Id"));
						manuFacturer.setName(rs.getString("Name"));
						listManuFacturer.add(manuFacturer);
					}
				}
			}

			conn.commit();
		} catch (SQLException e) {
			LOG.error("error at select idManuFacturer",e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return listManuFacturer;
		
	}


}
