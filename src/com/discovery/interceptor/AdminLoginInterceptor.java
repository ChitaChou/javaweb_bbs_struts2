package com.discovery.interceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.text.TextAction;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminLoginInterceptor extends AbstractInterceptor {  

    @Override  
    public String intercept(ActionInvocation invocation) throws Exception {  

        HttpSession session = ServletActionContext.getRequest().getSession();
        String user = (String) session.getAttribute("currentAdmin");  
        if (user != null) {  
            System.out.println("Admin Login Success");  
            return invocation.invoke();
        }
        return "error"; 
    }  

}  