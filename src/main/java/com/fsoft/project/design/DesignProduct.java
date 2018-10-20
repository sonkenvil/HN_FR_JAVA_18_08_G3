package com.fsoft.project.design;

import java.io.File;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;

import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.Constants;

public class DesignProduct {

	
	public static void sameProduct(PreparedStatement pre, Product product, File myFile) throws IOException, SQLException {
		pre.setString(1, product.getProductName());
		String filePath = Constants.FEATURE_LOCATION;
		File fileToCreate = new File(filePath,product.getImagePath()); 
		FileUtils.copyFile(myFile, fileToCreate);//copying source file to new file  
		pre.setString(2, product.getImagePath());
		pre.setInt(3,product.getManuFacturer().getId());
		pre.setInt(4, product.getCategory().getId());
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		pre.setTimestamp(5, timestamp);
		pre.setString(6, product.getColor());
		pre.setInt(7, product.getPrice());
	}
	
	public static void fetchProduct(Product product, ResultSet rs) throws SQLException {
		product.setId(rs.getInt("Id"));
		product.setProductName(rs.getString("ProductName"));
		product.setImagePath(rs.getString("ImagePath"));
		product.setColor(rs.getString("Color"));	
		product.setPrice(rs.getInt("Price"));
	}
}
