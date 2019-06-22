package com.discovery.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.TextAction;

import org.apache.struts2.ServletActionContext;

import com.discovery.model.User;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class UserLoginInterceptor extends AbstractInterceptor{  

    public String intercept(ActionInvocation invocation) {  

        HttpSession session = ServletActionContext.getRequest().getSession();
        User user = (User) session.getAttribute("currentUser");
        try {
        	if (user.getUser_id() != null) {  
                return invocation.invoke();
            }
        	else{
        		return "error";
        	}
		} catch (Exception e) {
			return "error"; 
		}
    }  

}  