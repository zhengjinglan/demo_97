<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
	<script type="text/javascript" src="js/jquery-ui-1.10.3.custom.min.js"></script>
	<script type="text/javascript" src="js/jquery.ui.datepicker-zh-CN.js"></script>
	<link rel="stylesheet" type="text/css" href="css/jquery-ui-1.10.3.custom.css"/>
	<script type="text/javascript">
	
		$(function(){
			$("#div").dialog({
				width:300,
				height:300,
				buttons:[{
					text:"登录",
					click:function(){
						//提交表单
						$("#form").submit();
					}
				},{
					text:"注册",
					click:function(){
						
					}
				}]
			});
			$("#btn").button();
		});
		// 用户名：5-15位字母，数字，_
		// 密码：5-20位: 必须包含(大写，小写，数字)字母，数字，_组成
		function CheckName(){
			//var name = $("#name").val();
			//var reg = /^[a-zA-Z0-9]{5,15}$/;
			if($("#name").val()!=""){
			/*if(reg.test(name)){
				$("#name+span").html("");
				return true;
			}else{
				$("#name+span").html("用户名由5-15位字母，数字组成");
				return false;
			}*/}else{
				$("#name+span").html("用户名不能为空");
				return false;
			}
		}
		function CheckPwd(){
			//var pwd = $("#pwd").val();
			//var reg = /^[a-zA-Z0-9_]{5,15}$/;
			if($("#pwd").val()!=""){
			/*if(reg.test(pwd)){
				$("#pwd+span").html("");
				return true;
			}else{
				$("#pwd+span").html("密码由5-20位字母，数字，下划线组成");
				return false;
			}*/}else{
				$("#pwd+span").html("密码不能为空");
				return false;
			}
		}
		function CheckAll(){
			if(CheckName&&CheckPwd){
				return true;
			}else{
				return false;
			}
		}
		  function checknologin(){
		  	    var name = $( "#name" ).val();
		        var password = $( "#pwd" ).val();
		        var methods = "nologin";
		        $.post('servlet/UsersServlet',{"name":name,"password":password,"methods":methods},function(data){
		    		 if (data == 1) {
		    			  window.location.href = "home.jsp";
		  			} 
		  			},'json',true);
		    }
	</script>
  </head>
  
  <body>
  <div id="div" >
    <form action="servlet/UsersServlet" method="post" id="form" onsubmit="return CheckAll()">
    <div>
    <input type="hidden" name="methods" value="login"/>
    	<label>账号：</label>
    	<input type="text" name="name" id="name" value="${user.LastName }" onblur="CheckName()"/>
    	<span></span>
    	</div>
    	<div>
    		<label>密码：</label>
    		<input type="password" name="password" id="pwd" value="${password }" onblur="CheckPwd()"/>
    		<span></span>
    	</div>
    	<div>
    	<input type="checkbox" name="nologin"  id="nologin" style="width: 18px" class="text ui-widget-content ui-corner-all">一周内免登陆<br />
    	</div>
    </form>
    </div>
  </body>
</html>
