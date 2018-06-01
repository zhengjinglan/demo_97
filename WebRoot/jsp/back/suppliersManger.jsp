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
    
    <title>供应商管理</title>
    
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
					//alert(ids);
					$.post("servlet/EmpServlet?methods=delete",{id:ids.toString()},
							function(data){
						if(1==data){
	  						alert("删除成功");
	  						$("#pgfrom").submit();
	  					}else{
	  						alert("删除失败");
	  						$("#pgfrom").submit();
	  					}
					});
				}else{
					alert("请选择");
				}
			});
		});
		
		function add(){
  			$.post("servlet/SuppliersServlet?methods=add",{name:$("#name").val(),ctname:$("#ctname").val(),
  				title:$("#title").val(),address:$("#address").val(),phone:$("#phone").val(),code:$("#code").val()},
  			function(data){
  					//alert(data);
  				if(1==data){
  					alert("添加成功!");
  					$("#form").dialog("close");
  					$("#pgfrom").submit();
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
	  			$.post("servlet/SuppliersServlet?methods=queryUpdate",{id:id},
	  			function(data){
	  				//alert(data);
	  				$("#ssid").val(data[0].SupplierID);
	  				$("#name1").val(data[0].CompanyName);
	  				$("#ctname1").val(data[0].ContactName);
	  				$("#title1").val(data[0].ContactTitle);
	  				$("#address1").val(data[0].Address);
	  				$("#code1").val(data[0].PostalCode);
	  				$("#phone1").val(data[0].Phone);
	  			},"json");
	  			}else{
	  				alert("只能选择一条数据");
	  			}
	  		}
	  		
	  		function update(){
	  			$.post("servlet/SuppliersServlet?methods=update",{ssid:$("#ssid").val(),name:$("#name1").val(),ctname:$("#ctname1").val(),
	  				title:$("#title1").val(),address:$("#address1").val(),phone:$("#phone1").val(),code:$("#code1").val()},
	  			function(data){
	  				if(1==data){
	  					alert("修改成功");
	  					$("#form1").dialog("close");
	  					$("#pgfrom").submit();
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
  	<form action="servlet/SuppliersServlet?methods=query" id="query-form" method="post">
  	<input type="hidden" name="pageSize" id="ps" value="${page.pageSize }"/>
			<input type="hidden" name="pageNum" id="pn" value="1"/>
  	公司：<input type="text" value="${cname }" name="q_contacttitle" id="q_companyName"/>
  	供应商姓名：<input type="text" value="${name }" name="q_companyName" id="q_contactName"/>
  	电话：<input type="text" value="${phone }" name="q_phone" id="q_phone"/>
  	<input type="submit" value="查询" id="query"/> 
  	</form>
    <div>
    	<table border="1" >
    		<tr style="background:blue">
    			<td><input type="checkbox" name="ckAll"/></td>
    			<td>供应商编号</td>
    			<td>供应商姓名</td>
    			<td>供应商职位</td>
    			<td>公司</td>
    			<td>电话</td>
    			<td>传真</td>
    			<td>地址</td>
    			<!--  <td>操作</td>-->
    		</tr>
    		<c:forEach items="${page.list }" var="cs">
    		<tr>
    			<td><input type="checkbox" name="ckbox" id="${cs.SupplierID }"/>
    			
    			</td>
    			<td>${cs.SupplierID }</td>
    			<td>${cs.CompanyName }</td>
    			<td>${cs.ContactName }</td>
    			<td>${cs.ContactTitle }</td>
    			<td>${cs.Phone }</td>
    			<td>${cs.PostalCode }</td>
    			<td>${cs.Address }</td>
    			
    			<!-- <td><span id="edit" onclick="updat()">修改</span></td> -->
    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
   <jsp:include page="Page.jsp"></jsp:include>
    <div id="form">
    	<form action="" id="ff">
	<span id="content">供应商姓名：<input type="text" name="name" id="name">
		</span> 
		<br><br> <span id="content">供应商职位：<input type="text" name="ctname" id="ctname">
		</span> <br>
		<br> <span id="content">公司：<input type="text" name="title" id="title">
		</span> <br>
		
		<br> <span id="content">电话：<input type="text" name="phone" id="phone">
		</span> <br>
		<br> <span id="content">传真：<input type="text" name="code" id="code">
		</span> <br>
		<br> <span id="content">地址：<input type="text" name="address" id="address">
		</span>
    		<div id="l">
    		<span id="okk" onclick="add()">提交</span>&nbsp;&nbsp;
    		<span id="res">重置</span></div>
    	</form>
    </div>
     <div id="form1">
    <span id="content">供应商姓名：<input type="text" name="name1" id="name1">
		</span> 
		<br><br> <span id="content">供应商职位：<input type="text" name="ctname1" id="ctname1">
		</span> <br>
		<br> <span id="content">公司：<input type="text" name="title1" id="title1">
		</span> <br>
		
		<br> <span id="content">电话：<input type="text" name="phone1" id="phone1">
		</span> <br>
		<br> <span id="content">传真：<input type="text" name="code1" id="code1">
		</span> <br>
		<br> <span id="content">地址：<input type="text" name="address1" id="address1">
		</span>
		<br><br><br><input type="hidden" name="ssid" id="ssid">
		<div id="l"><span id="okk" onclick="update()">提交</span></div>
	</div>
  </body>
</html>
