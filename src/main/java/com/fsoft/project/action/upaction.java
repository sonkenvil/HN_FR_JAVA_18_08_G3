package com.fsoft.project.action;

import java.io.File;
import java.sql.SQLException;

import com.fsoft.project.dao.UploadDao;
import com.fsoft.project.dao.impl.UploadDaoImpl;
import com.fsoft.project.entity.UploadEntity;
import com.fsoft.project.service.UploadService;
import com.fsoft.project.service.impl.UploadServiceImpl;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionSupport;

public class upaction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id, result;
	private String msg;
	
	private File myFile;
	private String myFileContentType;
	private String myFileFileName;
	UploadEntity us;
	UploadDao u = new UploadDaoImpl();
	UploadService se = new UploadServiceImpl(u);
	
	
	public String updemo() throws SQLException {

		UploadEntity us = new UploadEntity();

		us.setMyFile(myFile);
		us.setMyFileContentType(myFileContentType);
		us.setMyFileFileName(myFileFileName);

		
		int result = se.uploads(us);

		if (result > 0) {
			msg = "success";
		} else {
			msg = "false";
		}
		return WebConstants.ADD;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public File getMyFile() {
		return myFile;
	}
	public void setMyFile(File myFile) {
		this.myFile = myFile;
	}
	public String getMyFileContentType() {
		return myFileContentType;
	}
	public void setMyFileContentType(String myFileContentType) {
		this.myFileContentType = myFileContentType;
	}
	public String getMyFileFileName() {
		return myFileFileName;
	}
	public void setMyFileFileName(String myFileFileName) {
		this.myFileFileName = myFileFileName;
	}


	public int getResult() {
		return result;
	}


	public void setResult(int result) {
		this.result = result;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
	
}
