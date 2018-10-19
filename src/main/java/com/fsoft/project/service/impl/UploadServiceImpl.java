package com.fsoft.project.service.impl;

import java.sql.SQLException;

import com.fsoft.project.dao.UploadDao;
import com.fsoft.project.entity.UploadEntity;
import com.fsoft.project.service.UploadService;


public class UploadServiceImpl implements UploadService{

	UploadDao uh;
	
	public UploadServiceImpl(UploadDao uh) {
		super();
		this.uh = uh;
	}

	@Override
	public int uploads(UploadEntity u) throws SQLException {
		return uh.addUpload(u);
	}

}
