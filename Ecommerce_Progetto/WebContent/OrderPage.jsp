<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("utente");
    	if(user==null)
    	{
    		response.sendRedirect("LoginPage.jsp");
    	}
    	ArrayList<?> prodottiOrdinati=(ArrayList<?>) request.getSession().getAttribute("ordini");%>
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
	<%if(prodottiOrdinati!=null && prodottiOrdinati.size()!=0) { %>
	<table>
		<%Iterator<?> it=prodottiOrdinati.iterator();
		while(it.hasNext()){
			Ordine ordine =(Ordine) it.next();
			ArrayList<?> prodotti=(ArrayList<?>) ordine.getProdotti();
			Iterator<?> itpr=prodotti.iterator();
			while(itpr.hasNext()){
				ProdottoBean bean=(ProdottoBean) itpr.next();
		%>
		<tr>
			<td><%=bean.getNome()%></td>
			<td><%=bean.getPrezzo()%></td>
			<td><%=bean.getQuantita()%></td>
		</tr>
		<%} }%>
	</table>
	<%} else{%>
	<h1>NON CI SONO ORDINI</h1>
	<%} %>
</body>
</html>