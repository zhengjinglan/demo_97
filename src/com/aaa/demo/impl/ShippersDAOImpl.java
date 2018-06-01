package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IShippersDAO;
import com.aaa.demo.entity.Shippers;
import com.aaa.demo.factory.BaseDAO;

public class ShippersDAOImpl implements IShippersDAO {

	@Override
	public List<Map<String, Object>> QueryAll() {
		String sql = "select ShipperID, CompanyName,Phone from Shippers";

		return BaseDAO.Query(sql, null);
	}

	@Override
	public boolean AddPs(Shippers shi) {
		String sql = "insert into Shippers(CompanyName,Phone) values(?,?)";
		Object[] objs = { shi.getCompanyName(), shi.getPhone() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryById(Integer id) {
		String sql = "select ShipperID,CompanyName,Phone from Shippers where ShipperID=?";

		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public boolean UpdaPs(Shippers shi, Integer id) {
		String sql = "update Shippers set CompanyName=?,Phone=? where ShipperID=?";
		Object[] objs = { shi.getCompanyName(), shi.getPhone(), id };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean DelPs(String ids) {
		String sql = "delete from Shippers where ShipperID in (" + ids + ")";
		boolean rs = true;
		try {
			BaseDAO.exectUpdate(sql, null);
		} catch (Exception e) {
			rs = false;
		}
		return rs;
	}

}
