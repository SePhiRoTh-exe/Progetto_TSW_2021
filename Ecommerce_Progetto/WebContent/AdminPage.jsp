<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	
		Collection<?> products = (Collection<?>) request.getAttribute("prodotti");
			if(products == null) {
				response.sendRedirect("./catalogo?catalog=1");	
				return;
			}
			
	
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<title>VGHUB</title>

        
        

        <!-- Google fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open%20Sans:400,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'> 
	
	
	
	<style>
	span{
		display:none;
		color:red;
	}
	</style>
	
</head>

<body>
	
	
	<%if(session.getAttribute("alertMsg")!=null){%>
		<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3> 
		<%session.setAttribute("alertMsg",""); %>
	<%}%><br>
	<p class="block" font-size="40px">Prodotti</p>
	
	<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col">Codice</th>
      <th scope="col">Nome</th>
      <th scope="col">Descrizione</th>
      <th scope="col">Operazione</th>
      <th scope="col">Foto</th>
    </tr>
  </thead>

	<tbody>

		<%
			if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					ProdottoBean prod = (ProdottoBean) it.next();
					
		%>
		<div class="row"> 
		<tr>
			<td><%=prod.getCodice() %></td>
			<td><%=prod.getNome() %></td>
			<td><%=prod.getDescrizione() %></td>
			<td>
				<a href="updateproduct?idProd=<%=prod.getCodice()%>">Modifica</a><br>
				<a href="prodotto?idProd=<%=prod.getCodice()%>">Dettagli</a></td>
				<%
				request.setAttribute("imgbean", prod);%>
			<td></td>
		</tr>
		<%
			  }	
				
			} else {
		%>
		<tr>
			<td colspan="6">No products available</td>
		</tr>
		<%
			}
		%> 
		</table>

	<hr>
	<% if (request.getAttribute("mod")!=null){ 
		ProdottoBean mod=(ProdottoBean)request.getAttribute("mod");
		request.setAttribute("mod",mod);
	   } %>
	
	
	<br><br>
	
</body>
</html>