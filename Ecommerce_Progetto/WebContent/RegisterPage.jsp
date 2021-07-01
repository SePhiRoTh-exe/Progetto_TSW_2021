<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Prova</title>
</head>
<body>
	<form action="logout" method="post" onsubmit="return validate();">
					<h1>Registrazione</h1>
					<label>
						<span>Username</span>
						<input type="text" name="nome" id="nome">
					</label>
					<label>
						<span>Nome</span>
						<input type="text" name="nome" id="nome">
					</label>
					<label>
						<span>Cognome</span>
						<input type="text" name="cognome" id="cognome">
					</label>
					<label>
						<span>Email</span>
						<input type="text" name="email" id="email">
					</label>
					<label>
						<span>Password</span>
						<input type="password" name="password" id="password">
					</label>
				<input type="submit" name="registrazione" value="Register">
	</form>
	<script src="js/validazione.js"></script>
</body>
</html>