<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Carrello carrello=(Carrello) request.getSession().getAttribute("cart");
%>
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
<% if(carrello!=null) { %>
		<h1>Carrello</h1>
		<table>
			<tr>
				<th>Oggetto</th>
				<th>Quantita</th>
				<th>Prezzo</th>
				<th></th>
			</tr>
			<%List<ProdottoCarrello> prodottiCarrello=carrello.getProdotti();
			  	for(ProdottoCarrello bean: prodottiCarrello){
			%>
			<tr>
				<td><%=bean.getProduct().getNome()%></td>
				<td><%=bean.getQuantità() %></td>
				<td>$<%=bean.getProduct().getPrezzo() %></td>
				<td><a href="product?action=deleteC&id=<%=bean.getProduct().getCodice()%>">Rimuovi dal carrello</a></td>
			</tr>
			<%} %>
		</table>
		<a href="placeOrder">Procedi all ordine</a>
<% } %>
</body>
</html>