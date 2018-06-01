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
    
    <title>产品管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
				height : 550
			});
			$("#form1").dialog({
				modal:true,
				width : 500,
				height : 560
			});
			$("#form").dialog("close");
			$("#form1").dialog("close");
			$("#add,#emp,#edit,#query,#del,#okk,#res").button();
			
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
				$.post("servlet/ProductsServlet?methods=delete",{ids:ids.toString()},function(data){
					if(1==data){
  						alert("删除成功");
  						$("#query-form").submit();
  					}else{
  						alert("删除失败");
  						$("#query-form").submit();
  					}
				},"json",true);
				}
		});
		});
		function add(){
			//alert($("#sid").select().val());
  			$.post("servlet/ProductsServlet?methods=add",{name:$("#name").val(),sid:$("#sid").select().val(),
  				cid:$("#cid").select().val(),quantity:$("#quantity").val(),price:$("#price").val(),
  				instock:$("#instock").val(),onorder:$("#onorder").val(),reorder:$("#reorder").val(),
  				discontinued:$("#discontinued").val()},
  				
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
			//alert($(iframe).attr("name"));
		}
		function updat(){
			var i = $("[name='ckbox']:checked").length;
	  			//alert(i);
	  			if(i==0){
	  				alert("请选择要修改的数据");
	  			}else if(i==1){
	  				$("#ff").reset;
					$("#form1").dialog("open");
					var id = $("[name='ckbox']:checked").eq(0).attr("id");
	  			$.post("servlet/ProductsServlet?methods=queryUpdate",{id:id},
	  			function(data){
	  				//alert(data);
	  				$("#pid").val(data[0].ProductID);
	  				$("#name1").val(data[0].ProductName);
	  				$("#sid1").val(data[0].SupplierID);
	  				$("#cid1").val(data[0].CategoryID);
	  				$("#quantity1").val(data[0].QuantityPerUnit);
	  				$("#price1").val(data[0].UnitPrice);
	  				$("#instock1").val(data[0].UnitsInStock);
	  				$("#onorder1").val(data[0].UnitsOnOrder);
	  				$("#reorder1").val(data[0].ReorderLevel);
	  				$("#discontinued1").val(data[0].Discontinued);
	  			},"json");
	  			}else{
	  				alert("请选择一条数据");
	  			}
	  		}
	  		
	  		function update(){
	  			$.post("servlet/ProductsServlet?methods=update",{pid:$("#pid").val(),name:$("#name1").val(),sid:$("#sid1").select().val(),
	  				cid:$("#cid1").select().val(),quantity:$("#quantity1").val(),price:$("#price1").val(),
	  				instock:$("#instock1").val(),onorder:$("#onorder1").val(),reorder:$("#reorder1").val(),
	  				discontinued:$("#discontinued1").val()},
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
  	<form action="servlet/ProductsServlet?methods=query" id="query-form" method="post">
  	<input type="hidden" name="pageSize" id="ps" value="${page.pageSize }"/>
			<input type="hidden" name="pageNum" id="pn" value="1"/>
  	产品编号：<input type="text" value="${pid }" name="q_productsID" id="q_productsID"/>
  	产品名称：<input type="text" value="${pname }" name="q_productsName" id="q_productsName"/>
  	<input type="submit" value="查询" id="query"/> 
  	</form>
    <div>
    	<table border="1" >
    		<tr style="background:blue">
    			<td><input type="checkbox" name="ckAll"/></td>
    			<td>产品编号</td>
    			<td>产品名称</td>
    			<td>供应商名称</td>
    			<td>产品类别</td>
    			<td>产品规格</td>
    			<td>产品单价</td>
    			<td>库存</td>
    			<td>已定购量</td>
    			<td>安全存量</td>
    			<td>不再销售</td>
    			<!--  <td>操作</td>-->
    		</tr>
    		<c:forEach items="${page.list }" var="cs">
    		<tr>
    			<td><input type="checkbox" name="ckbox" id="${cs.ProductID }"/>
    			
    			</td>
    			<td>${cs.ProductID }</td>
    			<td>${cs.ProductName }</td>
    			<td>${cs.CompanyName }</td>
    			<td>${cs.CategoryName }</td>
    			<td>${cs.QuantityPerUnit }</td>
    			<td>${cs.UnitPrice }</td>
    			<td>${cs.UnitsInStock }</td>
    			<td>${cs.UnitsOnOrder }</td>
    			<td>${cs.ReorderLevel }</td>
    			<td>${cs.Discontinued }</td>
    		</tr>
    		</c:forEach>
    		
    	</table>
    </div>
   <jsp:include page="Page.jsp"></jsp:include>
    <div id="form">
    	<form action="" id="ff">
	<span id="content">产品名称：<input type="text" name="name" id="name">
		</span> 
		<br><br> <span id="content">
		供应商名称：
		<select name="sid" id="sid">
		<c:forEach items="${supp }" var="supp">
			<option value="${supp.SupplierID }">${supp.CompanyName }</option>
		</c:forEach>
		</select>
		</span> <br>
		<br> 
		<span id="content">产品类别：
		<select name="cid" id="cid">
		<c:forEach items="${cat }" var="cat">
		
			<option value="${cat.CategoryID }">${cat.CategoryName }</option>
		
		</c:forEach>
		</select>
		</span> <br>
		
		<br> <span id="content">产品规格：<input type="text" name="quantity" id="quantity">
		</span> <br>
		<br> <span id="content">产品单价：<input type="text" name="price" id="price">
		</span> <br>
		<br> <span id="content">库存：<input type="text" name="instock" id="instock">
		</span>
		<br>
		<br> <span id="content">已定购量：<input type="text" name="onorder" id="onorder">
		</span>
		<br>
		<br> <span id="content">安全存量：<input type="text" name="reorder" id="reorder">
		</span>
		<br>
		<br> <span id="content">不再销售：<input type="text" name="discontinued" id="discontinued">
		</span>
    		<div id="l">
    		<span id="okk" onclick="add()">提交</span>&nbsp;&nbsp;
    		<span id="res">重置</span></div>
    	</form>
    </div>
     <div id="form1">
    <span id="content">产品名称：<input type="text" name="name1" id="name1">
		</span> 
		<br><br> <span id="content">
		供应商名称：
		<select name="sid1">
		<c:forEach items="${supp }" var="supp">
			<option value="${supp.SupplierID}">${supp.CompanyName }</option>
		</c:forEach>
		</select>
		</span> <br>
		<br> 
		<span id="content">产品类别：
		<select name="cid1">
		<c:forEach items="${cat }" var="cat">
		
			<option value="${cat.CategoryID }">${cat.CategoryName }</option>
		
		</c:forEach>
		</select>
		</span> <br>
		
		<br> <span id="content">产品规格：<input type="text" name="quantity1" id="quantity1">
		</span> <br>
		<br> <span id="content">产品单价：<input type="text" name="price1" id="price1">
		</span> <br>
		<br> <span id="content">库存：<input type="text" name="instock1" id="instock1">
		</span>
		<br>
		<br> <span id="content">已定购量：<input type="text" name="onorder1" id="onorder1">
		</span>
		<br>
		<br> <span id="content">安全存量：<input type="text" name="reorder1" id="reorder1">
		</span>
		<br>
		<br> <span id="content">不再销售：<input type="text" name="discontinued1" id="discontinued1">
		</span>
		<br><br><br><input type="hidden" name="pid" id="pid">
		<div id="l"><span id="okk" onclick="update()">提交</span></div>
	</div>
  </body>
</html>
