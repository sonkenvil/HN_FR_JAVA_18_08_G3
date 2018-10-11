package com.fsoft.project.intercepter;

import com.fsoft.project.action.LoginAction;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class Authentication implements Interceptor{

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
		 Object user = ActionContext.getContext().getSession().get("user");
		    if (invocation instanceof LoginAction || user != null) {
		      return invocation.invoke();
		    }
		    return WebConstants.FAIL;
	}

}
