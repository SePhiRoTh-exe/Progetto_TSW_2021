<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.Ordine"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("utente");
    	if(user==null)
    	{
    		response.sendRedirect("LoginPage.jsp");
    	}
    	ArrayList<Ordine> prodottiOrdinati=(ArrayList<Ordine>) request.getSession().getAttribute("ordini");%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Ecommerce</title>
	</head>
<body>
	<%@ include file="../section/navbar.jsp" %>
	<%if(prodottiOrdinati!=null && prodottiOrdinati.size()!=0) { 
	
		
		for(Ordine o : prodottiOrdinati){
			
			%>
			<p><b>Numero dell'ordine:</b> <%=o.getNumeroOrdine() %></p>
				  
				  <p><b>Stato:</b> <%=o.getStato() %></p>
				  <br>
				  <a href="userorderviewcontrol?idOrd=<%=o.getNumeroOrdine()%>"><button class="button">Mostra dettagli</button></a>
				  <br><br>
		
		<%}} else{%>
		<h1>NON CI SONO ORDINI</h1>
		<%} %>
		
	
</body>
</html>