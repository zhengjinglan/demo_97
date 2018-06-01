package com.aaa.demo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IMenuOneDAO;
import com.aaa.demo.entity.MenuOne;
import com.aaa.demo.factory.BaseDAO;

public class MenuOneDAOImpl implements IMenuOneDAO {

	public List<MenuOne> getMenu() {
		String sql = "select moid,name from menuOne";
		List<Map<String, Object>> list = BaseDAO.Query(sql, null);
		List<MenuOne> mlist = new ArrayList<MenuOne>();
		for (Map<String, Object> map : list) {
			MenuOne one = new MenuOne();
			one.setMoid(Integer.parseInt(map.get("moid").toString()));
			one.setName(map.get("name").toString());

			mlist.add(one);
		}
		return mlist;
	}

}
