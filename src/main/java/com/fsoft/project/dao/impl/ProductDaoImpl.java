/**
 * 
 */
package com.fsoft.project.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.project.dao.ProductDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.design.DesignProduct;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.QueryConstants;

/**
 * @author hungcoutinho
 *
 */
public class ProductDaoImpl implements ProductDao{

	private Connection conn=null;
	private PreparedStatement pre=null;
	private CallableStatement cs=null;
	private ResultSet rs=null;
	public static Logger LOG=Logger.getLogger(ProductDaoImpl.class);
	@Override
	public List<Product> getListNewProduct() throws SQLException {


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


	@Override
	public int addProduct(Product product) throws SQLException {

		int result=0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre = conn.prepareStatement(QueryConstants.ADD_PRODUCT);
				DesignProduct.sameProduct(pre, product);
				
//				pre.setString(1, product.getProductName());
//				String filePath =StorageUtils.FEATURE_LOCATION;
//				File fileToCreate = new File(filePath,product.getImagePath()); 
//				FileUtils.copyFile(product.getMyFile(), fileToCreate);//copying source file to new file  
//				pre.setString(2, product.getImagePath());
//				pre.setInt(3,product.getManuFacturerId());
//				pre.setInt(4, product.getCategoryId());
//				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//				pre.setTimestamp(5, timestamp);
//				pre.setString(6, product.getColor());
//				pre.setDouble(7, product.getPrice());
				
				result=pre.executeUpdate();
			}
			conn.commit();

		} catch (Exception e) {
			LOG.error("some error at add product",e);
			conn.rollback();
		} finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
			
		}
		return result;
	}

	@Override
	public List<Product> allProduct() throws SQLException {

		List<Product> listProduct = new ArrayList<>();
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre=conn.prepareStatement(QueryConstants.ALL_PRODUCT);
				rs=pre.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						Product product = new Product();
						DesignProduct.fetchProduct(product, rs);
						
//						product.setId(rs.getInt("Id"));
//						product.setProductName(rs.getString("ProductName"));
//						product.setImagePath(rs.getString("ImagePath"));
//						product.setColor(rs.getString("Color"));
//						product.setPrice(rs.getDouble("Price"));
						listProduct.add(product);
					}
				}
			}
		} catch (SQLException e) {
			LOG.error("error at list product", e);
			conn.rollback();
		}finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
			
		}
		return listProduct;
	}


	@Override
	public  Product fetchProduct(int  id) throws SQLException {
		Product product = null;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre=conn.prepareStatement(QueryConstants.PRE_SELECT_UPDATE_PRODUCT);
				pre.setInt(1, id);
				rs=pre.executeQuery();
				if (rs.next()) {
					product = new Product();
					DesignProduct.fetchProduct(product, rs);
					
//					product.setId(rs.getInt("Id"));
//					product.setProductName(rs.getString("ProductName"));
//					product.setImagePath(rs.getString("ImagePath"));
					
					product.setManuFacturerId(rs.getInt("ManuFacturerId"));
					product.setCategoryId(rs.getInt("CategoryId"));
					product.setCreateDate(rs.getDate("CreateDate"));
					
//					product.setColor(rs.getString("Color"));	
//					product.setPrice(rs.getDouble("Price"));
					return product;
				}
			}
			conn.commit();
		} catch (SQLException e) {
			LOG.error("error at fetch product", e);
			conn.rollback();
		}finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
			
		}
		return product;
	}




	@Override
	public int updateProduct(Product product) throws SQLException, Exception {
		int i=0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre = conn.prepareStatement(QueryConstants.UPDATE_PRODUCT);
				
				DesignProduct.sameProduct(pre, product);
				
//				String filePath =StorageUtils.FEATURE_LOCATION;
//				File fileToCreate = new File(filePath,product.getImagePath()); 
//				FileUtils.copyFile(product.getMyFile(), fileToCreate);//copying source file to new file     
//				pre.setString(1, product.getProductName());
//				pre.setString(2, product.getImagePath());
//				pre.setInt(3,product.getManuFacturerId());
//				pre.setInt(4, product.getCategoryId());
//				Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//				pre.setTimestamp(5, timestamp);
//				pre.setString(6, product.getColor());
//				pre.setDouble(7, product.getPrice());
				
				pre.setInt(8, product.getHidden());
				i=pre.executeUpdate();

			}
			conn.commit();
		} catch (SQLException e) {
			LOG.error("error at update product",e);
			conn.rollback();

		} finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
		}
		return i;


	}

	@Override

	public int deleteProduct(int id) throws SQLException, Exception {
		DbHelper.getConnection().setAutoCommit(false);
		int i = 0;
		try {
			conn=DbHelper.getConnection();
			conn.setAutoCommit(false);
			if(conn!=null) {
				pre= conn.prepareStatement(QueryConstants.DELETE_PRODUCT);
				pre.setInt(1, id);
				i = pre.executeUpdate();
			}
			conn.commit();
		} catch (SQLException e) {
			LOG.error("error at delete product", e);
			DbHelper.getConnection().rollback();
		} finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
		}
		return i;
	}



}
