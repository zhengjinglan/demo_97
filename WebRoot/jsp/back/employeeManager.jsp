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
    
    <title>员工管理</title>
    
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
				height : 500
			});
			$("#form1").dialog({
				modal:true,
				width : 500,
				height : 500
			});
			$("#form").dialog("close");
			$("#form1").dialog("close");
			$("#add,#emp,#edit,#query,#del,#okk,#res").button();
			
			$("#add").click(function(){
				$("#form").dialog("open");
			});
			
		
			$("#del").click(function(){
				var i = $("[name='ckbox']:checked").eq(0).attr("id");
				//alert(i);
				var ids = [];
				if(i>0){
					$("[name='ckbox']:checked").each(function(){
						ids.push($(this).attr("id"));
					});
					//alert(ids);
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
  			$.post("servlet/EmpServlet?methods=add",{name:$("#name").val(),birthday:$("#birthday").val(),
  				rudate:$("#rudate").val(),address:$("#address").val(),phone:$("#phone").val(),pwd:$("#pwd").val(),photo:$("#photo").val()},
  			function(data){
  				if("添加成功"==data){
  					alert(data);
  					$("#form").dialog("close");
  					$("#pgfrom").submit();
  					
  				}else{
  					alert(data);
  					$("#pgfrom").submit();
  					$("#form").dialog("open");
  				}
  			});
			//$("#ff").submit();
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
	  			$.post("servlet/EmpServlet?methods=queryUpdate",{id:id},
	  			function(data){
	  				
	  				$("#name1").val(data[0].lastName);
	  				$("#pwd1").val(data[0].pwd);
	  				$("#birthday1").val(JSON.stringify(data[0].BirthDate));
	  				$("#rudate1").val(JSON.stringify(data[0].hireDate));
	  				$("#phone1").val(data[0].homePhone);
	  				$("#address1").val(data[0].address);
	  				$("#photo1").val(data[0].photo);
	  				$("#empid1").val(data[0].EmployeeID);
	  			},"json");
	  			}else{
	  				alert("只能选一条数据");
	  			}
	  		}
	  		
	  		function update(){
	  			$.post("servlet/EmpServlet?methods=update",{name:$("#name1").val(),birthday:$("#birthday1").val(),
	  				rudate:$("#rudate1").val(),address:$("#address1").val(),phone:$("#phone1").val(),pwd:$("#pwd1").val(),photo:$("#photo1").val(),id:$("#empid1").val()},
	  			function(data){
	  				
	  				if(1==data){
	  					alert("修改成功");
	  					$("#form1").dialog("close");
	  					$("#pgfrom").submit();
	  				}else{
	  					alert("修改失败");
	  					$("#form1").dialog("close");
	  					$("#pgfrom").submit();
	  				}
	  			});
	  		}
	</script>
  </head>
  
  <body>
 
  	<span id="add">新增</span>
  	<span id="edit" onclick="updat()">修改</span>
  	<span id="del" onclick="dels()">删除</span>
  	 <form action="servlet/EmpServlet?methods=emp" id="query-form" method="post">
			<input type="hidden" name="pageSize" id="ps" value="${page.pageSize }"/>
			<input type="hidden" name="pageNum" id="pn" value="1"/>
  	编号：<input type="text" value="${id }" name="q_employeeID" id="q_employeeID"/>
  	姓名：<input type="text" value="${name }" name="q_lastName" id="q_lastName"/>
  	电话：<input type="text" value="${phone }" name="q_phone" id="q_phone"/>
  	<input type="submit" value="查询" id="query"/> 
  	</form>
    <div>
    	<table border="1" >
    		<tr style="background:blue">
    			<td><input type="checkbox" name="ckAll"/></td>
    			<td>编号</td>
    			<td>姓名</td>
    			<td hidden>密码</td>
    			<td>电话</td>
    			<td hidden>生日</td>
    			<td>年龄</td>
    			<td hidden>入职日期</td>
    			<td>工龄</td>
    			<td>地址</td>
    			<td>照片</td>
    			<!--  <td>操作</td>-->
    		</tr>
    		<c:forEach items="${page.list }" var="emp">
    		<tr>
    			<td><input type="checkbox" name="ckbox" id="${emp.EmployeeID }"/>
    			
    			</td>
    			<td>${emp.EmployeeID }</td>
    			<td>${emp.lastName }</td>
    			<td hidden>${emp.pwd }</td>
    			<td>${emp.homePhone }</td>
    			<td hidden>${emp.birthDate }</td>
    			<td>${emp.age }</td>
    			<td hidden>${emp.hireDate }</td>
    			<td>${emp.hireAge }</td>
    			<td>${emp.address }</td>
    			<td><img src="${emp.photo }"></td>
    			<!-- <td><span id="edit" onclick="updat('${emp.EmployeeID }')">修改</span></td> -->
    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
    <jsp:include page="Page.jsp"></jsp:include>
    <div id="form">
    	<form action="servlet/EmpImgServlet?methods=flupForm" id="ff" enctype="multipart/form-data">
	<span id="content">姓名：<input type="text" name="name" id="name">
		</span> 
		<br><br> <span id="content">密码：<input type="password" name="pwd" id="pwd">
		</span> <br>
		<br/>
		<span id="content">重复密码：<input type="password" name="pwd" id="pwd">
		</span> <br>
		<br> 
		<br> <span id="content">出生日期：<input type="date" name="birthday" id="birthday">
		</span> <br>
		<br> <span id="content">入职日期：<input type="date" name="rudate" id="rudate">
		</span> <br>
		<br> <span id="content">电话：<input type="text" name="phone" id="phone">
		</span> <br>
		<br> 
		<span id="content">照片：<input type="file" name="photo" id="photo">
		</span> <br>
		<br>
		<span id="content">地址：<input type="text" name="address" id="address">
		</span>
    		<div id="l">
    		<span id="okk" onclick="add()">提交</span>&nbsp;&nbsp;
    		<span id="res">重置</span></div>
    	</form>
    </div>
    <div id="form1">
    <form action="servlet/EmpImgServlet?methods=flupForm" enctype="multipart/form-data">
		<span id="content">姓名：</span> <input type="text" name="name1" id="name1">
		
		<br><br> <span id="content">密码：<input type="password" name="pwd1" id="pwd1">
		</span> <br>
		<br> <span id="content">出生日期：<input type="text" value="1995-02-06" name="birthday1" id="birthday1">
		</span> <br>
		<br> <span id="content">入职日期：<input type="text" value="2016-02-06" name="rudate1" id="rudate1">
		</span> <br>
		<br> <span id="content">电话：<input type="text" name="phone1" id="phone1">
		</span> <br>
		<br> <span id="content">地址：<input type="text" name="address1" id="address1">
		</span>
		<br><br>
		<span id="content">图片：<input type="file" name="photo1" id="photo1">
		</span> <br>
		<br> 
		<br><input type="hidden" name="empid1" id="empid1">
		<div id="l"><span id="okk" onclick="update()">提交</span></div>
		</form>
	</div>
  </body>
</html>
