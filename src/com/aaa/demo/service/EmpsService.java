package com.aaa.demo.service;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.aaa.demo.entity.Emps;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.DAOFactory;

public class EmpsService {
	public boolean QueryNameByPwd(String name, String pwd, String nologin,
			HttpSession session, HttpServletResponse response)
			throws UnsupportedEncodingException {
		List<Map<String, Object>> list = DAOFactory.emps.QueryNameByPwd(name,
				pwd);
		if (list.size() == 1) {
			session.setAttribute("user", list.get(0));
			// System.out.println(list.get(0));
			if ("on".equals(nologin)) {
				Cookie namecookie = new Cookie("name", URLEncoder.encode(name,
						"utf-8"));
				Cookie pwdcookie = new Cookie("password", pwd);
				namecookie.setMaxAge(60 * 60 * 24 * 7);
				pwdcookie.setMaxAge(60 * 60 * 24 * 7);
				response.addCookie(namecookie);
				response.addCookie(pwdcookie);
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean checkCookieUser(String name, String pwd) {
		List<Map<String, Object>> list = DAOFactory.emps.QueryNameByPwd(name,
				pwd);
		if (list.size() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public List<Map<String, Object>> QueryAll(Emps emp) {
		// System.out.println(EmpsDAOFactory.emps.QueryByPage());
		return DAOFactory.emps.QueryAll(emp);
	}

	// 添加员工
	public int addEmployee(Emps e) {
		return DAOFactory.emps.AddEmp(e);
	}

	public List<Map<String, Object>> QueryById(int id) {
		return DAOFactory.emps.queryByID(id);
	}

	public boolean UpdateEmp(Emps emp, int id) {
		return DAOFactory.emps.UpdateEmp(emp, id);
	}

	public int DelEmp(int id) {
		return DAOFactory.emps.DelEmp(id);
	}

	public PageList QueryByPage(Emps emp, Integer pageSize, Integer pageNum) {
		return DAOFactory.emps.QueryByPage(emp, pageSize, pageNum);
	}

}
