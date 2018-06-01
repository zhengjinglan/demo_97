package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IcustomerDAO;
import com.aaa.demo.entity.Customers;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.BaseDAO;
import com.aaa.demo.util.QueryPageUtil;

public class CustomerDAOImpl implements IcustomerDAO {

	@Override
	public List<Map<String, Object>> QueryAll(Customers cs) {
		String sql = "select customerID,companyName,contactName,contactTitle,"
				+ "address,phone from Customers where 1=1 ";
		if (cs != null) {
			if (cs.getCompanyName() != null) {
				sql = sql + " and contactTitle like '%" + cs.getCompanyName()
						+ "%'";
			}
			if (cs.getContactName() != null) {
				sql = sql + " and contactName like '%" + cs.getContactName()
						+ "%'";
			}
			if (cs.getPhone() != null) {
				sql = sql + " and phone like '%" + cs.getPhone() + "%'";
			}
		}
		// System.out.println(sql);
		sql = sql + " order by customerID ";
		return BaseDAO.Query(sql, null);

	}

	@Override
	public PageList QueryByPage(Customers cs, Integer pageSize, Integer pageNum) {
		String sql = "select customerID,companyName,contactName,contactTitle,"
				+ "address,phone from Customers where 1=1 ";
		if (cs != null) {
			if (cs.getCompanyName() != null) {
				sql = sql + " and contactTitle like '%" + cs.getCompanyName()
						+ "%'";
			}
			if (cs.getContactName() != null) {
				sql = sql + " and companyName like '%" + cs.getContactName()
						+ "%'";
			}
			if (cs.getPhone() != null) {
				sql = sql + " and phone like '%" + cs.getPhone() + "%'";
			}
		}
		// System.out.println(sql);
		sql = sql + " order by customerID ";

		return QueryPageUtil.queryPage(sql, pageNum, pageSize, null);
	}

	@Override
	public boolean AddCs(Customers cs) {
		String sql = "insert into Customers(CustomerID,CompanyName,ContactName,"
				+ "ContactTitle,Address,Phone) values(?,?,?,?,?,?)";
		Object[] objs = { cs.getCustomerID(), cs.getCompanyName(),
				cs.getContactName(), cs.getContactTitle(), cs.getPhone(),
				cs.getAddress() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryById(String id) {
		String sql = "select customerID,companyName,contactName,contactTitle,"
				+ "address,phone from Customers where customerID=? ";
		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public boolean UpdaCs(Customers cs, String id) {
		String sql = "update Customers set CustomerID=?,CompanyName=?,"
				+ "ContactName=?,ContactTitle=?,Address=?,Phone=? "
				+ "where CustomerID=?";
		Object[] objs = { cs.getCustomerID(), cs.getCompanyName(),
				cs.getContactName(), cs.getContactTitle(), cs.getPhone(),
				cs.getAddress(), id };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int DelCs(String id) {
		String sql = "delete from Customers where CustomerID=?";
		return BaseDAO.exectUpdate(sql, new Object[] { id });
	}
}
