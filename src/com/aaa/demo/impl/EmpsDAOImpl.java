package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IEmpsDAO;
import com.aaa.demo.entity.Emps;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.BaseDAO;
import com.aaa.demo.util.QueryPageUtil;

public class EmpsDAOImpl implements IEmpsDAO {

	@Override
	public List<Map<String, Object>> QueryNameByPwd(String name, String pwd) {
		String sql = "select employeeID,lastName,title,BirthDate,hireDate,address,"
				+ "pwd,homePhone,photo,notes,reportsTo "
				+ "from Employees Where lastName=? and pwd=?";
		return BaseDAO.Query(sql, new Object[] { name, pwd });
	}

	@Override
	public List<Map<String, Object>> QueryAll(Emps emp) {
		String sql = "select EmployeeID,pwd,lastName,BirthDate,"
				+ "DATEDIFF(YYYY,BirthDate,GETDATE()) age,"
				+ "hireDate,datediff(YYYY,hireDate,GETDATE()) hireAge,homePhone,"
				+ "address,photo from Employees where 1=1 ";
		if (emp != null) {
			if (emp.getEmployeeID() != null) {
				sql = sql + " and EmployeeID=" + emp.getEmployeeID();
			}
			if (emp.getLastName() != null) {
				sql = sql + " and lastName like '%" + emp.getLastName() + "%'";
			}
			if (emp.getHomePhone() != null) {
				sql = sql + " and homePhone like '%" + emp.getHomePhone()
						+ "%'";
			}
		}
		// System.out.println(sql);
		sql = sql + " order by EmployeeID ";
		return BaseDAO.Query(sql, null);

	}

	@Override
	public int AddEmp(Emps emp) {
		String sql = "insert into Employees(lastName,BirthDate,hireDate,"
				+ "address,pwd,homePhone,photo) values(?,?,?,?,?,?,?)";
		Object[] params = { emp.getLastName(), emp.getBirthDate(),
				emp.getHireDate(), emp.getAddress(), emp.getPwd(),
				emp.getHomePhone(), emp.getPhoto() };
		return BaseDAO.exectUpdate(sql, params);
	}

	@Override
	public int DelEmp(int id) {
		String sql = "delete Employees where EmployeeID=?";
		Object[] params = { id };
		return BaseDAO.exectUpdate(sql, params);
	}

	public boolean UpdateEmp(Emps emp, int id) {
		String sql = "update Employees set lastName=?,BirthDate=?,hireDate=?,"
				+ "address=?,homePhone=?,pwd=?,photo=? where EmployeeID=?";
		int res = BaseDAO.exectUpdate(
				sql,
				new Object[] { emp.getLastName(), emp.getBirthDate(),
						emp.getHireDate(), emp.getAddress(),
						emp.getHomePhone(), emp.getPwd(), emp.getPhoto(), id });
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> queryByID(int id) {
		String sql = "select EmployeeID,pwd,lastName,BirthDate,"
				+ "hireDate,homePhone,address from Employees where EmployeeID=? ";

		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public PageList QueryByPage(Emps emp, Integer pageSize, Integer pageNum) {
		String sql = "select EmployeeID,pwd,lastName,BirthDate,"
				+ "DATEDIFF(YYYY,BirthDate,GETDATE()) age,"
				+ "hireDate,datediff(YYYY,hireDate,GETDATE()) hireAge,homePhone,"
				+ "address,photo from Employees where 1=1 ";
		if (emp != null) {
			if (emp.getEmployeeID() != null) {
				sql = sql + " and EmployeeID=" + emp.getEmployeeID();
			}
			if (emp.getLastName() != null) {
				sql = sql + " and lastName like '%" + emp.getLastName() + "%'";
			}
			if (emp.getHomePhone() != null) {
				sql = sql + " and homePhone like '%" + emp.getHomePhone()
						+ "%'";
			}
		}
		// System.out.println(sql);
		sql = sql + " order by EmployeeID ";

		return QueryPageUtil.queryPage(sql, pageNum, pageSize, null);
	}
}
