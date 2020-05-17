<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Sign up Without Spring</h1>
	<form method="post"
		action="${pageContext.request.contextPath }/process-sign-up">
		Name: <input type="text" name="name" required><br> <br>
		Username: <input type="text" name="username" required><br> <br>
		Password: <input type="password" name="name" required><br> <br>
		Re-password: <input type="password" name="name" required><br> <br>
		<input type="submit" value="sign-up">
	</form>
</body>
</html>