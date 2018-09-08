<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="css/Decoration.css" rel="stylesheet" type="text/css">
</head>
<body>
<jsp:include page="hello.jsp"></jsp:include>
&nbsp;&nbsp; &nbsp;&nbsp;
<h1> insert user permission for objects</h1>
	<form action="insertPermissionForUsers" method="post">

		<select name="user">
			<c:forEach var="U" items="${user}">

				<option value="${U.userName}">${U.userName}</option>

			</c:forEach>

		</select>
		<c:forEach var="U" items="${user1}">

			<input type="text" name="object" value="${U.objectName}" />
			<select name="permission">

				<option value="read">read</option>
				<option value="write">write</option>
				<option value="admin">admin</option>


			</select>
		</c:forEach>

		<input type="submit" value="submit" />


	</form>
</body>
</html>