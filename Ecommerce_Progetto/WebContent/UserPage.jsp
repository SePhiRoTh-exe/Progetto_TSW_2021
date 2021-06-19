<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("user");
    	ArrayList<?> prodottiOrdinati=(ArrayList<?>) request.getAttribute("orders");%>
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
	<h2><a href="userSettings?action=vieworders">Elenco Ordini</a></h2><br>
	<%if(prodottiOrdinati!=null && prodottiOrdinati.size()!=0) { %>
	<table>
		<%Iterator<?> it=prodottiOrdinati.iterator();
			while(it.hasNext()){
				ProdottoBean bean =(ProdottoBean) it.next();
		%>
		<tr>
			<td><%=bean.getNome() %></td>
			<td><%=bean.getPrezzo() %></td>
			<td><%=bean.getQuantita() %></td>
		</tr>
		<%} %>
	</table>
	<%} %>
	<h2><a href="#">Info Account</a></h2>
</body>
</html>