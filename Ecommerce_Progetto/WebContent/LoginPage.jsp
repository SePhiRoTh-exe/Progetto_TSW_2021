<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Ecommerce</title>
	</head>
	<body>
		<%@ include file="../section/navbar.jsp" %>
		<form action="login" method="post">
			Username
			<input type="text" name="Username" placeholder="Username"><br>
			Password
			<input type="text" name="Password" placeholder="Password"><br>
			<input type="submit" value="Login">
		</form>
	</body>
</html>