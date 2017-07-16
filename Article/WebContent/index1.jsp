<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- saved from url=(0048)http://www.xiaotublog.com:8088/Article/index.jsp -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<title>首页</title>
<script src="./resources/js/jQuery.js"></script>
<link rel="stylesheet" type="text/css" href="./resources/css/public.css">
<link rel="stylesheet" type="text/css" href="./resources/css/index.css">

<style>


</style>

</head>
<body>

<!-- 头部页面 -->

<div class="header">
	<div class="logo">原创文字</div>
	<ul>
		<li class="first"><a href="index.jsp">首页</a></li>
		<li class="item"><a href="javascript:void(0)">原创故事</a></li>
		<li class="item"><a href="javascript:void(0)">热门专题</a></li><a href="javascript:void(0)">
		</a><li class="item"><a href="javascript:void(0)"></a><a href="javascript:void(0)">欣赏美文</a></li><a href="javascript:void(0)">
		</a><li class="item"><a href="javascript:void(0)"></a><a href="javascript:void(0)">赞助</a></li>
	</ul>
	
	<div class="login">
		
			
				<span><a href="/login.jsp">登陆</a></span>  
				<span>|</span>
				<span><a href="javascript:void(0)">注册</a></span>
			
			
		
	</div>
</div>

<!-- banner区 -->
<div class="banner">
	<div class="content">
		<!-- 轮播图 -->
		<ul>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/5.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/1.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/2.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/3.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/4.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/5.png">
				</a>
			</li>
			<li class="fl">
				<a href="javascript:void(0)">
					<img src="./resources/img/1.png">
				</a>
			</li>
		</ul>
		<!-- 按钮区 -->
		<span class="banner_left"><i class="btn_left"></i></span>
		<span class="banner_right"><i class="btn_right"></i></span>
</div>

</div>

<!-- 内容区域（待做） -->
<div style="border:1px solid #ccc">
	<br><br>
	<div class="category">
		<div class="title">连载小说</div>
		<ul class="items">
		
		<li class="item">
			<div class="item-banner">
				<div class="item-header">生活中总是充满了乐趣</div>
				<div class="item-name">聊聊我的大学室友</div>
				<div class="item-author">@张三 著</div>
			</div>
			<div class="item-description">那些回忆，那些事。。。</div>
		</li>
			
			<li class="item"></li>
			<li class="item"></li>
			<div style="clear:both"></div>
		</ul>
	</div>
	
	
	
	
	<div class="category">
		<div class="title">编程代码类</div>
		<ul class="items">
			
				<li class="item" onclick="detail(&#39;fb6b70ea-4023-45a3-9106-561649803805&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="JavaScript闭包详解">JavaScript闭包详解</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">JavaScript闭包详解</div>
				</li>
			
				<li class="item" onclick="detail(&#39;b7c19c52-692c-4d24-9b8c-7a022e0ab9fb&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="SpringMVC入门教程">SpringMVC入门教程</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">SpringMVC入门教程</div>
				</li>
			
				<li class="item" onclick="detail(&#39;2b30da44-ad19-4c95-8396-018d79dac634&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="maven安装">maven安装</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">maven安装和环境变量配置</div>
				</li>
			
				<li class="item" onclick="detail(&#39;ddc0136f-7bf5-41ed-ba6f-462d370afbe4&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="tomcat安装">tomcat安装</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">tomcat安装和环境变量配置</div>
				</li>
			
				<li class="item" onclick="detail(&#39;2145ed72-164a-401c-af29-248625a775b8&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="如何将MyEclipse项目导入eclipse">如何将MyEclipse项目导入eclipse</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">解决项目导入的冲突问题...</div>
				</li>
			
				<li class="item" onclick="detail(&#39;6e0173a2-d288-47c1-a54d-149d922a6f1d&#39;);">
					<div class="item-banner">
						<div class="item-header">Java Web实用技术</div>
						<div class="item-name" title="JDK安装">JDK安装</div>
						<div class="item-author">@Jack 著</div>
					</div>
					<div class="item-description">JDK安装和环境变量配置</div>
				</li>
			
			<div style="clear:both"></div>
		</ul>
	</div>
	
	<div class="category">
		<div class="title">干货分享</div>
		<ul class="items">
			<li class="item"></li>
			<li class="item"></li>
			<li class="item"></li>
			<div style="clear:both"></div>
		</ul>
	</div>

</div>

<%-- 引入页脚 --%>
	<%@include file="resources/jsp/footer.jsp" %>

<script>
	var leftBtn = $('.btn_left').eq(0); //左按钮
	var rightBtn = $('.btn_right').eq(0);//右按钮
	
	var ul = $('.banner .content ul').eq(0); 
	
	var index = 0;
	var timer = null; 
	
	var imgwidth = $('.banner .content ul li').width(); //获取轮播图片的宽度
	var len =  $('.banner .content ul li').length - 2//获取总共的图片数量
	
	//下一张
	rightBtn.on('click',function(){
		clearTimeout(timer); //定时器清零
		timer = setTimeout(function(){
			index ++;
			movePicture();
		},500);
		
	});
	
	//上一张
	leftBtn.on('click',function(){
		clearTimeout(timer); //定时器清零
		timer = setTimeout(function(){
			index --;
			movePicture();
		},500);
	});
			
	//移动图片
	function movePicture(){
		$('.banner .content ul').animate({'margin-left':-imgwidth * (index+1)},1000,function(){
			if(index == len){
				$(this).css('margin-left',-imgwidth);
				index = 0;
			}
			if(index == -1){
				$(this).css('margin-left',-imgwidth * len);
				index = len - 1;
			}
		});
	}
	
	
	
	//打开详情页
	function detail(id){
		var a = document.createElement("a");
		a.href = "detail.jsp?id=" + id; 
		console.log(a);
		a.target = '_new'; //指定在新窗口打开
		a.click();//触发打开事件
	}
	
</script>


</body></html>