<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>testgoods</title>

</head>
<body>
<br>
<table border="1">
	<tr>
		<th>id</th><th>name</th><th>briefDescription</th><th>categoryId</th><th>userId</th><th>price</th><th>priceStep</th><th>isAuction</th><th>description</th><th>imgsUrl</th><th>htmlUrl</th><th>status</th><th>bidStart</th><th>bidStop</th><th>bestBidPrice</th><th>bestBidUserId</th><th>owner</th><th>isDel</th>
	</tr>
	<c:forEach items="${requestScope.goods_list }" var="good">
		<tr>
			
			<td>${good.id }</td>
			<td>${good.name }</td>
			<td>${good.briefDescription }</td>
			<td>${good.categoryId }</td>
			<td>${good.userId }</td>
			<td>${good.price }</td>
			<td>${good.priceStep }</td>
			<td>${good.isAuction }</td>
			<td>${good.description }</td>
			<td>${good.imgsUrl }</td>
			<td>${good.status }</td>
			<td>${good.bidStart }</td>
			<td>${good.bidStop }</td>
			<td>${good.bestBidPrice }</td>
			<td>${good.bestBidUserId }</td>
			<td>${good.owner }</td>
			<td>${good.isDel }</td>
			<td>${good.htmlUrl }</td>

			
			
		</tr>
	</c:forEach>
</table>
</body>
</html>