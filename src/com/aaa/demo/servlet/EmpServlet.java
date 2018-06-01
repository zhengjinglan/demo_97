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

import com.aaa.demo.entity.Emps;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.ServiceFactory;
import com.aaa.demo.util.ObjectUtil;

public class EmpServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methods = request.getParameter("methods");
		switch (methods) {
		case "emp":
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
		// System.out.println(id);
		String[] ids = id.split(",");

		int flag = 0;
		for (int i = 0; i < ids.length; i++) {
			flag = ServiceFactory.emp.DelEmp(Integer.parseInt(ids[i]));
			// System.out.println(Integer.parseInt(ids[i]));
		}
		PrintWriter out = response.getWriter();

		if (flag > 0) {
			out.print("删除成功");
		} else {
			out.print("删除失败");
		}

	}

	private void queryUpdate(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		Integer id = Integer.parseInt(request.getParameter("id"));

		List<Map<String, Object>> query = ServiceFactory.emp.QueryById(id);
		// System.out.println(query.get(0));
		JSONArray json = JSONArray.fromObject(query.get(0));
		PrintWriter out = response.getWriter();
		out.print(json);
		out.flush();
		out.close();

	}

	private void update(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = ObjectUtil.toString(request.getParameter("name"));
		// System.out.println(name);
		String birthday = ObjectUtil.toString(request.getParameter("birthday"));
		String rutime = ObjectUtil.toString(request.getParameter("rudate"));
		String address = ObjectUtil.toString(request.getParameter("address"));
		String phone = ObjectUtil.toString(request.getParameter("phone"));
		String pwd = ObjectUtil.toString(request.getParameter("pwd"));
		Integer id = Integer.parseInt(request.getParameter("id"));
		Emps e = new Emps();
		// System.out.println(e);
		e.setLastName(name);

		e.setBirthDate(birthday);

		e.setHireDate(rutime);

		e.setAddress(address);
		e.setHomePhone(phone);
		e.setPwd(pwd);
		e.setEmployeeID(id);

		boolean flag = ServiceFactory.emp.UpdateEmp(e, id);
		PrintWriter out = response.getWriter();
		if (flag) {
			out.print(1);
		} else {
			out.print(0);
		}

	}

	private void empQuery(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Integer id = ObjectUtil.toInteger(request.getParameter("q_employeeID"));
		// System.out.println(id);
		String name = ObjectUtil.toString(request.getParameter("q_lastName"));
		String phone = ObjectUtil.toString(request.getParameter("q_phone"));
		Integer pageSize = ObjectUtil.toInteger(request
				.getParameter("pageSize"));
		Emps emp = new Emps(id, name, phone);
		Integer pageNum = ObjectUtil.toInteger(request.getParameter("pageNum"));
		PageList page = ServiceFactory.emp.QueryByPage(emp, pageSize, pageNum);
		request.setAttribute("page", page);
		request.setAttribute("emp", emp);
		request.setAttribute("id", id);
		request.setAttribute("name", name);
		request.setAttribute("phone", phone);
		request.getRequestDispatcher("../jsp/back/employeeManager.jsp")
				.forward(request, response);

	}

	// 添加员工
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String name = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		String rutime = request.getParameter("rudate");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String pwd = request.getParameter("pwd");
		Emps e = new Emps();
		e.setLastName(name);
		e.setBirthDate(birthday);
		e.setHireDate(rutime);
		e.setAddress(address);
		e.setPwd(pwd);
		e.setHomePhone(phone);

		int flag = ServiceFactory.emp.addEmployee(e);
		PrintWriter out = response.getWriter();
		if (flag > 0) {
			out.print("添加成功");
		} else {
			out.print("添加失败");
		}

	}

}
