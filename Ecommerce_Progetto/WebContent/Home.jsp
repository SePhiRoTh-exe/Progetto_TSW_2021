<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null) {
		response.sendRedirect("./catalogo");	
		return;
	}
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
		<h1>Catalogo</h1>
		<table>
			<tr>
				<th>Nome</th>
				<th>Prezzo</th>
				<th>Descrizione</th>
				<th>Carrello</th>
			</tr>
			<%
				if(prodotti!=null && prodotti.size()!=0)
				{
					Iterator<?> it = prodotti.iterator();
					int i=0;
					while(it.hasNext() && i<15)
					{
						i++;
						ProdottoBean bean=(ProdottoBean) it.next();
			%>
			<tr>
				<td><%=bean.getNome() %></td>
				<td>$<%=bean.getPrezzo() %></td>
				<td><a href="prodotto?idProd=<%=bean.getCodice()%>">Visualizza</a></td>
				<td><a href="addCarrello?idProd=<%=bean.getCodice()%>">Aggiungi al carrello</a></td>
			</tr>
			<%
					}
				}
			%>
		</table>
	</body>
</html>