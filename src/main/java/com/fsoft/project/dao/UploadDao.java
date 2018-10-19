package com.fsoft.project.dao;

import java.sql.SQLException;

import com.fsoft.project.entity.UploadEntity;

public interface UploadDao {

	public int addUpload(UploadEntity u) throws SQLException;
}
