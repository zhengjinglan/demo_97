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
    
    <title>分页</title>
    
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
	<script type="text/javascript">
		$(function(){

			$("#tool-page [pNum]").button().each(function(){
				$(this).click(function(){
					$("#pn").attr("value",$(this).attr("pNum"));
					$("#ps").attr("value",$("#pageSize").val());
					$("#query-form").submit();
				});
			});
			
			$("#pageSize").change(function(){
				$("#ps").attr("value",$("#pageSize").val());
				$("#query-form").submit();
			});
		});
	
	</script>
  </head>
  
  <body>
   <div id="tool-page">
		<select id="pageSize">
			<option ${page.pageSize==5?'selected':'' }>5</option>
			<option ${page.pageSize==10?'selected':'' }>10</option>
			<option ${page.pageSize==15?'selected':'' }>15</option>
			<option ${page.pageSize==20?'selected':'' }>20</option>
		</select>
		<span pNum="1">首页</span>
		<c:if test="${page.pageNum>1}">
			<span pNum="${page.pageNum-1 }">上一页</span>
		</c:if>
		<c:if test="${page.pageNum<page.pagecounts}">
			<span pNum="${page.pageNum+1 }">下一页</span>
		</c:if>
		<span pNum="${page.pagecounts }">尾页</span>
		第${page.pageNum}页/共${page.pagecounts }页
	</div>
  </body>
</html>
