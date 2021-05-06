<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("products");
	if(prodotti == null) {
		response.sendRedirect("./product");	
		return;
	}
	ProdottoBean prodotto = (ProdottoBean) request.getAttribute("product");
	Carrello carrello=(Carrello) request.getAttribute("cart");
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
		<%@ include file="../section/navbar.jsp" %><br>
		<h2>Catalogo</h2>
		<table>
			<tr>
				<th>Nome</th>
				<th>Descrizione</th>
				<th>Carrello</th>
			</tr>
			<%
				if(prodotti!=null && prodotti.size()!=0)
				{
					Iterator<?> it = prodotti.iterator();
					while(it.hasNext())
					{
						ProdottoBean bean=(ProdottoBean) it.next();
			%>
			<tr>
				<td><%=bean.getNome() %></td>
				<td><%=bean.getDescrizione() %></td>
				<td><a href="product?action=addC&id=<%=bean.getCodice()%>">Aggiungi al carrello</a></td>
			</tr>
			<%
					}
				}
			%>
		</table>
		<% if(carrello!=null) { %>
		<h1>Carrello</h1>
		<table>
			<tr>
				<th>Oggetto</th>
			</tr>
			<%List<ProdottoBean> prodottiCarrello=carrello.getProdotti();
			  for(ProdottoBean bean: prodottiCarrello){
			%>
			<tr>
				<td><%=bean.getNome()%></td>
				<td><%=bean.getQuantita()%></td>
				<td><a href="product?action=deleteC&id=<%=bean.getCodice()%>">Rimuovi dal carrello</a></td>
			</tr>
			<%} %>
		</table>
		<%} %>
	</body>
</html>