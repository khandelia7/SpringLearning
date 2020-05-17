<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>WELCOME</h1>
	<div align="right">
		<a href="${pageContext.request.contextPath}/logout"> LOGOUT </a>
	</div>
	<c:out value="${msg }" />
	<br>
	<%=request.getAttribute("msg")%>
	<br>
	<hr>
	<a
		href="${pageContext.request.contextPath}/welcome?msg=<c:out value="${msg }" />">Go
		To Welcome</a>
	<br>
	<a href="${pageContext.request.contextPath}/sign-up"> Sign up
		with-out spring </a>
	<br>
	<a href="${pageContext.request.contextPath}/sign-up-spring"> Sign
		up with spring </a>
	<hr>
	<c:forEach items="${list}" var="user">
		<c:out value="${user }" />
		<br>
	</c:forEach>
	
</body>
</html>