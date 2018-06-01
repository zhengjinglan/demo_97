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

import com.aaa.demo.entity.Customers;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class CustomersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methods = request.getParameter("methods");
		// System.out.println(methods);
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
		String id = request.getParameter("id");
		String[] ids = id.split(",");
		int flag = 0;
		for (int i = 0; i < ids.length; i++) {
			flag = ServiceFactory.cs.DelCs(ids[i]);
		}
		PrintWriter out = response.getWriter();

		if (flag > 0) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String id = ObjectUtil.toString(request.getParameter("id"));
		String name = ObjectUtil.toString(request.getParameter("name"));
		String ctname = ObjectUtil.toString(request.getParameter("ctname"));
		String title = ObjectUtil.toString(request.getParameter("title"));
		String phone = ObjectUtil.toString(request.getParameter("phone"));
		String address = ObjectUtil.toString(request.getParameter("address"));
		boolean res = ServiceFactory.cs.UpdaCs(new Customers(id, name, ctname,
				title, address, phone), id);
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void queryUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String id = ObjectUtil.toString(request.getParameter("id"));

		List<Map<String, Object>> query = ServiceFactory.cs.QueryById(id);
		// System.out.println(query);
		JSONArray json = JSONArray.fromObject(query.get(0));
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		// TODO Auto-generated method stub
		String id = ObjectUtil.toString(request.getParameter("id"));
		String name = ObjectUtil.toString(request.getParameter("name"));
		String ctname = ObjectUtil.toString(request.getParameter("ctname"));
		String title = ObjectUtil.toString(request.getParameter("title"));
		String phone = ObjectUtil.toString(request.getParameter("phone"));
		String address = ObjectUtil.toString(request.getParameter("address"));
		boolean res = ServiceFactory.cs.AddCs(new Customers(id, name, ctname,
				title, phone, address));
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}
	}

	private void empQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String cname = ObjectUtil.toString(request
				.getParameter("q_companyName"));
		// System.out.println(id);
		String name = ObjectUtil
				.toString(request.getParameter("q_contactName"));
		String phone = ObjectUtil.toString(request.getParameter("q_phone"));
		Integer pageSize = ObjectUtil.toInteger(request
				.getParameter("pageSize"));
		Integer pageNum = ObjectUtil.toInteger(request.getParameter("pageNum"));
		PageList page = ServiceFactory.cs.QueryByPage(new Customers(cname,
				name, phone), pageSize, pageNum);
		// System.out.println(cs);
		request.setAttribute("page", page);
		request.setAttribute("cname", cname);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("../jsp/back/custormeManger.jsp").forward(
				request, response);

	}
}
