package com.aaa.demo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseDAO {

	private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url = "jdbc:sqlserver://localhost:1433;databasename=northwind";
	private static String user = "sa";
	private static String pwd = "123@qwe";

	// 1.获取链接
	public static Connection getConn() {
		Connection conn = null;
		try {
			// 加载驱动
			Class.forName(driver);
			// 连接数据库
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 参数
	public static void setParams(PreparedStatement pst, Object[] params) {
		if (params == null) {
			return;
		} else {
			try {
				for (int i = 0; i < params.length; i++) {
					pst.setObject(i + 1, params[i]);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 增删改
	 * 
	 * @param sql
	 *            执行sql语句
	 * @return
	 */
	public static int exectUpdate(String sql, Object[] params) {
		Connection conn = null;
		PreparedStatement pst = null;
		int res = 0;
		try {
			conn = getConn();
			// 预执行SQL
			pst = conn.prepareStatement(sql);
			// 执行SQL语句
			setParams(pst, params);
			// 返回受影响的行数
			res = pst.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, null);
		}
		return res;

	}

	/**
	 * 查询
	 * 
	 * @param sql
	 *            执行的sql语句
	 * @param objs
	 *            sql中的参数
	 * @return
	 */
	public static List<Map<String, Object>> Query(String sql, Object[] objs) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		List<Map<String, Object>> rowlist = new ArrayList<Map<String, Object>>();
		try {
			conn = getConn();
			pst = conn.prepareStatement(sql);
			setParams(pst, objs);
			// 获取查询结果
			rs = pst.executeQuery();
			// 获取结果集结构(列的结构)
			ResultSetMetaData rsd = rs.getMetaData();
			// 获取结果集列数
			int columns = rsd.getColumnCount();
			// 循环获取每一行
			while (rs.next()) {
				// 封装每一行
				Map<String, Object> map = new HashMap<String, Object>();
				// 获取当前行的每一列的值

				for (int i = 1; i <= columns; i++) {
					// 当前列的值ֵ
					Object value = rs.getObject(i);
					// 当前列的列名
					String columnsName = rsd.getColumnName(i);
					// 每一行中的某一列
					map.put(columnsName, value);
				}
				rowlist.add(map);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeAll(conn, pst, rs);
		}
		return rowlist;
	}

	// 4.关闭
	public static void closeAll(Connection conn, Statement st, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
