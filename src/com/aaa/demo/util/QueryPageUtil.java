package com.aaa.demo.util;

import com.aaa.demo.entity.PageList;
import com.aaa.demo.factory.BaseDAO;

public class QueryPageUtil {

	// 分页

	public static PageList queryPage(String sql, Integer pageNum,
			Integer pageSize, Object[] objs) {

		// 默认每页显示5条数据
		if (null == pageSize) {
			pageSize = 5;
		}
		// 获取总条数
		int counts = BaseDAO.Query(sql, objs).size();

		int pageCounts = 0;
		// 计算总页数
		if (counts % pageSize == 0) {
			pageCounts = counts / pageSize;
		} else {
			pageCounts = counts / pageSize + 1;
		}
		// 页数为空默认查询第一页
		if (pageNum == null) {
			pageNum = 1;
		}
		// 判断当前页数是否正确
		if (pageNum < 1) {
			pageNum = 1;
		} else if (pageNum > pageCounts) {
			pageNum = pageCounts;
		}

		// 拼接SQL语句
		sql = sql + " offset " + pageSize * (pageNum - 1) + " rows fetch next "
				+ pageSize + " rows only";

		return new PageList(pageSize, pageNum, BaseDAO.Query(sql, objs),
				pageCounts);
	}
}
