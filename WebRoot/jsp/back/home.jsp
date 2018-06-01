<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css" />
		<script type="text/javascript" src="js/jquery-1.9.1.js" ></script>
		<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js" ></script>
		<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js" ></script>
		<style>
			body{
				overflow: auto;	
			}
			
			#menu{
				width: 20%;
				float: left;
				height: 600px;
				border: 1px solid red;
			}
			
			#content{
				width: 72%;
				float: left;
				height: 600px;
				border: 1px solid blue;
			}
			#logo{
				width:100%;
				height:50px;
			}
		</style>
		<script type="text/javascript">
			
			$(function(){
				$("#menu").accordion();
				
			});
			
		</script>
  </head>
  
  <body id="logo">
  <div>
  欢迎：${user.lastName }在线人数：${onlineNums }
   <a href="servlet/UsersServlet?methods=loginOut">退出</a>
   </div>
    	<div id="menu">
    	 	<h3>基础管理</h3>
    	 	<ul>
    	 	<li>
    	 			<a href="servlet/EmpServlet?methods=emp" target="ifreams">员工管理</a>
    	 		</li>
    	 		<li>
    	 			<a href="jsp/back/people.jsp" target="ifreams">个人中心</a>
    	 		</li>
    	 		<li>
    	 			<a href="servlet/CustomersServlet?methods=query" target="ifreams">客户管理</a>
    	 		</li>
    	 	</ul>
    	 	<h3>货运公司管理</h3>
    	 	<ul>
    	 		<li>
    	 			<a href="servlet/SuppliersServlet?methods=query" target="ifreams">供应商管理</a>
    	 		</li>
    	 		<li>
    	 			<a href="servlet/ShippersServlet?methods=query" target="ifreams">货运公司管理</a>
    	 		</li>
    	 	</ul>
    	 	<h3>产品管理</h3>
    	 	<ul>
    	 	<li>
    	 			<a href="servlet/CategoriesServlet?methods=query" target="ifreams">产品类别</a>
    	 		</li>
    	 		<li>
    	 			<a href="servlet/ProductsServlet?methods=query" target="ifreams">产品明细</a>
    	 		</li>
    	 	</ul>
    	 	<h3>销售管理</h3>
    	 	<ul>
    	 	<li>
    	 			<a href="servlet/Marketing?methods=query" target="ifreams">订单管理</a>
    	 		</li>
    	 		
    	 	</ul>
    	</div>
    	<div id="content">
			<iframe frameborder="0" width="100%" height="100%" name="ifreams" id="iff"></iframe>
		</div>
  </body>
</html>
