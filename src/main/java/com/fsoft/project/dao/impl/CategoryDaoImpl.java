package com.fsoft.project.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsoft.project.dao.CategoryDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.utils.constants.QueryConstants;

public class CategoryDaoImpl implements CategoryDao {

	PreparedStatement ps=null;
	CallableStatement cs=null;
	ResultSet rs=null;
	Connection conn=null;

	@Override
	public int addCategory(String name) throws SQLException, Exception {
		
		int result=0;
		try {
			conn=DbHelper.getConnection();
			if(conn!=null) {
				ps = conn.prepareStatement(QueryConstants.ADD_CATEGORY);
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
	public List<Category> allCategory() throws SQLException, Exception {
		
		List<Category> listCategory = new ArrayList<Category>();
		
		try {
			
			conn=DbHelper.getConnection();
			if(conn!=null) {
				
				ps=conn.prepareStatement(QueryConstants.ALL_CATEGORY);
				rs = ps.executeQuery();
				int i = 0;
				
				if (rs != null) {
					while (rs.next()) {
						i++;
						
						Category category = new Category();
						category.setId(i);
						category.setName(rs.getString("Name"));
						
						listCategory.add(category);
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		return listCategory;
	}

	@Override
	public int updateCategory(String name, String hidden) throws SQLException, Exception {
		int affected = 0;
		try {
			conn=DbHelper.getConnection();
			if(conn!=null) {
				ps = conn.prepareStatement(QueryConstants.UPDATE_CATEGORY);
				ps.setString(1, name);
				ps.setString(2, hidden);
				affected = ps.executeUpdate();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeConnection(conn, ps, cs, rs);
		}
		
		return affected;
	}

	@Override
	public int deleteCategory(String  Name) throws SQLException, Exception {
		conn=DbHelper.getConnection();
		DbHelper.getConnection().setAutoCommit(false);
		int i = 0;
		try {
			ps=conn.prepareStatement(QueryConstants.DELETE_CATEGORY);
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
