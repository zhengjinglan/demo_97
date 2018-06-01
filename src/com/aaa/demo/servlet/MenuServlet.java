package com.aaa.demo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.demo.entity.MenuOne;
import com.aaa.demo.factory.MenuDAOFactory;

public class MenuServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methods = request.getParameter("methods");

		switch (methods) {
		// 登录
		case "getMenu":
			this.getMenu(request, response);
			break;
		default:
			response.sendRedirect("../jsp/error/methodError.jsp");
			break;
		}
	}

	private void getMenu(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<MenuOne> list = MenuDAOFactory.one.getMenu();
		request.setAttribute("list", list);
		request.getRequestDispatcher("../jsp/back/home.jsp").forward(request,
				response);
	}

}
