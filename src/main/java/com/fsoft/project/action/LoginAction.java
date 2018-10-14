package com.fsoft.project.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.LoginDao;
import com.fsoft.project.dao.impl.LoginDaoImpl;
import com.fsoft.project.entity.Member;
import com.fsoft.project.service.LoginService;
import com.fsoft.project.service.impl.LoginServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;
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
	private boolean message;
	private Member member;
	private String fullName;
	public LoginAction() {
		loginDao = new LoginDaoImpl();
		loginService = new LoginServiceImpl(loginDao);
	}

	@Override
	public String execute() throws Exception {
		 member = loginService.getMember(email, password);
		if (member == null)
			return WebConstants.FAIL;
		session.put(Constants.MEMBER, member);
		if (member.isRole())
			return WebConstants.SUCCESS_ADMIN;
		Object object = session.get(Constants.PAGE_INDEX);
		if(object != null) {
			int index = (int) object;
			if(index == 1) {
				return WebConstants.MEMBER_INDEX;
			}else if(index == 2) {
				return WebConstants.MEMBER_PRODUCT_DETAIL;
			}else if(index == 3) {
				return WebConstants.MEMBER_SHOPPING_CART;
			}else {
				return WebConstants.MEMBER_CHECKOUT;
			}
		}
		return WebConstants.SUCCESS_MEMBER;
	}
	public String getMember() {
		member = (Member) session.get(Constants.MEMBER);
		if(member == null) {
			message = false;
		}else {
			fullName = member.getFirstName() + member.getLastName();
			message = true;
		}
		return Action.SUCCESS;
	}
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public boolean isMessage() {
		return message;
	}

	public void setMessage(boolean message) {
		this.message = message;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String savePageIndex() {
		return Action.SUCCESS;
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
