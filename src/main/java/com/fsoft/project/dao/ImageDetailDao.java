/**
 * 
 */
package com.fsoft.project.dao;

import java.sql.SQLException;
import java.util.List;

import com.fsoft.project.entity.ImageDetail;

/**
 * @author hungcoutinho
 *
 */
public interface ImageDetailDao {

	List<ImageDetail> getListImageByProductId(int id) throws SQLException;
	
	ImageDetail getImageDetailById(int id) throws SQLException;
	
}
