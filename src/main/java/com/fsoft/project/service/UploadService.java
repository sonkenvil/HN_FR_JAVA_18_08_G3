package com.fsoft.project.service;

import java.sql.SQLException;

import com.fsoft.project.entity.UploadEntity;

public interface UploadService {

	public int uploads(UploadEntity u) throws SQLException;
}
