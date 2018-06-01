package com.aaa.demo.dao;

import java.util.List;
import java.util.Map;

import com.aaa.demo.entity.Emps;
import com.aaa.demo.entity.PageList;

public interface IEmpsDAO {

	public List<Map<String, Object>> QueryNameByPwd(String name, String pwd);

	public List<Map<String, Object>> QueryAll(Emps emp);

	public int AddEmp(Emps emp);

	public List<Map<String, Object>> queryByID(int id);

	public int DelEmp(int id);

	public boolean UpdateEmp(Emps emp, int id);

	public PageList QueryByPage(Emps emp, Integer pageSize, Integer pageNum);
}
