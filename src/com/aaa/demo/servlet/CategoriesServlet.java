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

import com.aaa.demo.entity.Categories;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class CategoriesServlet extends HttpServlet {

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
		response.setContentType("application/json");
		String ids = ObjectUtil.toString(request.getParameter("id"));
		// System.out.println(ids);
		PrintWriter out = response.getWriter();
		out.print(ServiceFactory.cats.DelPs(ids) == true ? 1 : 2);
		out.flush();
		out.close();

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Integer cid = ObjectUtil.toInteger(request.getParameter("cid"));
		String name = ObjectUtil.toString(request.getParameter("name"));
		String description = ObjectUtil.toString(request
				.getParameter("description"));
		String picture = ObjectUtil.toString(request.getParameter("picture"));
		boolean res = ServiceFactory.cats.UpdaPs(new Categories(name,
				description, picture), cid);

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

		List<Map<String, Object>> cs = ServiceFactory.cats.QueryById(id);

		JSONArray json = JSONArray.fromObject(cs.get(0));
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {

		String name = ObjectUtil.toString(request.getParameter("name"));
		String description = ObjectUtil.toString(request
				.getParameter("description"));
		String picture = ObjectUtil.toString(request.getParameter("picture"));

		boolean res = ServiceFactory.cats.AddPs(new Categories(name,
				description, picture));
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void empQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<Map<String, Object>> list = ServiceFactory.cats.QueryAll();

		request.setAttribute("list", list);
		request.getRequestDispatcher("../jsp/back/categoriesManger.jsp")
				.forward(request, response);

	}

}
