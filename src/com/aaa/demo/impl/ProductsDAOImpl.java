package com.aaa.demo.impl;

import java.util.List;
import java.util.Map;

import com.aaa.demo.dao.IProductsDAO;
import com.aaa.demo.entity.PageList;
import com.aaa.demo.entity.Products;
import com.aaa.demo.factory.BaseDAO;
import com.aaa.demo.util.QueryPageUtil;

public class ProductsDAOImpl implements IProductsDAO {

	@Override
	public List<Map<String, Object>> QueryAll(Products ps) {
		String sql = "select p.ProductID,p.ProductName,s.CompanyName,"
				+ "c.CategoryName,p.QuantityPerUnit,p.UnitPrice,"
				+ "p.UnitsInStock,p.UnitsOnOrder,p.ReorderLevel,p.Discontinued "
				+ " from  Products p join Categories c "
				+ " on p.CategoryID=c.CategoryID join Suppliers s "
				+ "on p.SupplierID= s.SupplierID " + " where 1=1 ";
		if (ps != null) {
			if (ps.getProductID() != null) {
				sql = sql + " and ProductID '" + ps.getProductID() + "'";
			}
			if (ps.getProductName() != null) {
				sql = sql + " and ProductName like '%" + ps.getProductName()
						+ "%'";
			}
		}

		sql = sql + " order by ProductID ";
		return BaseDAO.Query(sql, null);
	}

	@Override
	public PageList QueryByPage(Products ps, Integer pageSize, Integer pageNum) {
		String sql = "select p.ProductID,p.ProductName,s.CompanyName,"
				+ "c.CategoryName,p.QuantityPerUnit,p.UnitPrice,"
				+ "p.UnitsInStock,p.UnitsOnOrder,p.ReorderLevel,p.Discontinued "
				+ " from  Products p join Categories c "
				+ " on p.CategoryID=c.CategoryID join Suppliers s "
				+ "on p.SupplierID= s.SupplierID " + " where 1=1 ";
		if (ps != null) {
			if (ps.getProductID() != null) {
				sql = sql + " and p.ProductID = '" + ps.getProductID() + "'";
			}
			if (ps.getProductName() != null) {
				sql = sql + " and p.ProductName like '%" + ps.getProductName()
						+ "%'";
			}
		}

		sql = sql + " order by ProductID ";

		return QueryPageUtil.queryPage(sql, pageNum, pageSize, null);
	}

	@Override
	public boolean AddPs(Products ps) {
		String sql = "insert into Products(ProductName,SupplierID,CategoryID,"
				+ "QuantityPerUnit,UnitPrice,UnitsInStock,UnitsOnOrder,"
				+ "ReorderLevel,Discontinued) values(?,?,?,?,?,?,?,?,?)";
		Object[] objs = { ps.getProductName(), ps.getSupplierID(),
				ps.getCategoryID(), ps.getQuantityPerUnit(), ps.getUnitPrice(),
				ps.getUnitsInStock(), ps.getUnitsOnOrder(),
				ps.getReorderLevel(), ps.getDiscontinued() };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public List<Map<String, Object>> QueryById(Integer id) {
		String sql = "select p.ProductID,p.ProductName,s.CompanyName,"
				+ "c.CategoryName,p.QuantityPerUnit,p.UnitPrice,"
				+ "p.UnitsInStock,p.UnitsOnOrder,p.ReorderLevel,p.Discontinued "
				+ " from  Products p join Categories c "
				+ " on p.CategoryID=c.CategoryID join Suppliers s "
				+ "on p.SupplierID= s.SupplierID " + " where p.ProductID=? ";
		return BaseDAO.Query(sql, new Object[] { id });
	}

	@Override
	public boolean UpdaPs(Products ps, Integer id) {
		String sql = "update Products set ProductName=?,SupplierID=?,CategoryID=?,"
				+ "QuantityPerUnit=?,UnitPrice=?,UnitsInStock=?,"
				+ "UnitsOnOrder=?,ReorderLevel=?,Discontinued=? "
				+ " where ProductID=?";
		Object[] objs = { ps.getProductName(), ps.getSupplierID(),
				ps.getCategoryID(), ps.getQuantityPerUnit(), ps.getUnitPrice(),
				ps.getUnitsInStock(), ps.getUnitsOnOrder(),
				ps.getReorderLevel(), ps.getDiscontinued(), id };
		int res = BaseDAO.exectUpdate(sql, objs);
		if (res == 1) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean DelPs(String ids) {
		String sql = "delete from Products where ProductID in (" + ids + ")";
		// System.out.println(sql);
		boolean rs = true;
		try {
			BaseDAO.exectUpdate(sql, null);
		} catch (Exception e) {
			rs = false;
		}
		return rs;
	}

	@Override
	public List<Map<String, Object>> QueryByCaId(Integer id) {
		String sql = "select p.ProductID,p.ProductName,s.CompanyName,"
				+ "c.CategoryID,c.CategoryName,p.QuantityPerUnit,p.UnitPrice,"
				+ "p.UnitsInStock,p.UnitsOnOrder,p.ReorderLevel,p.Discontinued "
				+ " from  Products p join Categories c "
				+ " on p.CategoryID=c.CategoryID join Suppliers s "
				+ "on p.SupplierID= s.SupplierID " + " where c.CategoryID=? ";
		return BaseDAO.Query(sql, new Object[] { id });
	}

}
