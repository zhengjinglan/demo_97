package com.aaa.demo.entity;

import java.util.List;
import java.util.Map;

public class PageList {
	private int pageSize;
	private int pageNum;
	private List<Map<String, Object>> list;
	private int pagecounts;
	
	public PageList(int pageSize, int pageNum, List<Map<String, Object>> list, int pagecounts) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.list = list;
		this.pagecounts = pagecounts;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public List<Map<String, Object>> getList() {
		return list;
	}
	public void setList(List<Map<String, Object>> list) {
		this.list = list;
	}
	public int getPagecounts() {
		return pagecounts;
	}
	public void setPagecounts(int pagecounts) {
		this.pagecounts = pagecounts;
	}
	public String toString() {
		return "PageList [pageSize=" + pageSize + ", pageNum=" + pageNum + ", list=" + list + ", pagecounts="
				+ pagecounts + "]";
	}
	
}
