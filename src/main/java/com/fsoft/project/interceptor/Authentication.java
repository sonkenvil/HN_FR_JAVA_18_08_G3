package com.fsoft.project.interceptor;

import java.util.Map;

import com.fsoft.project.action.LoginAction;
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
		Object action = invocation.getAction();
		Object user = session.get(Constants.MEMBER);
		if(invocation.getAction() instanceof LoginAction || user != null) {
			return invocation.invoke();
		}
		return WebConstants.FAIL;
	}

}
