package com.aaa.demo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IMenuTwoDAO;
import com.aaa.demo.entity.MenuTwo;
import com.aaa.demo.factory.BaseDAO;

public class MenuTwoDAOImpl implements IMenuTwoDAO {

	@Override
	public List<MenuTwo> getMtlist(int moid) {
		String sql = "select id,name,url,moid from menuTwo where moid=?";
		List<Map<String, Object>> list = BaseDAO.Query(sql,
				new Object[] { moid });

		List<MenuTwo> rslist = new ArrayList<MenuTwo>();
		for (Map<String, Object> row : list) {
			MenuTwo two = new MenuTwo();
			two.setId(Integer.parseInt(row.get("id").toString()));
			two.setName(row.get("name").toString());
			two.setUrl(row.get("url").toString());
			two.setMoid(moid);

			rslist.add(two);
		}

		return rslist;
	}

}
