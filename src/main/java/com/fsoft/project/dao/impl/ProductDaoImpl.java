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

import com.fsoft.project.dao.ProductDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.QueryConstants;

/**
 * @author hungcoutinho
 *
 */
public class ProductDaoImpl implements ProductDao {

	private Connection conn;
	private PreparedStatement pre;

	@Override
	public List<Product> getListNewProduct() throws SQLException {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		ManuFacturer manuFacturer;
		Category category;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_NEW_PRODUCT);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				category = getCategoryById(rs.getInt("CategoryId"));
				manuFacturer = getManuFacturerById(rs.getInt("ManuFacturerId"));
				listP.add(new Product(rs.getInt("Id"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"),
						rs.getDouble("Price")));
			}
		}
		return listP;
	}

	@Override
	public List<Product> getListProduct(int n) throws SQLException {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		ManuFacturer manuFacturer;
		Category category;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT);
			pre.setInt(1, n);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				category = getCategoryById(rs.getInt("CategoryId"));
				manuFacturer = getManuFacturerById(rs.getInt("ManuFacturerId"));
				listP.add(new Product(rs.getInt("Id"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"),
						rs.getDouble("Price")));
			}
		}
		return listP;
	}

	@Override
	public int getTotalProduct() throws SQLException {
		// TODO Auto-generated method stub
		int row = 0;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_TOTAL_PRODUCT);
			ResultSet rs = pre.executeQuery();
			if (rs.next())
				row = rs.getInt("Number");
		}
		return row;
	}

	public Category getCategoryById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Category category = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_CATEGORY_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				category = new Category(rs.getInt("Id"), rs.getString("Name"));
			}
		}
		return category;
	}

	public ManuFacturer getManuFacturerById(int id) throws SQLException {
		// TODO Auto-generated method stub
		ManuFacturer manuFacturer = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_MANUFACTURER_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("Id"), rs.getString("Name"));
			}
		}
		return manuFacturer;
	}

	@Override
	public Product getProductById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Product product = null;
		ManuFacturer manuFacturer;
		Category category;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				category = getCategoryById(rs.getInt("CategoryId"));
				manuFacturer = getManuFacturerById(rs.getInt("ManuFacturerId"));
				product = new Product(rs.getInt("Id"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"));
			}
		}
		return product;
	}

	@Override
	public List<Product> getListProductByValue(String val) throws SQLException {
		// TODO Auto-generated method stub
		conn = DbHelper.getConnection();
		List<Product> listP = null;
		ManuFacturer manuFacturer;
		Category category;
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SEARCH_PRODUCT);
			pre.setString(1, "%" + val + "%");
			pre.setString(2, "%" + val + "%");
			pre.setString(3, "%" + val + "%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				category = getCategoryById(rs.getInt("CategoryId"));
				manuFacturer = getManuFacturerById(rs.getInt("ManuFacturerId"));
				listP.add(new Product(rs.getInt("Id"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"),
						rs.getDouble("Price")));
			}
		}
		return listP;
	}

}
