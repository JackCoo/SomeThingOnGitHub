<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有用户</title>

</head>
<body>
<br>
<table border="1">
	<tr>
		<th>user.id</th><th>user.phone</th><th>user.username</th><th>user.password</th><th>user.email</th><th>user.registerTime</th><th>user.sex</th><th>user.major</th><th>user.lastLogin</th><th>user.creditRating</th><th>user.headPic</th><th>user.isDel</th><th>user.campus.id</th><th>user.campus.name</th><th>user.campus.city</th><th>user.campus.status</th><th>user.campus.userDefined</th><th>
	</tr>
	<c:forEach items="${requestScope.userList }" var="user">
		<tr>
			
			<td>${user.id}</td>
			<td>${user.phone}</td>
			<td>${user.username}</td>
			<td>${user.password}</td>
			<td>${user.email}</td>		
			<td>${user.registerTime}</td>
			<td>${user.sex}</td>
			<td>${user.major}</td>
			<td>${user.lastLogin}</td>
			<td>${user.creditRating}</td>
			<td><img src="http://localhost:8080/auction-crazy${user.headPic }" height="60"></td>
			<td>${user.isDel}</td>
			<td>${user.campus.id}</td>
			<td>${user.campus.name}</td>
			<td>${user.campus.city}</td>
			<td>${user.campus.status}</td>
			<td>${user.campus.userDefined}</td>
			
		</tr>
	</c:forEach>
</table>
</body>
</html>