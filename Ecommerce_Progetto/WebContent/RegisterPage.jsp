<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta charset="UTF-8">
		<link rel="stylesheet" type="text/css" href="./css/form.css">



        <meta name="robots" content="noindex, follow">
<title>Registrazione</title>
</head>
<body>
<div class="wrapper fadeInDown">

        <div id="formContent">
        <h2 class="active"> Registrazione </h2>
                    <h2 class="inactive underlineHover"><a href="LoginPage.jsp">Login</a></h2>

                    <div class="fadeIn first">


                    </div>
	<form action="register" method="post" onsubmit="return validate();">
					
					<input type="text" id="login" class="fadeIn second" name="Username" placeholder="Username">

					<input type="text" id="password" class="fadeIn third" name="Password" placeholder="Password">

                    <input type="text" id="nome" class="fadeIn fourth" name="Nome" placeholder="Nome">

    				<input type="text" id="cognome" class="fadeIn fifth" name="Cognome" placeholder="Cognome">

                    <input type="text" id="email" class="fadeIn sixth" name="Email" placeholder="Email">

    				<input type="submit" class="fadeIn seventh" value="Registrati">
	</form>
    
        </div>

      </div>
	<script src="js/validazione.js"></script>
</body>
</html>