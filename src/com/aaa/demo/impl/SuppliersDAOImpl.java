package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.ISuppliersDAO;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Suppliers;
import com.aaa.demo.factory.BaseDAO;
import com.aaa.demo.util.QueryPageUtil;

public class SuppliersDAOImpl implements ISuppliersDAO {

	@Override
	public List<Map<String, Object>> QueryAll(Suppliers su) {
		String sql = "select SupplierID,CompanyName,ContactName,ContactTitle,"
				+ "Address,PostalCode,Phone from Suppliers where 1=1 ";
		if (su != null) {
			if (su.getContactTitle() != null) {
				sql = sql + " and ContactTitle like '%" + su.getContactTitle()
						+ "%'";
			}
			if (su.getCompanyName() != null) {
				sql = sql + " and CompanyName like '%" + su.getCompanyName()
						+ "%'";
			}
			if (su.getPhone() != null) {
				sql = sql + " and Phone like '%" + su.getPhone() + "%'";
			}
		}
		sql = sql + " order by SupplierID";
		return BaseDAO.Query(sql, null);
	}

	@Override
	public PageList QueryByPage(Suppliers su, Integer pageSize, Integer pageNum) {
		String sql = "select SupplierID,CompanyName,ContactName,ContactTitle,"
				+ "Address,PostalCode,Phone from Suppliers where 1=1 ";
		if (su != null) {
			if (su.getContactTitle() != null) {
				sql = sql + " and ContactTitle like '%" + su.getContactTitle()
						+ "%'";
			}
			if (su.getCompanyName() != null) {
				sql = sql + " and CompanyName like '%" + su.getCompanyName()
						+ "%'";
			}
			if (su.getPhone() != null) {
				sql = sql + " and Phone like '%" + su.getPhone() + "%'";
			}
		}
		sql = sql + " order by SupplierID";
		return QueryPageUtil.queryPage(sql, pageNum, pageSize, null);
	}

	@Override
	public boolean AddCs(Suppliers su) {
		String sql = "insert into Suppliers(CompanyName,ContactName,"
				+ "ContactTitle,Address,PostalCode,Phone) values(?,?,?,?,?,?)";
		int res = BaseDAO.exectUpdate(
				sql,
				new Object[] { su.getCompanyName(), su.getContactName(),
						su.getContactTitle(), su.getAddress(),
						su.getPostalCode(), su.getPhone() });
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryById(int id) {
		String sql = "select SupplierID,CompanyName,ContactName,ContactTitle,"
				+ "Address,PostalCode,Phone from Suppliers where SupplierID=? ";
		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public boolean UpdaCs(Suppliers su, int id) {
		String sql = "update Suppliers set CompanyName=?,ContactName=?,"
				+ "ContactTitle=?,Address=?,PostalCode=?,Phone=? "
				+ "where SupplierID=?";
		int res = BaseDAO.exectUpdate(
				sql,
				new Object[] { su.getCompanyName(), su.getContactName(),
						su.getContactTitle(), su.getAddress(),
						su.getPostalCode(), su.getPhone(), id });
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int DelCs(int id) {
		String sql = "delete from Suppliers where SupplierID=?";

		return BaseDAO.exectUpdate(sql, new Object[] { id });

	}

}
