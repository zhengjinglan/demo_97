package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Shippers;
import com.aaa.demo.factory.DAOFactory;

public class ShippersService {
	public List<Map<String, Object>> QueryAll() {
		return DAOFactory.shi.QueryAll();
	}

	public boolean AddPs(Shippers shi) {
		return DAOFactory.shi.AddPs(shi);
	}

	public List<Map<String, Object>> QueryById(Integer id) {
		return DAOFactory.shi.QueryById(id);
	}

	public boolean UpdaPs(Shippers shi, Integer id) {
		return DAOFactory.shi.UpdaPs(shi, id);
	}

	public boolean DelPs(String ids) {
		return DAOFactory.shi.DelPs(ids);
	}
}
