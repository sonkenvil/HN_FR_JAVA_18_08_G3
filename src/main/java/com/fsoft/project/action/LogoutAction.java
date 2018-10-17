package com.fsoft.project.action;

import java.util.Map;

import com.fsoft.project.base.BaseAction;
import com.fsoft.project.entity.Member;
import com.fsoft.project.service.impl.LogoutServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.Preparable;

public class LogoutAction extends BaseAction implements Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4333456612200490605L;
	private LogoutServiceImpl logoutService;

	@Override
	public String execute() throws Exception {
		logoutService.removeMember(getSession());
		return Action.SUCCESS;
	}

	@Override
	public void prepare() throws Exception {
		logoutService = new LogoutServiceImpl();
	}

}
