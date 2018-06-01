<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>运货公司管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="css/jquery-ui-1.10.3.custom.css" />
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" href="css/style.css" />
	<script type="text/javascript">
		$(function(){
			$("#form").dialog({
				modal:true,
				width : 500,
				height : 450
			});
			$("#form1").dialog({
				modal:true,
				width : 500,
				height : 450
			});
			$("#form").dialog("close");
			$("#form1").dialog("close");
			$("#add,#edit,#del,#okk,#res").button();
			
			$("#add").click(function(){
				$("#form").dialog("open");
			});
			$("#del").click(function(){
				var ids = [];
					$("[name='ckbox']:checked").each(function(){
						ids.push($(this).attr("id"));
					});
					if(ids.length==0){
						alert("请选择要删除的数据");
					}else{
					$.post("servlet/ShippersServlet?methods=delete",{id:ids.toString()},
							function(data){
						//alert(ids);
						if(1==data){
	  						alert("删除成功");
	  						$("#query-form").submit();
	  					}else{
	  						alert("删除失败");
	  						$("#query-form").submit();
	  					}
					});
					}
				
			});
		});
		
		function add(){
  			$.post("servlet/ShippersServlet?methods=add",{name:$("#name").val(),phone:$("#phone").val(),
  			},
  			function(data){
  					//alert(data);
  				if(1==data){
  					alert("添加成功!");
  					$("#form").dialog("close");
  					$("#query-form").submit();
  				}else{
  					alert("添加失败!");
  					$("#form").dialog("open");
  					
  				}
  			});
  		}
		function submits(){
			// ajax做表单提交
			var iframe = window.parent.frames[0];
			//alert($(iframe).attr("name"));
		}
		function updat(){
			var i = $("[name='ckbox']:checked").length;
			if(i==0){
				alert("请选择");
			}else if(i==1){
				
						$("#ff").reset;
						$("#form1").dialog("open");
					
			
	  			var id = $("[name='ckbox']:checked").eq(0).attr("id");
	  			
	  			$.post("servlet/ShippersServlet?methods=queryUpdate",{id:id},
	  			function(data){
	  				//alert(data);
	  				$("#sid").val(data[0].ShipperID);
	  				$("#name1").val(data[0].CompanyName);
	  				$("#phone1").val(data[0].Phone);
	  			},"json");
			}else{
				alert("只能选择一条数据");
			}
	  		}
	  		
	  		function update(){
	  			$.post("servlet/ShippersServlet?methods=update",{sid:$("#sid").val(),name:$("#name1").val(),phone:$("#phone1").val(),},
	  			function(data){
	  				if(1==data){
	  					alert("修改成功");
	  					$("#form1").dialog("close");
	  					$("#query-form").submit();
	  				}else{
	  					alert("修改失败");
	  					$("#form1").dialog("open");
	  				}
	  			});
	  		}
	</script>
  </head>
  
  <body>
    <span id="add">新增</span>
  	<span id="del">删除</span>
  	<span id="edit" onclick="updat()">修改</span>
  	<form action="servlet/ShippersServlet?methods=query" id="query-form" method="post">
  	</form>
    <div>
    	<table border="1" >
    		<tr style="background:blue">
    			<td><input type="checkbox" name="ckAll"/></td>
    			<td>货运公司编号</td>
    			<td>货运公司名称</td>
    			<td>电话</td>
    		</tr>
    		<c:forEach items="${list }" var="cs">
    		<tr>
    			<td><input type="checkbox" name="ckbox" id="${cs.ShipperID }"/>	
    			</td>
    			<td>${cs.ShipperID }</td>
    			<td>${cs.CompanyName }</td>
    			<td>${cs.Phone }</td>
    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
    <div id="form">
    	<form action="" id="ff">
	<span id="content">货运公司名称：<input type="text" name="name" id="name">
		</span> 
		<br><br> <span id="content">电话：<input type="text" name="phone" id="phone">
		</span> <br>
		<br>
    		<div id="l">
    		<span id="okk" onclick="add()">提交</span>&nbsp;&nbsp;
    		<span id="res">重置</span></div>
    	</form>
    </div>
     <div id="form1">
	<span id="content">货运公司名称：<input type="text" name="name1" id="name1">
		</span> 
		<br><br> <span id="content">电话：<input type="text" name="phone1" id="phone1">
		</span> <br>
		<br>
		<br><br><br><input type="hidden" name="sid" id="sid">
		<div id="l"><span id="okk" onclick="update()">提交</span></div>
	</div>
  </body>
</html>


