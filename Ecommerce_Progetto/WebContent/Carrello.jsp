<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.*"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>VGHUB</title>
	</head>
<body>
<%@ include file="../section/navbar.jsp" %>
<%
		if(session.getAttribute("cart")==null) session.setAttribute("cart", new Carrello());
		Carrello cart=(Carrello)session.getAttribute("cart");
		ArrayList<ProdottoCarrello> lista=cart.getProdotti();

 	if(session.getAttribute("alertMsg")!=null){%>
		<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3> 
		<%session.setAttribute("alertMsg","");
		session.setAttribute("redirect","CartView.jsp");%>
	<%} %><br><p class="block" style="font-size:40px">Il tuo carrello:</p><br>
	<% if(cart.getProdotti().size()==0){%>
	<h2>Vuoto, aggiungi qualcosa!</h2>
	<%
	}else{%> 
	
	
	<table class="table table-hover">
  		<thead>
    	<tr>
      <th scope="col">Foto</th>
      <th scope="col">Nome</th>
      <th scope="col">Quantità</th>
      <th scope="col">Prezzo</th>
      <th scope="col"></th>
    </tr>
  </thead>
  <tbody>
  <%  for(int i=0;i<lista.size();i++){ 
  	ProdottoCarrello prodotto=lista.get(i); %>
 		<tr>
				<td><img class="picture" src="./img/<%=prodotto.getProduct().getImg() %>-cover.jpg"></td>
				<td><%=lista.get(i).getProduct().getNome() %><td align="center"><%=lista.get(i).getQuantità()%><td align="center"><%=lista.get(i).getProduct().getPrezzo() %>
				<td><a href="mod?change=1&idProd=<%=lista.get(i).getProduct().getCodice()%>"><button class="button">Aggiungi</button></a>
				<td><a href="mod?change=-1&idProd=<%=lista.get(i).getProduct().getCodice()%>"><button class="button">Rimuovi</button></a>
			</tr><%
		} %> 
			</table>
		<hr>
		
		<p align="right"> <%=cart.getTotale()%></p>
	  	<form action="placeOrder" method="post" name="placeorder">
		<input type="submit" value="Checkout"><br><br><br><br>
		</form>	
		</tbody>
		<%} %>
		

</body>
</html>