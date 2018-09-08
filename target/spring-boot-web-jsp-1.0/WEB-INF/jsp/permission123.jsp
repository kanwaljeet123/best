<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<h1>Get Permission</h1>



      <c:if test = "${hello== 'read'}">
      <form action="readObject" method="post">
      <input type="text" readonly="true"  value="${hello}"/>
     <input type="text" readonly="true"  value="${object}"/>
     
         <p>:object is read only  <p>
         </form>
      </c:if>
     <c:if test = "${hello== 'write'}">
      <form action="writeObject" method="post">
      <input type="text" readonly="true" name="permission" value="${hello}"/>
      <input type="text" readonly="true" name="objectname" value="${object}"/>
      <input type="text" name="data"/>
      <input type="submit" value="update"/>
     
         <p>:we can write <p>
         </form>
      </c:if>
       <c:if test = "${hello== 'admin'}">
      <form action="adminObject" method="post">
     <input type="text" readonly="true" name="permission" value="${hello}"/>
      <input type="text" readonly="true" name="objectname" value="${object}"/>
     <input type="text" name="data"/>
      <input type="submit" value="update"/>
      <input type="submit" value="delete"/>
         <p>:we can delete and edit <p>
         </form>
      </c:if>
</body>
</html>