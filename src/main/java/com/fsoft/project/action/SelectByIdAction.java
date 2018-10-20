package com.fsoft.project.action;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.fsoft.project.dao.SelectByIdDao;
import com.fsoft.project.dao.impl.SelectByIdDaoImpl;
import com.fsoft.project.entity.Category;
import com.fsoft.project.entity.ManuFacturer;
import com.fsoft.project.service.SelectByIdService;
import com.fsoft.project.service.impl.SelectByIdServiceImpl;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionSupport;

public class SelectByIdAction extends ActionSupport{

	
	private static final long serialVersionUID = 1L;
	
	private int id;
	private boolean noData = false;
	private String msg;
	
	SelectByIdDao selectByIdDao;
	SelectByIdService selectByIdService;
	public static Logger LOG=Logger.getLogger(SelectByIdAction.class);
	List<Category> listCategory = new ArrayList<>();
	List<ManuFacturer> listManuFacturer = new ArrayList<>();
	
	

	public String idCategory_ManuFacturer() {
		
		selectByIdDao = new SelectByIdDaoImpl();
		selectByIdService = new SelectByIdServiceImpl(selectByIdDao);
		
		try {
			listCategory = selectByIdService.idCategory();
			listManuFacturer = selectByIdService.idManuFacturer();

			if (listCategory.size() == 0 && listManuFacturer.size()==0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			LOG.error("error at idCategory_ManuFacturer",e);
		}
		return WebConstants.ID_CATEGORY_MANUFACTURER;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public List<Category> getListCategory() {
		return listCategory;
	}

	public void setListCategory(List<Category> listCategory) {
		this.listCategory = listCategory;
	}

	public List<ManuFacturer> getListManuFacturer() {
		return listManuFacturer;
	}

	public void setListManuFacturer(List<ManuFacturer> listManuFacturer) {
		this.listManuFacturer = listManuFacturer;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}
