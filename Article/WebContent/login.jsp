
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<%-- 每个jsp页面都应 @page设置编码，否则中文乱码。 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!-- 先引入basepath，再根据basepath引入js和css。也可以以相对路径加载。 -->
<%@include file="resources/jsp/taglib.jsp" %>
<script src="${basePath}/resources/js/jQuery.js"></script>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/public.css"/>
<link rel="stylesheet" type="text/css" href="${basePath}/resources/css/login.css"/>

<title>登陆</title>
</head>

<body>
	<!-- 引入头部页面 -->
	<%@include file="resources/jsp/header.jsp" %>

	<!-- 左侧背景 -->
	<div class='show'>
		<img src = "resources/img/msg.png" ></img>
	</div>
	
	<!-- 登陆框 -->
	<div class='content'>
		<div class='logo'>用户登录</div>
		<div class='inputBox mt50 ml32'>
			<input type="text" id="username" autofocus="autofocus" autocomplete="off" maxlength="60" placeholder="请输入账号">
		</div>
		<div class='inputBox mt50 ml32'>
			<input type="password" id="password" autofocus="autofocus" autocomplete="off" maxlength="60" placeholder="请输入密码">
		</div>
		
		<div class='mt50 ml32'>
			<button class="login_btn" onclick="login()">登陆</button>
		</div>
	</div>
	</br>
	</br>
	</br>
	</br>
	</br>
	</br>
	<%-- 引入页脚 --%>
	<%@include file="resources/jsp/footer.jsp" %>
	
	<!-- 登陆AJAX -->
	<script>
		
		function login(){
			var username = $('#username').val();
			var password = $('#password').val();
			$.ajax({
				type:"post",//请求方式
				url:"dologin",//请求地址
				data:{"username":username,"password":password},//传递给controller的json数据
				error:function(){//如果出错了，将事件重新绑定
					alert("登陆出错！");
				},
				success:function(data){ //返回成功执行回调函数。
					if(data == -1){
						alert('用户名和密码不能为空！');
					}else if(data == -2){
						alert('用户名不存在！');
					}else if(data == -3){
						alert('用户名或密码错误！');
					}else{
						//登录成功后返回首页
						window.location.href = "${basePath}"; 
					}
				}
			});
			
			
		}
		
	</script>
</body>
</html>