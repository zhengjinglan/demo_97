package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Suppliers;
import com.aaa.demo.factory.DAOFactory;

public class SuppliersService {
	public List<Map<String, Object>> QueryAll(Suppliers su) {
		return DAOFactory.sup.QueryAll(su);
	}

	public PageList QueryByPage(Suppliers su, Integer pageSize, Integer pageNum) {
		return DAOFactory.sup.QueryByPage(su, pageSize, pageNum);
	}

	public boolean AddCs(Suppliers su) {
		return DAOFactory.sup.AddCs(su);
	}

	public List<Map<String, Object>> QueryById(int id) {
		return DAOFactory.sup.QueryById(id);
	}

	public boolean UpdaCs(Suppliers su, int id) {
		return DAOFactory.sup.UpdaCs(su, id);
	}

	public int DelCs(int id) {
		return DAOFactory.sup.DelCs(id);
	}
}
