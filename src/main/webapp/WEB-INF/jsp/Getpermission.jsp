<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="hello.jsp"></jsp:include>
	<h1>get permission prioritywise</h1>
	<form action="getPermission" method="post">

		<select name="user">
			<c:forEach var="U" items="${user}">

				<option value="${U.userName}">${U.userName}</option>

			</c:forEach>

		</select> <select name="object">
			<c:forEach var="O" items="${user1}">

				<option value="${O.objectName}">${O.objectName}</option>

			</c:forEach>

		</select> <input type="submit" value="submit" />


	</form>

</body>
</html>