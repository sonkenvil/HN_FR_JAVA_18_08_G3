/**
 * 
 */
package com.fsoft.project.service;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.ImageDetail;

/**
 * @author hungcoutinho
 *
 */
public interface ImageDetailService {

	List<ImageDetail> getListImageDetailByProductId(int productId) throws SQLException;
	
	ImageDetail getImageDetailById(int id) throws SQLException;
}
