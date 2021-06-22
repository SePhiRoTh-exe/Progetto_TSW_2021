<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Prova</title>
</head>
<body>
	<form class="form-register" method="post" onsubmit="return validate();">
		<div class="form-register-with-email">
			<div class="form-white-background">
				<div class="form-title-row">
					<h1>Registrazione</h1>
				</div>
				<div class="form-row">
					<label>
						<span>Nome</span>
						<input type="text" name="nome" id="nome">
					</label>
				</div>
				<div class="form-row">
					<label>
						<span>Cognome</span>
						<input type="text" name="cognome" id="cognome">
					</label>
				</div>
				<div class="form-row">
					<label>
						<span>Email</span>
						<input type="text" name="email" id="email">
					</label>
				</div>
				<div class="form-row">
					<label>
						<span>Password</span>
						<input type="password" name="password" id="password">
					</label>
				</div>
				<input type="submit" name="registrazione" value="Register">
			</div>
		</div>
	</form>
	<script src="js/validazione.js"></script>
</body>
</html>