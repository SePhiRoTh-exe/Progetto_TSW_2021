<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta charset="UTF-8">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
		<link href="style.css" rel="stylesheet" type="text/css">
<title>Prova</title>
</head>
<body>
	<form action="register" method="post" onsubmit="return validate();">
					<h1>Registrazione</h1>
					<label>
						<label for="inputNome4">Username</label>
      					<input type="text" class="form-control" id="inputUsr4" placeholder="Inserisci Username" required name="userName">
   	  					<span id="spanusername" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci un nome valido (solo caratteri). </span>
					</label>
					 <div class="form-row">
    				<div class="form-group col-md-5">
      					<label for="inputNome4">Nome</label>
      					<input type="text" class="form-control" id="inputNome4" placeholder="Inserisci nome" required name="userName">
   	  					<span id="spannome" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci un nome valido (solo caratteri). </span>
    				</div>
    				<div class="form-group col-md-5">
      					<label for="inputSurname4">Cognome</label>
      					<input type="text" class="form-control" id="inputSurname4" placeholder="Inserisci cognome" required name="userSurname">
     					<span id="spancognome" style="display:none ; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci un cognome valido (solo caratteri). </span>
     				 </div>
    				<div class="form-group col-md-5">
      					<label for="inputEmail4">Email</label>
      					<input type="email" class="form-control" id="inputEmail4" placeholder="Email" required name="userEmail">
     					 <span id="spanmail" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci una mail valida (usa la @). </span>
    				</div>
    				<div class="form-group col-md-5">
      					<label for="inputPassword4">Password</label>
      					<input type="password" class="form-control" id="inputPassword4" placeholder="Password" required name="userPass">
      					<span id="spanpassword" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci una password valida (fra 6 e 18 caratteri, almeno una maiuscola, una minuscola e un numero). </span>
    				</div>    
    				</div>
		<input type="submit" name="registrazione" value="Registrati">
	</form>
	<script src="js/validazione.js"></script>
</body>
</html>