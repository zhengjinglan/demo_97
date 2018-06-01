package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.ICategoriesDAO;
import com.aaa.demo.entity.Categories;
import com.aaa.demo.factory.BaseDAO;

public class CategoriesDAOImpl implements ICategoriesDAO {

	@Override
	public List<Map<String, Object>> QueryAll() {
		String sql = "select CategoryID,CategoryName,Description,photo "
				+ "from Categories ";

		return BaseDAO.Query(sql, null);
	}

	@Override
	public boolean AddPs(Categories cat) {
		String sql = "insert into Categories (CategoryName,"
				+ "Description,photo) values(?,?,?)";
		Object[] objs = { cat.getCategoryName(), cat.getDescription(),
				cat.getPicture() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryById(Integer id) {
		String sql = "select CategoryID,CategoryName,Description,photo "
				+ "from Categories where CategoryID=?";

		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public boolean UpdaPs(Categories cat, Integer id) {
		String sql = "update Categories set CategoryName=?,Description=?,"
				+ "photo=? where  CategoryID=?";
		Object[] objs = { cat.getCategoryName(), cat.getDescription(),
				cat.getPicture(), id };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean DelPs(String ids) {
		String sql = "delete from Categories where CategoryID in (" + ids + ")";
		boolean rs = true;
		try {
			BaseDAO.exectUpdate(sql, null);
		} catch (Exception e) {
			rs = false;
		}
		return rs;
	}
}
