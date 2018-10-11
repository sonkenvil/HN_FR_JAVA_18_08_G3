package com.fsoft.project.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.LoginDao;
import com.fsoft.project.dao.impl.LoginDaoImpl;
import com.fsoft.project.entity.Member;
import com.fsoft.project.service.LoginService;
import com.fsoft.project.service.impl.LoginServiceImpl;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8216386044271370788L;
	private String email;
	private String password;

	/*
	 * */
	private LoginDao loginDao;
	private LoginService loginService;
	private Map<String, Object> session;

	public LoginAction() {
		loginDao = new LoginDaoImpl();
		loginService = new LoginServiceImpl(loginDao);
	}

	@Override
	public String execute() throws Exception {
		Member member = loginService.getMember(email, password);
		Map<String, Object> session = ActionContext.getContext().getSession();
		if (member == null)
			return WebConstants.FAIL;
		session.put("member", member);
		if (member.isRole())
			return WebConstants.SUCCESS_ADMIN;
		return WebConstants.SUCCESS_MEMBER;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
