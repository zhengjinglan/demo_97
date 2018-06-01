package com.aaa.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aaa.demo.entity.Emps;
import com.aaa.demo.factory.ServiceFactory;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class EmpImgServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String methods = "flupForm";
		switch (methods) {
		case "flupForm":
			try {
				this.flupForm(request, response);
			} catch (SmartUploadException e) {
				e.printStackTrace();
			}
			break;
		default:
			break;
		}
	}

	// 混合表单保存
	private void flupForm(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException,
			SmartUploadException {

		// 实例化文件上传对象
		SmartUpload smartupload = new SmartUpload();
		// 初始化
		smartupload.initialize(this.getServletConfig(), request, response);
		smartupload.setMaxFileSize(1024 * 1024 * 10); // 单个文件的大小
		smartupload.setTotalMaxFileSize(1024 * 1024 * 10 * 10);// 总文件大小
		smartupload.setAllowedFilesList("jpg,txt,docx");// 上传文件的类型
		smartupload.setCharset("utf-8");
		smartupload.upload();

		// 1.上传文件
		// a.获取提交的所有文件对象
		com.jspsmart.upload.Files files = smartupload.getFiles();
		Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < files.getCount(); i++) {
			// b.获取单个文件
			File file = files.getFile(i);
			// c.获取上传文件的原名
			String oldfilename = file.getFilePathName();
			map.put(file.getFileName(), "");
			// d.文件域中是否有上传的文件
			if (!"".equals(oldfilename)) {
				// e.上传文件
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddh24mmss");

				// 保存文件路径
				String newfilePath = "images/" + sdf.format(new Date()) + "_"
						+ oldfilename;
				file.saveAs(newfilePath);
				// System.out.println(newfilePath);
				map.put(file.getFileName(),
						newfilePath + ";" + map.get(file.getFileName()));
			}
		}

		// 2.保存表单信息
		Request smartrequest = smartupload.getRequest();
		String name = smartrequest.getParameter("name");
		String birthday = smartrequest.getParameter("birthday");
		String rutime = smartrequest.getParameter("rudate");
		String address = smartrequest.getParameter("address");
		String phone = smartrequest.getParameter("phone");
		String pwd = smartrequest.getParameter("pwd");
		// String photo = smartrequest.getParameter(map.get("photo"));
		Emps e = new Emps();
		e.setLastName(name);
		e.setBirthDate(birthday);
		e.setHireDate(rutime);
		e.setAddress(address);
		e.setHomePhone(phone);
		e.setPwd(pwd);
		e.setPhoto(map.get("photo"));

		int flag = ServiceFactory.emp.addEmployee(e);
		PrintWriter out = response.getWriter();
		if (flag > 0) {
			out.print("添加成功");
		} else {
			out.print("添加失败");
		}

	}

}
