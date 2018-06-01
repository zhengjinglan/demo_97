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
    
    <title>客户管理</title>
    
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
			$("#add,#emp,#edit,#query,#del,#okk,#res").button();
			$("#add").click(function(){
				$("#form").dialog("open");
			});
			
			$("#del").click(function(){
				var i = $("[name='ckbox']:checked").length;
				var ids = [];
				if(i>0){
					$("[name='ckbox']:checked").each(function(){
						ids.push($(this).attr("id"));
					});
					$.post("servlet/CustomersServlet?methods=delete",{id:ids.toString()},
							function(data){
						if(1==data){
	  						alert("删除成功");
	  						$("#query-form").submit();
	  					}else{
	  						alert("删除失败");
	  					}
					});
				}else{
					alert("请选择");
				}
			});
		});
		function add(){
  			$.post("servlet/CustomersServlet?methods=add",{id:$("#id").val(),name:$("#name").val(),ctname:$("#ctname").val(),
  				title:$("#title").val(),address:$("#address").val(),phone:$("#phone").val()},
  			function(data){
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
		}
		function updat(){
	  			var i = $("[name='ckbox']:checked").length;
	  			if(i==0){
	  				alert("请选择");
	  			}else if(i==1){
	  				
	  						$("#ff").reset;
	  						$("#form1").dialog("open");
	  						var id = $("[name='ckbox']:checked").eq(0).attr("id");
	  				
	  			$.post("servlet/CustomersServlet?methods=queryUpdate",{id:id},
	  			function(data){
	  				$("#id1").val(data[0].customerID);
	  				$("#name1").val(data[0].companyName);
	  				$("#ctname1").val(data[0].contactName);
	  				$("#title1").val(data[0].contactTitle);
	  				$("#address1").val(data[0].address);
	  				$("#phone1").val(data[0].phone);
	  			},"json");
	  			}else{
	  				alert("只能选择一条数据");
	  			}
	  		}
	  		function update(){
	  			$.post("servlet/CustomersServlet?methods=update",{id:$("#id1").val(),name:$("#name1").val(),ctname:$("#ctname1").val(),
	  				title:$("#title1").val(),address:$("#address1").val(),phone:$("#phone1").val()},
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
  	<span id="del" onclick="dels()">删除</span>
  	<span id="edit" onclick="updat()">修改</span>
  	<form action="servlet/CustomersServlet?methods=query" method="post" id="query-form">
			<input type="hidden" name="pageSize" id="ps" value="${page.pageSize }"/>
			<input type="hidden" name="pageNum" id="pn" value="1"/>
  	公司：<input type="text" value="${cname }" name="q_companyName" id="q_companyName"/>
  	联系人：<input type="text" value="${name }" name="q_contactName" id="q_contactName"/>
  	电话：<input type="text" value="${phone }" name="q_phone" id="q_phone"/>
  	<input type="submit" value="查询" id="query"/> 
  	</form>
    <div>
    	<table border="1" >
    		<tr style="background:blue">
    			<td><input type="checkbox" name="ckAll"/></td>
    			<td>客户编号</td>
    			<td>联系人姓名</td>
    			<td>联系人职位</td>
    			<td>公司</td>
    			<td>电话</td>
    			<td>地址</td>
    			<!--  <td>操作</td>-->
    		</tr>
    		<c:forEach items="${page.list }" var="cs">
    		<tr>
    			<td><input type="checkbox" value="${cs.customerID }" name="ckbox" id="${cs.customerID }"/>
    			
    			</td>
    			<td>${cs.customerID }</td>
    			<td>${cs.companyName }</td>
    			<td>${cs.contactName }</td>
    			<td>${cs.contactTitle }</td>
    			<td>${cs.phone }</td>
    			<td>${cs.address }</td>
    			
    		</tr>
    		</c:forEach>
    	</table>
    </div>
    <jsp:include page="Page.jsp"></jsp:include>
    <div id="form">
    	<form action="" id="ff">
    	<span id="content">编号：<input type="text" name="id" id="id" >
		</span> 
		<br><br>
	<span id="content">姓名：<input type="text" name="name" id="name">
		</span> 
		<br><br> <span id="content">职位：<input type="text" name="ctname" id="ctname">
		</span> <br>
		<br> <span id="content">公司：<input type="text" name="title" id="title">
		</span> <br>
		<br> <span id="content">电话：<input type="text" name="phone" id="phone">
		</span> <br>
		<br> <span id="content">地址：<input type="text" name="address" id="address">
		</span>
    		<div id="l">
    		<span id="okk" onclick="add()">提交</span>&nbsp;&nbsp;
    		<span id="res">重置</span></div>
    	</form>
    </div>
    <div id="form1">
    <span id="content">编号：<input type="text" readonly="readonly" name="id1" id="id1">
		</span> 
		<br><br>
		<span id="content">姓名：</span> <input type="text" name="name1" id="name1" value="sdfs">
		<br><br> <span id="content">职位：<input type="text" name="ctname1" id="ctname1">
		</span> <br>
		<br> <span id="content">公司：<input type="text" name="title1" id="title1">
		</span> <br>
		<br> <span id="content">电话：<input type="text" name="phone1" id="phone1">
		</span> <br>
		<br> <span id="content">地址：<input type="text" name="address1" id="address1">
		</span>
		<br><br><br><input type="hidden" name="empid1" id="empid1">
		<div id="l"><span id="okk" onclick="update()">提交</span></div>
	</div>
  </body>
</html>
