package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Shippers;

public interface IShippersDAO {
	public List<Map<String, Object>> QueryAll();

	public boolean AddPs(Shippers shi);

	public List<Map<String, Object>> QueryById(Integer id);

	public boolean UpdaPs(Shippers shi, Integer id);

	public boolean DelPs(String ids);
}
