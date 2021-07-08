<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto"); 
    	
    %>
    <!-- DA AGGIUNGERE RITORNO A PAGINA DI ERRORE IN CASO DI PRODOTTO NULL ED AGGIUNGERE IL CONTROLLO UTENTE-->
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Ecommerce</title>
	</head>
<body>
	<%@ include file="../section/navbar.jsp" %><br>
	<h1>Descrizione</h1>
	<a href="<%=request.getContextPath() %>/Home.jsp">Indietro</a>
	<table>
		<tr>
			<th>Descrizione Gioco: <%=prodotto.getNome() %></th>
			<th>Categoria</th>
			<th>Piattaforma</th>
			<th></th>
		</tr>
		<tr>
			<td><%=prodotto.getDescrizione() %></td>
			<td><%=prodotto.getCategoria() %></td>
			<td><%=prodotto.getPiattaforma() %></td>
			<td><a href="addCarrello?idProd=<%=prodotto.getCodice()%>">Aggiungi al carrello</a></td>
		</tr>
	</table>
</body>
</html>