/**
 * 
 */
package com.fsoft.project.dao.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
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
	private CallableStatement cstm;
	private ResultSet rs;
	private ManuFacturer manuFacturer;
	private Category category;

	@Override
	public List<Product> getListNewProduct() {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_NEW_PRODUCT);
				pre.setInt(1, 5);
				rs = pre.executeQuery();
				while (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription")));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre,rs);
			}
		}
		return listP;
	}

	@Override
	public List<Product> getListProduct(int n) {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT);
				pre.setInt(1, 8);
				pre.setInt(2, n);
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription")));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre, rs);
			}
		}
		return listP;
	}

	@Override
	public int getTotalProduct() {
		// TODO Auto-generated method stub
		int row = 0;
		conn = DbHelper.getConnection();
		if (conn != null) {
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_TOTAL_PRODUCT);
				ResultSet rs = pre.executeQuery();
				if (rs.next())
					row = rs.getInt("Number");
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre, rs);
			}
		}
		return row;
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		Product product = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_PRODUCT_BY_ID);
				pre.setInt(1, id);
				ResultSet rs = pre.executeQuery();
				if (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription"));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre,rs);
			}
		}
		return product;
	}

	@Override
	public List<Product> getListProductByValue(String val) {
		// TODO Auto-generated method stub
		conn = DbHelper.getConnection();
		List<Product> listP = null;
		if (conn != null) {
			listP = new LinkedList<>();
			try {
				pre = conn.prepareStatement(QueryConstants.SEARCH_PRODUCT);
				pre.setString(1, "%" + val + "%");
				pre.setString(2, "%" + val + "%");
				pre.setString(3, "%" + val + "%");
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription")));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre,rs);
			}
		}
		return listP;
	}

	@Override
	public List<Product> getListProductRelated(Product product) {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			try {
				cstm = conn.prepareCall(QueryConstants.SELECT_PRODUCT_RELATED);
				cstm.setInt(1, 4);
				cstm.setInt(2, product.getId());
				cstm.setInt(3, product.getManuFacturer().getId());
				cstm.setDouble(4, product.getPrice());
				ResultSet rs = cstm.executeQuery();
				while (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription")));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, cstm,rs);
			}
		}
		return listP;
	}

	@Override
	public List<Product> selectListProductByValue(int categoryId, String sortName, String sortPrice,
			BigDecimal priceMin, BigDecimal priceMax, int offset, int fetch) {
		// TODO Auto-generated method stub
		List<Product> listP = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listP = new LinkedList<>();
			StringBuilder str = new StringBuilder();
			if (categoryId > 0)
				str.append("WHERE C.Id = " + categoryId);
			if ("".equals(str.toString()))
				str.append(" WHERE P.Price >= " + priceMin + " AND P.Price <= " + priceMax);
			else
				str.append(" AND P.Price >= " + priceMin + " AND P.Price <= " + priceMax);
			if (!sortName.equals("Default") && !sortPrice.equals("Default"))
				str.append(" ORDER BY P.ProductName " + sortName + " , P.Price " + sortPrice);
			else if (!sortName.equals("Default") && sortPrice.equals("Default"))
				str.append(" ORDER BY P.ProductName " + sortName);
			else if (sortName.equals("Default") && !sortPrice.equals("Default"))
				str.append(" ORDER BY P.Price " + sortPrice);
			else
				str.append(" ORDER BY ProductId");
			str.append(" OFFSET " + offset + " ROWS FETCH NEXT " + fetch + " ROWS ONLY");
			// pre.setString(1, str.toString());
			try {
				pre = conn.prepareStatement(QueryConstants.SEARCH_PRODUCT_BY_VALUE + str.toString());
				ResultSet rs = pre.executeQuery();
				while (rs.next()) {
					manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
							rs.getString("ManuFacturerDescription"));
					category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
					listP.add(new Product(rs.getInt("ProductId"), rs.getString("ProductName"),
							rs.getString("ImagePath"), manuFacturer, category, rs.getDate("CreateDate"),
							rs.getString("Color"), rs.getInt("Price"), rs.getString("ProductDescription")));
				}
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre,rs);
			}
		}
		return listP;
	}

	@Override
	public int getTotalProductSelectByValue(int categoryId, BigDecimal priceMin, BigDecimal priceMax) {
		// TODO Auto-generated method stub
		int rows = 0;
		conn = DbHelper.getConnection();
		if (conn != null) {
			StringBuilder str = new StringBuilder();
			if (categoryId > 0)
				str.append("WHERE C.Id = " + categoryId);
			if ("".equals(str.toString()))
				str.append("WHERE Price >= " + priceMin + " AND Price <= " + priceMax);
			else
				str.append(" AND Price >= " + priceMin + " AND Price <= " + priceMax);
			try {
				pre = conn.prepareStatement(QueryConstants.SELECT_TOTAL_PRODUCT_SELECT_BY_VALUE + str);
				ResultSet rs = pre.executeQuery();
				if (rs.next())
					rows = rs.getInt("Number");
			} catch (SQLException e) {

			} finally {
				DbHelper.closeConnection(conn, pre,rs);
			}
		}
		return rows;
	}

}
