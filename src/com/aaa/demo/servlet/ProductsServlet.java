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
import com.aaa.demo.entity.Products;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class ProductsServlet extends HttpServlet {

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
		String ids = request.getParameter("ids");

		PrintWriter out = response.getWriter();
		out.print(ServiceFactory.ps.DelPs(ids) == true ? 1 : 2);
		out.flush();
		out.close();

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Integer pid = ObjectUtil.toInteger(request.getParameter("pid"));
		String name = ObjectUtil.toString(request.getParameter("name"));

		Integer sid = ObjectUtil.toInteger(request.getParameter("sid"));

		Integer cid = ObjectUtil.toInteger(request.getParameter("cid"));

		String quantity = ObjectUtil.toString(request.getParameter("quantity"));

		String price = ObjectUtil.toString(request.getParameter("price"));

		Integer instock = ObjectUtil.toInteger(request.getParameter("instock"));

		Integer onorder = ObjectUtil.toInteger(request.getParameter("onorder"));

		Integer reorder = ObjectUtil.toInteger(request.getParameter("reorder"));

		Integer discontinued = ObjectUtil.toInteger(request
				.getParameter("discontinued"));
		boolean res = ServiceFactory.ps.UpdaPs(new Products(name, sid, cid,
				quantity, price, instock, onorder, reorder, discontinued), pid);

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
		List<Map<String, Object>> ps = ServiceFactory.ps.QueryById(id);
		// System.out.println(ss);
		JSONArray json = JSONArray.fromObject(ps.get(0));
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = ObjectUtil.toString(request.getParameter("name"));
		// System.out.println(name);
		Integer sid = ObjectUtil.toInteger(request.getParameter("sid"));
		// System.out.println(sid);
		Integer cid = ObjectUtil.toInteger(request.getParameter("cid"));
		// System.out.println(cid);
		String quantity = ObjectUtil.toString(request.getParameter("quantity"));
		// System.out.println(quantity);
		String price = ObjectUtil.toString(request.getParameter("price"));
		// System.out.println(price);
		Integer instock = ObjectUtil.toInteger(request.getParameter("instock"));
		// System.out.println(instock);
		Integer onorder = ObjectUtil.toInteger(request.getParameter("onorder"));
		// System.out.println(onorder);
		Integer reorder = ObjectUtil.toInteger(request.getParameter("reorder"));
		// System.out.println(reorder);
		Integer discontinued = ObjectUtil.toInteger(request
				.getParameter("discontinued"));
		// System.out.println(discontinued);
		// System.out.println(sid);
		boolean res = ServiceFactory.ps.AddPs(new Products(name, sid, cid,
				quantity, price, instock, onorder, reorder, discontinued));
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void empQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer pid = ObjectUtil
				.toInteger(request.getParameter("q_productsID"));
		String pname = ObjectUtil.toString(request
				.getParameter("q_productsName"));
		Integer pageSize = ObjectUtil.toInteger(request
				.getParameter("pageSize"));
		Integer pageNum = ObjectUtil.toInteger(request.getParameter("pageNum"));
		PageList page = ServiceFactory.ps.QueryByPage(new Products(pid, pname),
				pageSize, pageNum);
		List<Map<String, Object>> cat = ServiceFactory.cats.QueryAll();
		List<Map<String, Object>> supp = ServiceFactory.ss.QueryAll(null);
		request.setAttribute("cat", cat);
		request.setAttribute("supp", supp);
		request.setAttribute("page", page);
		request.setAttribute("pid", pid);
		request.setAttribute("pname", pname);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("pageNum", pageNum);
		request.getRequestDispatcher("../jsp/back/ProductsManger.jsp").forward(
				request, response);

	}
}
