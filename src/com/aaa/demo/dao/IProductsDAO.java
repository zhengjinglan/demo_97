package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Products;

public interface IProductsDAO {
	public List<Map<String, Object>> QueryAll(Products ps);

	public PageList QueryByPage(Products ps, Integer pageSize, Integer pageNum);

	public boolean AddPs(Products ps);

	public List<Map<String, Object>> QueryById(Integer id);

	public List<Map<String, Object>> QueryByCaId(Integer id);

	public boolean UpdaPs(Products ps, Integer id);

	public boolean DelPs(String ids);
}
