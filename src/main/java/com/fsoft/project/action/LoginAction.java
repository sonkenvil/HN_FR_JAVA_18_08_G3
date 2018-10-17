package com.fsoft.project.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.fsoft.project.dao.LoginDao;
import com.fsoft.project.dao.MemberDao;
import com.fsoft.project.dao.impl.LoginDaoImpl;
import com.fsoft.project.dao.impl.MemberDaoImpl;
import com.fsoft.project.entity.Member;
import com.fsoft.project.service.LoginService;
import com.fsoft.project.service.MemberService;
import com.fsoft.project.service.impl.LoginServiceImpl;
import com.fsoft.project.service.impl.MemberServiceImpl;
import com.fsoft.project.utils.constants.Constants;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public class LoginAction extends ActionSupport implements SessionAware, Preparable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8216386044271370788L;
	private String email;
	private String password;

	/*
	 * */
	private Map<String, Object> session;
	private boolean message;
	private Member member;
	private String fullName;
	private int index;
	private boolean notification;
	private int productId;
	private MemberDao memberDao;
	private MemberService memberService;
	private String redirectURL;

	@Override
	public String execute() throws Exception {
		member = memberService.getMember(email, password);
		if (member == null) {
			notification = false;
			return WebConstants.FAIL;
		} else {
			notification = true;
			session.put(Constants.MEMBER, member);
			if (member.isRole()) {
				return WebConstants.SUCCESS_ADMIN;
			}
			Object object = session.get(Constants.PAGE_INDEX);
			if (object != null) {
				index = (int) object;
				if (index == Constants.INDEX) {
					return WebConstants.MEMBER_INDEX;
				} else if (index == Constants.PRODUCT_DETAIL) {
					productId = (int) session.put(Constants.PRODUCT, productId);
					return WebConstants.MEMBER_PRODUCT_DETAIL;
				} else if (index == Constants.SHOPPING_CART) {
					return WebConstants.MEMBER_SHOPPING_CART;
				} else if (index == Constants.CHECKOUT){
					return WebConstants.MEMBER_CHECKOUT;
				}else {
					return WebConstants.SUCCESS_ADMIN;
				}
			}
		}
		return WebConstants.SUCCESS_MEMBER;
	}

	public String getMember() {
		member = (Member) session.get(Constants.MEMBER);
		if (member == null) {
			message = false;
		} else {
			fullName = member.getFirstName() + member.getLastName();
			message = true;
		}
		return Action.SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	public String getRedirectURL() {
		return redirectURL;
	}

	public void setRedirectURL(String redirectURL) {
		this.redirectURL = redirectURL;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public boolean isNotification() {
		return notification;
	}

	public void setNotification(boolean notification) {
		this.notification = notification;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	@Override
	public void validate() {
		if (member != null) {
			addActionMessage("Account not exist!");
		}
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

	@Override
	public void prepare() throws Exception {
		memberDao = new MemberDaoImpl();
		memberService = new MemberServiceImpl(memberDao);
	}
}
