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

import com.fsoft.project.dao.CategoryDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.utils.constants.QueryConstants;

/**
 * @author hungcoutinho
 *
 */
public class CategoryDaoImpl implements CategoryDao {

	private Connection conn;
	private PreparedStatement pre;
	private ResultSet rs;

	@Override
	public Category getCategoryById(int id){
		// TODO Auto-generated method stub
		Category category = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_CATEGORY_BY_ID);
				pre.setInt(1, id);
				rs = pre.executeQuery();
				if (rs.next()) {
					category = new Category(rs.getInt("Id"), rs.getString("Name"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DbHelper.closeConnection(conn, pre, rs);
			}
		}
		return category;
	}

	@Override
	public List<Category> getListCategory(){
		List<Category> listC = null;
		conn = DbHelper.getConnection();
		if(conn != null) {
			listC = new LinkedList<>();
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_CATEGORY);
				ResultSet rs = pre.executeQuery();
				while(rs.next()) {
					listC.add(new Category(rs.getInt("Id"), rs.getString("Name")));
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				DbHelper.closeConnection(conn, pre);
			}
		}
		return listC;
	}

}
