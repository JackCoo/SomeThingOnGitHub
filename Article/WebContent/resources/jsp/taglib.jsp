<%-- jsp注释，用户在客户端看不到。 --%>

<%-- 公共配置 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     
<%-- <% %>jsp代码段 --%>
<%
	//利用内置request对象 获取根目录
    String path = request.getContextPath();
    int port = request.getServerPort();
    
    String basePath  = null;
    //拼接根目录链接 协议://网址/根目录
    if(port==80){
        basePath = request.getScheme()+"://"+request.getServerName()+path;
    }else{
        basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
    }
    //将根目录链接作为属性值放入request对象中，以便其他jsp页面应用
    request.setAttribute("basePath", basePath);
%>