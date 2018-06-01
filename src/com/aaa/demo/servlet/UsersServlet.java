package com.aaa.demo.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class UsersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methods = ObjectUtil.toString(request.getParameter("methods"));
		if (methods == null) {
			response.sendRedirect("../jsp/back/login.jsp");
		} else {
			switch (methods) {
			case "login":
				this.login(request, response);
				break;
			case "loginOut":
				this.loginOut(request, response);
				break;
			default:
				response.sendRedirect("../jsp/error/methodError.jsp");
				break;
			}
		}
	}

	private void loginOut(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		request.getSession().invalidate();
		response.sendRedirect("../jsp/back/login.jsp");

	}

	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String empname = request.getParameter("name");
		String pwd = request.getParameter("password");
		String nologin = request.getParameter("nologin");
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if ("name".equals(cookie.getName())) {
				String name = URLEncoder.encode(cookie.getValue(), "utf-8");
			}
			cookie.getName();
		}
		boolean res = ServiceFactory.emp.QueryNameByPwd(empname, pwd, nologin,
				request.getSession(), response);

		if (res) {
			request.getRequestDispatcher("../jsp/back/home.jsp").forward(
					request, response);
		} else {
			response.sendRedirect("../jsp/back/error.jsp");
		}
	}

}
