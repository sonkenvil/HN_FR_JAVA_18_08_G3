package com.fsoft.project.dao.impl;

import java.io.File;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.fsoft.project.dao.UploadDao;
import com.fsoft.project.db.DbHelper;
import com.fsoft.project.entity.Product;
import com.fsoft.project.entity.UploadEntity;
import com.fsoft.project.service.impl.ProductServiceImpl;
import com.fsoft.project.utils.constants.QueryConstants;
import com.fsoft.project.utils.constants.StorageUtils;
import com.fsoft.project.utils.constants.WebConstants;

public class UploadDaoImpl implements UploadDao{

	@Override
	public int addUpload(UploadEntity u) throws SQLException {

		PreparedStatement pre=null;
		Connection conn=null;
		ResultSet rs=null;
		CallableStatement cs=null;
		
		int result=0;
		try {
			conn=DbHelper.getConnection();
			if(conn!=null) {

				pre = conn.prepareStatement(QueryConstants.ADD);

				
				
//				String filePath = ServletActionContext.getServletContext().getRealPath("/").concat("useri");  
				String filePath= StorageUtils.FEATURE_LOCATION;
				System.out.println("Image Location:" + filePath);//see the server console for actual location  
		       
		        File fileToCreate = new File(filePath,u.getMyFileFileName());  
		        FileUtils.copyFile(u.getMyFile(), fileToCreate);//copying source file to new file  
				
				pre.setString(1, u.getMyFileFileName());
				
				result=pre.executeUpdate();

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeConnection(conn, pre, cs, rs);
		}
		return result;
	}

}
