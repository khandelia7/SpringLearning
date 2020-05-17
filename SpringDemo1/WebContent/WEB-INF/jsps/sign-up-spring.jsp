<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign up With Spring</h1>

	<sf:form method="post"
		action="${pageContext.request.contextPath }/process-sign-up-spring"
		modelAttribute="user">
		Name: <sf:input type="text" path="name" required="required" />
		<sf:errors path="name" />
		<BR>
		<BR>	
		Username*: <sf:input type="text" path="username" required="required" />
		<sf:errors path="username" />
		<br>
		<br>
		Email-id*: <sf:input type="text" path="emailid" required="required" />
		<sf:errors path="emailid" />
		<br>
		<br>
		Password*: <sf:input type="password" path="password" required="required" />
		<sf:errors path="password" />
		<br>
		<br>
		Re-password*: <sf:input type="password" path="repassword" required="required" />
		<sf:errors path="repassword" />
		<br>
		<br>
		<input type="submit" value="Sign-up">
	</sf:form>
</body>
</html>