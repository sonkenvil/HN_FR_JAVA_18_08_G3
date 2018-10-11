/**
 * 
 */
package com.fsoft.project.interceptor;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.fsoft.project.entity.Product;
import com.fsoft.project.utils.constants.WebConstants;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

/**
 * @author hungcoutinho
 *
 */
public class SessionInterceptor implements Interceptor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		System.out.println("session interceptor");
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		HttpSession session = ServletActionContext.getRequest().getSession(true);
		if (session.getAttribute(WebConstants.LIST_PRODUCT) == null) {
			List<Product> listP = new LinkedList<>();
			session.setAttribute(WebConstants.LIST_PRODUCT, listP);
			System.out.println(listP != null);
		}
		return invocation.invoke();
	}

}
