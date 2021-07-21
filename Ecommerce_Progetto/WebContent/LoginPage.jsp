<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% if(session.getAttribute("utente")!=null||session.getAttribute("admin")!=null)
	response.sendRedirect("Home.jsp");
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
        
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.1/css/all.css" integrity="sha384-gfdkjb5BdAXd+lj+gudLWI+BXq4IuLW5IT+brZEZsLFm++aCMlF1V92rMkPaX4PP" crossorigin="anonymous">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>VGHUB</title>
	</head>
	<body>
		<%@ include file="../section/navbar.jsp" %>
		<form action="login" method="get">
			<div class="input-group mb-3">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-user fa-lg"></i></span>
							
							<input type="text" name="Username" id="usr" height="20px" class="form-control input_user" value="" placeholder="inserisci l'username" required>
							
							
							</div>
							<p><span id="spanusername" style="display:none;font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci un username valido </span></p>
						</div>
						
						<div class="input-group mb-2">
							<div class="input-group-append">
								<span class="input-group-text"><i class="fas fa-key fa-lg"></i></span>
							
							<input type="password" name="Password" id="password" class="form-control input_pass" value="" placeholder="inserisci la password" required>
		
							</div>
							<p><span id="spanpassword" style="display:none;font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Inserisci correttamente la password. </span></p>
							
					    	</div>			
		
						
					<div class="d-flex justify-content-center mt-3 login_container">
				  <button type="submit" class="btn login_btn">Login</button>
				  </div>
		</form>
		<div class="mt-4">
					<div class="d-flex justify-content-center links">
						Non hai un account? <a href="RegisterPage.jsp" class="ml-2">Registrati ora!</a>
						
					</div>
				</div>
		
		
			</div>
		</div>
	</div>		
						
	</body>
</html>