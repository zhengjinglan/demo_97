package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Categories;
import com.aaa.demo.factory.DAOFactory;

public class CategoriesService {
	public List<Map<String, Object>> QueryAll() {
		return DAOFactory.cat.QueryAll();
	}

	public boolean AddPs(Categories cat) {
		return DAOFactory.cat.AddPs(cat);
	}

	public List<Map<String, Object>> QueryById(Integer id) {
		return DAOFactory.cat.QueryById(id);
	}

	public boolean UpdaPs(Categories cat, Integer id) {
		return DAOFactory.cat.UpdaPs(cat, id);
	}

	public boolean DelPs(String ids) {
		return DAOFactory.cat.DelPs(ids);
	}
}
