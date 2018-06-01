package com.aaa.demo.service;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Products;
import com.aaa.demo.factory.DAOFactory;

public class ProductsService {

	public List<Map<String, Object>> QueryAll(Products ps) {
		return DAOFactory.ps.QueryAll(ps);
	}

	public PageList QueryByPage(Products ps, Integer pageSize, Integer pageNum) {
		return DAOFactory.ps.QueryByPage(ps, pageSize, pageNum);
	}

	public boolean AddPs(Products ps) {
		return DAOFactory.ps.AddPs(ps);
	}

	public List<Map<String, Object>> QueryById(Integer id) {
		return DAOFactory.ps.QueryById(id);
	}

	public boolean UpdaPs(Products ps, Integer id) {
		return DAOFactory.ps.UpdaPs(ps, id);

	}

	public boolean DelPs(String ids) {
		return DAOFactory.ps.DelPs(ids);
	}

	public List<Map<String, Object>> QueryByCaId(Integer id) {
		return DAOFactory.ps.QueryByCaId(id);
	}
}
