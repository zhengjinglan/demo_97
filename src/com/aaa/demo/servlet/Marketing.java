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

import com.aaa.demo.entity.OrderDetails;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;
import com.aaa.demo.util.getPrimaryId;

public class Marketing extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String methods = request.getParameter("methods");
		switch (methods) {
		case "add":
			this.add(request, response);
			break;
		case "queryByPro":
			this.QueryByPro(request, response);
			break;
		case "query":
			this.Query(request, response);
			break;
		default:
			response.sendRedirect("../jsp/error/methodError.jsp");
			break;
		}
	}

	private void QueryByPro(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Integer id = ObjectUtil.toInteger(request.getParameter("id"));
		List<Map<String, Object>> pro = ServiceFactory.ps.QueryByCaId(id);
		// System.out.println(pro);
		PrintWriter out = response.getWriter();
		JSONArray json = JSONArray.fromObject(pro);
		out.print(json);
		out.flush();
		out.close();

	}

	private void Query(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Map<String, Object>> cu = ServiceFactory.cs.QueryAll(null);
		List<Map<String, Object>> ca = ServiceFactory.cats.QueryAll();
		// List<Map<String, Object>> od = ServiceFactory.details.QueryAll();
		request.setAttribute("cs", cu);
		request.setAttribute("ca", ca);
		// request.setAttribute("od", od);
		request.getRequestDispatcher("../jsp/back/Marketing.jsp").forward(
				request, response);

	}

	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		Integer oid = getPrimaryId.getOrderId();
		Integer gid = ObjectUtil.toInteger(request.getParameter("goods"));
		String money = ObjectUtil.toString(request.getParameter("price"));
		Integer num = ObjectUtil.toInteger(request.getParameter("num"));
		boolean res = ServiceFactory.details.AddOd(new OrderDetails(oid, gid,
				money, num));
		PrintWriter out = response.getWriter();
		if (res) {
			out.print(1);
		} else {
			out.print(0);
		}
	}
}
