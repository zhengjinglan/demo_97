<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>个人信息</title>
    
	 <style type="text/css">
    	table{
    		border:1px solid #ccc;
    		margin:0 auto;
    		border-collapse: collapse;
    	}
    	th,td{
    		text-align:center;
    		width:200px;
    		height:30px;
    	}
    </style>
  <script type="text/javascript" src="js/jquery-1.8.3.min.js"></script>
  </head>
  <body>
  	<h3 align="center">个人信息</h3>
    <table border="1" id="tb">
    	<tr style="background:blue">
    		<th>姓名</th>
    		<th>出生日期</th>
    		<th>任职日期</th>
    		<th>地址</th>
    		<th>电话</th>
    		<th>密码</th>
    	</tr>
    	<tr>
    		<td>${user.lastName }</td>
    		<td>${user.BirthDate }</td>
    		<td>${user.hireDate }</td>
    		<td>${user.address }</td>
    		<td>${user.homePhone }</td>
    		<td>${user.pwd }</td>
    	</tr>
    </table>
  </body> 
</html>