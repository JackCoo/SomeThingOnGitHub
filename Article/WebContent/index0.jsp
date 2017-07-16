<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%-- 更改默认charset为UTF-8 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Index demo</title>

	<!-- 内部样式表，将CSS样式表写于页面的head区域内 -->
	<!-- CSS选择器
		*		通配选择器，匹配文档中所有HTML元素
		E		元素选择其，选择指定的HTML元素
		#id		ID选择器，选择ID值为id的任意类型元素
		.class	类选择器，选择class属性值为class的任意类型多个元素
		selector1 selector1 	群组选择器
	 -->
	
	<style>
		<!-- 定义多个CSS样式 -->
		
		*{
			pading:0;/* 内边距 */
			margin:0;/* 外边距 */	
			font-family: "微软雅黑";
		}
		
		.header{
			height: 60px;/* 高度 */
			background: #458fce;/* 背景色 */
		
		}
		
		.header .logo{
			color: #fff;/* 文本字体 */
			line-height: 72px ;/* 行高 */
		    font-size: 30px ;
		    margin-left: 20px ;/* 左外边距 */
		    display:inline-block ;/* 元素生成的类型 */
		    font-weight:500 ;/* 字体的粗细 */
		    
		    float: left ;/* 向左浮动？ 左对齐 浮动*/
			
		}
		
		ul {
			list-style: none;/* 设置列表属性，默认列表有圆点*/
		}
		
		.header ul li.first {
    		margin-left: 30px ;
		}
		
		.header ul li {
		    float: left ;
		    color: #fff ;
		    display: inline-block ;
		    width: 128px ;
		    height: 60px ; 
		    text-align: center ;
		    line-height:72px ;
		    cursor: pointer ;/* 鼠标样式 */
		}
		
		li {
			font-size: 20px;
		}
		
		a {
			color: #fff;
			text-decoration: none;/* 去掉链接的下划线 */
		
		}
		
	
		/*a:hover,hover 选择器,选择鼠标指针浮动在其上的元素，并设置其样式 */
		.header ul li:hover {
   			 background:#74b0e2 ;
		}
		
		.login {
			float: right;
			color: #fff ;
		    line-height: 72px ;
		    margin-right: 20px ;
				
		
		}
		
		.banner {
		    height: 380px ;
		    overflow: hidden ;
		    background: #ccc;
		}
	</style>

</head>



<body>
	
	<!-- 在body区域画一个div快标签，作为首页的标题栏，其class属性为header。其样式写在本页，即style块。 -->
	<!-- 快标签用于分割文档 -->
	<div class="header">
		
		<div class="logo">原创文字</div>
		<!-- ul标签定义无序列表 -->
			<ul>
				<li class="first"><a href="javascript:void(0)">首页</a></li>
				<li><a href="javascript:void(0)">原创故事</a></li>
				<li><a href="javascript:void(0)">热门专题</a></li>
				<li><a href="javascript:void(0)">赞助</a></li>
			</ul>
			
		<div class="login">
			    <a href="javascript:void(0)">登陆</a>
			    | 
			    <a href="javascript:void(0)">注册</a>
		
		</div>
		

		
		</div>
	
	</div>
	
	
</body>
</html>