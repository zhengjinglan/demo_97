package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Categories;

public interface ICategoriesDAO {
	public List<Map<String, Object>> QueryAll();

	public boolean AddPs(Categories cat);

	public List<Map<String, Object>> QueryById(Integer id);

	public boolean UpdaPs(Categories cat, Integer id);

	public boolean DelPs(String ids);
}
