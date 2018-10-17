package com.fsoft.project.interceptor;

import java.util.Map;

import com.fsoft.project.action.LoginAction;
import com.fsoft.project.entity.Member;
import com.fsoft.project.utils.constants.Constants;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Authentication implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		Map<String,Object> session = ActionContext.getContext().getSession();
		Member user = (Member) session.get(Constants.MEMBER);
		String forwardURL = invocation.getInvocationContext().getName();
		if( user != null) {
			if((user.isRole())) {
				return WebConstants.SUCCESS_ADMIN;
			}else {
				return WebConstants.SUCCESS_MEMBER;
			}
		}
		return WebConstants.FAIL;
	}

}
