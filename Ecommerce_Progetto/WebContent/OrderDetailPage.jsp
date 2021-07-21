<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.Ordine"%>
    
<!DOCTYPE html>
<html>

<% 
	if(session.getAttribute("ordine")==null) response.sendRedirect("UserPage.jsp");
	else{
		Ordine order = (Ordine)session.getAttribute("ordine");
%>
<head>
		
 		
        
        
        <link rel="stylesheet" href="stile.css">
        
        
       
        <link href='http://fonts.googleapis.com/css?family=Open%20Sans:400,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'>      
 <title>Dettagli ordine</title>
</head>

<body>
<jsp:include page="/section/navbar.jsp"/> 

	<div class="section padding-inner">
	    	<div class="container">
	    			<font size="5"><b>Numero dell'ordine:</b> <%=order.getNumeroOrdine() %></font><br/>
                    <font size="5"><b>Stato:</b> <%=order.getStato() %></font><br/>
    				<font size="5"><b>Prezzo totale:</b> <%=order.getTotale() %></font><br/>
	    	<br><br><br>
				<!--  <div class="row"> -->
				
				<table class="table table-hover">
  <thead>
    <tr>
      <th scope="col"></th>
      <th scope="col">Nome</th>
      <th scope="col">Quantità</th>
      <th scope="col">Costo</th>
    </tr>
  </thead>
  <tbody>
  <%  for(int i=0; i<order.getProdotti().size(); i++){ %>
    <div class="row"> 
   	 <tr>
     	 <th scope="row"><%= i+1 %></th>
     	 <td><%=order.getProdotti().get(i).getProdotto().getNome() %></td>
    	  <td><%=order.getProdotti().get(i).getQuantita() %></td>
     	 <td><%=order.getProdotti().get(i).getPrezzo() %></td>
   	   <td><a href="prodotto?idProd=<%=order.getProdotti().get(i).getProdotto().getCodice()%>"><img src="imgControl?id=<%=order.getProdotti().get(i).getProdotto().getCodice() %>" alt="Project Name" width=100px height=100px></a></td>
     </tr>
    </div>
    
    
 
		<%
		
			}
			
		}
		    
		
			%>	
					
					
					 </tbody>
					 
</table>
					
					
					
                        	
					</div>
					
				</div>
              
                
      
					
					
					
           
                
                <br><br><br>
                 

<jsp:include page="section/footer.jsp"/>


</body>
</html>