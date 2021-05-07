<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ProdottoBean prodotto = (ProdottoBean) request.getAttribute("product"); %>
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
			<th></th>
		</tr>
		<tr>
			<td><%=prodotto.getDescrizione() %></td>
			<td><a href="product?action=addC&id=<%=prodotto.getCodice()%>">Aggiungi al carrello</a></td>
		</tr>
	</table>
</body>
</html>