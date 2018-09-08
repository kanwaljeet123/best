<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Add users in group</h1>

<form action="groupUser" method="post">

		
		
		
		<input type="text" name="groupname" />
		

		<select name="user" multiple="true">
			<c:forEach var="U" items="${user}">

				<option value="${U.userName}">${U.userName}</option>

			</c:forEach>

		</select>
		
		<input type="submit" value="submit" />


	</form>
</body>
</html>