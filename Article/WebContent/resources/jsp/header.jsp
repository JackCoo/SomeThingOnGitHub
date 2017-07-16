<!-- 头部页面 -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- 库应在被使用的文件内引用 --%>
<%-- 引入JSTL标签库 --%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<div class="header">
    <div class='logo'>原创文字</div>
    <ul>
        <li class='first'><a href="index.jsp">首页</a></li>
        <li class='item'><a href="javascript:void(0)">原创故事</a></li>
        <li  class='item'><a href="javascript:void(0)">热门专题</a></li>
        <li  class='item'><a href="javascript:void(0)">欣赏美文</a></li>
        <li  class='item'><a href="javascript:void(0)">赞助</a></li>
    </ul>
    
    <div class='login'>
    	<c:choose>
    		<c:when test="${empty(sessionScope.userName)}">
    			<span><a href="login.jsp">登陆</a></span>
    			<span>|</span>
    			<span><a href="javascript:void(0)">注册</a></span> 	
    		</c:when>
    		<c:otherwise>
    		    <span><a href="login.jsp">您好,${sessionScope.userName}。</a></span>
    			<span>|</span>
    			<span><a href="javascript:void(0)">退出</a></span> 
    		</c:otherwise>		
    	</c:choose>
        
    </div>
</div>