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

import com.fsoft.project.dao.ImageDetailDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ImageDetail;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.QueryConstants;

/**
 * @author hungcoutinho
 *
 */
public class ImageDetailDaoImpl implements ImageDetailDao {

	private Connection conn;
	private PreparedStatement pre;
	private ManuFacturer manuFacturer;
	private Category category;
	private Product product;

	@Override
	public List<ImageDetail> getListImageByProductId(int id) throws SQLException {
		// TODO Auto-generated method stub
		List<ImageDetail> listImage = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			listImage = new LinkedList<>();
			pre = conn.prepareStatement(QueryConstants.SELECT_IMAGE_BY_PRODUCT);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			while (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
						rs.getString("ManuFacturerDescription"));
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("ProductDescription"));
				listImage.add(new ImageDetail(rs.getInt("ImageId"), rs.getString("ImageDetailPath"), product));
			}
		}
		return listImage;
	}

	@Override
	public ImageDetail getImageDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		ImageDetail imageDetail = null;
		conn = DbHelper.getConnection();
		if (conn != null) {
			pre = conn.prepareStatement(QueryConstants.SELECT_IMAGE_BY_ID);
			pre.setInt(1, id);
			ResultSet rs = pre.executeQuery();
			if (rs.next()) {
				manuFacturer = new ManuFacturer(rs.getInt("ManuFacturerId"), rs.getString("ManuFacturerName"),
						rs.getString("ManuFacturerDescription"));
				category = new Category(rs.getInt("CategoryId"), rs.getString("CategoryName"));
				product = new Product(rs.getInt("ProductId"), rs.getString("ProductName"), rs.getString("ImagePath"),
						manuFacturer, category, rs.getDate("CreateDate"), rs.getString("Color"), rs.getDouble("Price"),
						rs.getString("Description"));
				imageDetail = new ImageDetail(rs.getInt("Id"), rs.getString("ImagePath"), product);
			}
		}
		return imageDetail;
	}

}
