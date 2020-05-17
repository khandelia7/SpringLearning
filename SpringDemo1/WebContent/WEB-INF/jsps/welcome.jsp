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
	<h1>Hello Welcome Page...!</h1>
	<c:out value="${msg }" />
	// passing parameters from one method to other
	<br>
	<H2>
	Customer Details
	</H2>

	<h3>
		<c:out value="${bank.getName()   }" />
		// Level 1 (one bank has many customers)
	</h3>
	<h4>List Of Customer: // Level 2 (one customers has one plan) and
		(one plan has one status)</h4>
	<c:forEach items="${bank.getblist()}" var="c">
		<c:out value="${c }" />
		<br>
	Plan--> <c:out value="${c.getSubscription().getPlan() }" />
		<br>
	Status--> <c:out
			value="${c.getSubscription().getStatus().getStatus() }" />
		<br>
		<hr>
	</c:forEach>


</body>
</html>