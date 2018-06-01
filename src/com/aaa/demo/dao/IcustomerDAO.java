package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Customers;
import com.aaa.demo.entity.PageList;

public interface IcustomerDAO {
	public List<Map<String, Object>> QueryAll(Customers cs);

	public PageList QueryByPage(Customers cs, Integer pageSize, Integer pageNum);

	public boolean AddCs(Customers cs);

	public List<Map<String, Object>> QueryById(String id);

	public boolean UpdaCs(Customers cs, String id);

	public int DelCs(String id);
}
