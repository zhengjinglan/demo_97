package com.aaa.demo.listener;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		ServletContext context = arg0.getSession().getServletContext();
		Integer onlineNums = (Integer) context.getAttribute("onlineNums");
		if (onlineNums != null) {
			context.setAttribute("onlineNums", onlineNums + 1);
		} else {
			context.setAttribute("onlineNums", 1);
			//System.out.println(onlineNums);
		}

	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		ServletContext context = arg0.getSession().getServletContext();
		Integer onlineNums = (Integer) context.getAttribute("onlineNums");
		context.setAttribute("onlineNums", onlineNums - 1);

	}

}
