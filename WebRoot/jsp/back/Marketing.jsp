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
    
    <title>订单</title>
    
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
				$("#date").datepicker({
					minDate:+1,
					maxDate:+30
				});
				
				
				$("#goodtype").change(function(){
					
					$("#goods option:gt(0)").remove();
					
					var seleted = $(this).val();
					//alert(seleted);
					$.post("servlet/Marketing?methods=queryByPro",{"id":seleted},function(data){
						//alert(data);
						for(var i in data){
							var map=data[i];
							//alert(map);
							$("#goods").append("<option id='"+map.ProductID+"' value='"+map.ProductID+"' price='"+map.UnitPrice+"' nums='"+map.UnitsInStock+"'>"+map.ProductName+"</option>");
							//var html="<option value="+map.ProductID+">"+map.ProductName+"</option>";
							
							//$("#goods").append(html);
						}
						
						
					},"json");
					
				});
			});
			
			function checkNums(nums){
				var gooosid = "#"+$("#goods").val();
				if(gooosid!="#0"){
					var goodsnum = $(gooosid).attr("nums");
					// 判断是否大于当前的库存量
				}
			}
			
			function addGoods(){
				var selectGoods = "#"+$("#goods").val();
				if(selectGoods!="#0"){
					if($("tr[id='"+$("#goods").val()+"']").length>0){
						alert("已经添加");
						$("tr[id='"+$("#goods").val()+"']").find("td").eq(3).html($("#num").attr($("#orderNums").val()));
					}else{
						var htmls ="<tr id='"+$(selectGoods).attr("id")+"'>";
						htmls+="<td>"+$("#goodtype").val()+"</td>";
						htmls+="<td>"+$(selectGoods).html()+"</td>";
						htmls+="<td>"+$(selectGoods).attr("price")+"</td>";
						htmls+="<td>"+$("#orderNums").val()+"</td>";
						htmls+="<td>"+$(selectGoods).attr("price")*$("#orderNums").val()+"</td>";
						htmls+="</tr>";
						$("#tboby").append(htmls);
					}
				}
			}
			function addOrders(){
				$.post("servlet/MarketingServlet?methods=add",{goods:$(selectGoods).attr("id"),
					price:$(selectGoods).attr("price"),num:$("#orderNums").val()},function(data){
						if(1==data){
							alert("添加成功");
						}else{
							alert("添加失败");
						}
					});
			}
		</script>
	
  </head>
  
  <body>
    	<!-- 订单表 -->
    	<form method="post">
		<div>
		
			客户：
			<select>
			
				<option>---请选择---</option>
				<c:forEach items="${cs }" var="c">
				<option value="${c.customerID }">${c.companyName }</option>
				</c:forEach>
			</select>
			要货日期：<input type="text" id="date"/> 
			<br/><br/>
			收货人：<input type="text" />
			收货地址：<input type="text" />
			操作员：<span style="color: blue">${user.lastName }</span> 操作员编号：<span style="color: blue">${user.employeeID }</span>
			
		</div>
		<div>
			商品类型：
			<select id="goodtype">
				<option>---请选择---</option>
				<c:forEach items="${ca }" var="c">
					<option value="${c.CategoryID }">${c.CategoryName }</option>
				</c:forEach>
			</select>
			商品：
			<select id="goods">
				<option value="0">---请选择---</option>
			</select>
			数量：<input id="orderNums" onblur="checkNums(this.value)"/>
			<input type="button" value="确定" onclick="addGoods()"/>
		</div>
		
		<!--订单详情表-->
		<div>
			<table>
				
			<tbody id="tboby">
					<tr bgcolor="#888">
						<th>商品类型</th>
						<th>商品名称</th>
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
					</tr>
			
				</tbody>
			</table>
			<input type="submit" value="订购" onclick="addOrders"/>
			</div>
			</form>
		
  </body>
</html>
