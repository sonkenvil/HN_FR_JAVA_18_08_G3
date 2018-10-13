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
	private ManuFacturer manuFacturer;
	private Category category;

	@Override
	public List<Product> getListNewProduct() throws SQLException {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_NEW_PRODUCT);
			pre.setInt(1, 5);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
						rs.getString("ManuFacturerDescription"));
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("ProductDescription")));
			}
		}
		return listP;
	}

	@Override
	public List<Product> getListProduct(int n) throws SQLException {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT);
			pre.setInt(1, 8);
			pre.setInt(2, n);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
						rs.getString("ManuFacturerDescription"));
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("ProductDescription")));
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

	@Override
	public Product getProductById(int id) throws SQLException {
		// TODO Auto-generated method stub
		Product product = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("ProductDescription"));
			}
		}
		return product;
	}

	@Override
	public List<Product> getListProductByValue(String val) throws SQLException {
		// TODO Auto-generated method stub
		conn = DbHelper.getConnection();
		List<Product> listP = null;
		if (conn != null) {
			listP = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SEARCH_PRODUCT);
			pre.setString(1, "%" + val + "%");
			pre.setString(2, "%" + val + "%");
			pre.setString(3, "%" + val + "%");
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
						rs.getString("ManuFacturerDescription"));
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("ProductDescription")));
			}
		}
		return listP;
	}

}
