package com.aaa.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Suppliers;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class SuppliersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methods = request.getParameter("methods");

		switch (methods) {
		case "query":
			this.empQuery(request, response);
			break;
		case "add":
			this.add(request, response);
			break;
		case "queryUpdate":
			this.queryUpdate(request, response);
			break;
		case "update":
			this.update(request, response);
			break;
		case "delete":
			this.delete(request, response);
			break;
		default:
			response.sendRedirect("../jsp/error/methodError.jsp");
			break;
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String id = ObjectUtil.toString(request.getParameter("id"));
		String[] ids = id.split(",");
		int falg = 0;
		for (int i = 0; i < ids.length; i++) {
			falg = ServiceFactory.ss.DelCs(Integer.parseInt(id));
		}
		PrintWriter out = response.getWriter();
		if (falg > 0) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Integer ssid = ObjectUtil.toInteger(request.getParameter("ssid"));
		String name1 = ObjectUtil.toString(request.getParameter("name"));
		// System.out.println(name1);
		String ctname1 = ObjectUtil.toString(request.getParameter("ctname"));
		String title1 = ObjectUtil.toString(request.getParameter("title"));
		String phone1 = ObjectUtil.toString(request.getParameter("phone"));
		String code1 = ObjectUtil.toString(request.getParameter("code"));
		String address1 = ObjectUtil.toString(request.getParameter("address"));
		boolean res = ServiceFactory.ss.UpdaCs(new Suppliers(name1, ctname1,
				title1, address1, code1, phone1), ssid);

		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void queryUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Integer id = ObjectUtil.toInteger(request.getParameter("id"));
		// System.out.println(id);
		List<Map<String, Object>> ss = ServiceFactory.ss.QueryById(id);
		// System.out.println(ss);
		JSONArray json = JSONArray.fromObject(ss.get(0));
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = ObjectUtil.toString(request.getParameter("name"));
		String ctname = ObjectUtil.toString(request.getParameter("ctname"));
		String title = ObjectUtil.toString(request.getParameter("title"));
		String phone = ObjectUtil.toString(request.getParameter("phone"));
		String code = ObjectUtil.toString(request.getParameter("code"));
		String address = ObjectUtil.toString(request.getParameter("address"));
		boolean res = ServiceFactory.ss.AddCs(new Suppliers(name, ctname,
				title, phone, code, address));
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void empQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String ctname = ObjectUtil.toString(request
				.getParameter("q_contacttitle"));
		String name = ObjectUtil
				.toString(request.getParameter("q_companyName"));
		String phone = ObjectUtil.toString(request.getParameter("q_phone"));
		Integer pageSize = ObjectUtil.toInteger(request
				.getParameter("pageSize"));
		Integer pageNum = ObjectUtil.toInteger(request.getParameter("pageNum"));
		PageList page = ServiceFactory.ss.QueryByPage(new Suppliers(ctname,
				name, phone), pageSize, pageNum);
		// System.out.println(page);
		request.setAttribute("page", page);
		request.setAttribute("ctname", ctname);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("../jsp/back/suppliersManger.jsp")
				.forward(request, response);

	}
}
