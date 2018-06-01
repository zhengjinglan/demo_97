package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Suppliers;

public interface ISuppliersDAO {
	public List<Map<String, Object>> QueryAll(Suppliers su);

	public PageList QueryByPage(Suppliers su, Integer pageSize, Integer pageNum);

	public boolean AddCs(Suppliers su);

	public List<Map<String, Object>> QueryById(int id);

	public boolean UpdaCs(Suppliers su, int id);

	public int DelCs(int id);
}
