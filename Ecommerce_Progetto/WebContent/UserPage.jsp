<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("utente");
    	if(user==null)
    	{
    		response.sendRedirect("LoginPage.jsp");
    	}
    	ArrayList<?> prodottiOrdinati=(ArrayList<?>) request.getAttribute("ordini");%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.*"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Ecommerce</title>
	</head>
<body>
<%@ include file="../section/navbar.jsp" %>
	<h1>Ciao <%=user.getNome() %></h1>
	<h2><a>Dettagli Account</a></h2>
	<h2><a href="visualizzaOrdini">Elenco Ordini</a></h2><br>
	<h2><a href="logout">Disconnetti</a></h2><br>
	<h2><a href="#">Info Account</a></h2>
</body>
</html>