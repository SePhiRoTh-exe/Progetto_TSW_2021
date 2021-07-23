<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.Ordine"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("utente");
    	if(user==null)
    	{
    		response.sendRedirect("LoginPage.jsp");
    	}
    	ArrayList<?> prodottiOrdinati=(ArrayList<?>) request.getSession().getAttribute("ordini");%>
<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="stile.css" rel="stylesheet" type="text/css">
		<title>VGHUB</title>
	</head>
<body>
	<%@ include file="../section/navbar.jsp" %>
	<%if(prodottiOrdinati!=null && prodottiOrdinati.size()!=0) { 
	
		Iterator<?> it = prodottiOrdinati.iterator();
		while(it.hasNext()){
			Ordine ordine=(Ordine) it.next();
			%>
			<p><b>Numero dell'ordine:</b> <%=ordine.getNumeroOrdine() %></p>
				  
				  <p><b>Stato:</b> <%=ordine.getStato() %></p>
				  <br>
				  <a href="order?idOrd=<%=ordine.getNumeroOrdine()%>"><button class="button">Mostra dettagli</button></a>
				  <br><br>
		
		<%}} else{%>
		<h1>NON CI SONO ORDINI</h1>
		<%} %>
		
	
</body>
</html>