<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post" modelAttribute="user">
<pre>
    <strong>Login Here</strong>
	User ID: <input type="text" name="userid" />
	<br>
	Password: <input type="text" name="password" />
	<br>
	<input type="submit" value="Login" />
</pre>
</form>
<a href="register"> Register </a>
${message}
</body>
</html>