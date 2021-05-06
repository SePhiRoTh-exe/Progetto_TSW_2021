<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Carrello carrello=(Carrello) request.getSession().getAttribute("cart");
%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>
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
				<th></th>
				<th></th>
				<th></th>
			</tr>
			<%List<ProdottoBean> prodottiCarrello=carrello.getProdotti();
			  	for(ProdottoBean bean: prodottiCarrello){
			%>
			<tr>
				<td><%=bean.getNome()%></td>
				<td><%=bean.getQuantita()%></td>
				<td>$<%=bean.getPrezzo() %></td>
				<td><a href="product?action=deleteC&id=<%=bean.getCodice()%>">Rimuovi dal carrello</a></td>
			</tr>
			<%} %>
		</table>
<% } %>
</body>
</html>