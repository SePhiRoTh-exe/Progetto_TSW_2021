<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Prova</title>
</head>
<body>
	<form action="register" method="post" onsubmit="return validate();">
					<h1>Registrazione</h1>
					<label>
						<span>Username</span>
						<input type="text" name="Username" id="Username">
					</label>
					<label>
						<span>Nome</span>
						<input type="text" name="Nome" id="Nome">
					</label>
					<label>
						<span>Cognome</span>
						<input type="text" name="Cognome" id="Cognome">
					</label>
					<label>
						<span>Email</span>
						<input type="text" name="Email" id="Email">
					</label>
					<label>
						<span>Password</span>
						<input type="password" name="Password" id="Password">
					</label>
				<input type="submit" name="registrazione" value="Registrati">
	</form>
	<script src="js/validazione.js"></script>
</body>
</html>