<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>

<%
	Collection<?> products = (Collection<?>) request.getAttribute("prodotti");
	if(products == null) {
		response.sendRedirect("./productviewcontrol");	
		return;
	}
%>

<!DOCTYPE html>
<html>



 <head>
        <title>VGHUB</title>

        <link rel="stylesheet" href="stile.css">
        
        
       
        <link href='http://fonts.googleapis.com/css?family=Open%20Sans:400,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'>         
    </head>

<body>
	
	
	
	<jsp:include page="/section/navbar.jsp"/>
			<br><br><br><br>
	

	
	<div class="container port-top">
		<h3>Risultati della ricerca: </h3>
		<br><br><br>
		
		<%if(session.getAttribute("alertMsg")!=null){%>
		<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3> 
		<%session.setAttribute("alertMsg",""); 
		session.setAttribute("redirect",null);
		%>
	<%}%>
			<div class="row">
				
				<%
					if(products==null) %>
				<%  if(products.size()==0)  %>La ricerca non ha prodotto risultati
				<%
					if (products != null && products.size() != 0) {
						Iterator<?> it = products.iterator();
						while (it.hasNext()) {
							ProdottoBean bean = (ProdottoBean) it.next();
							if(bean.getQuantita()>0){
				%>
				
				<div class="col-md-4 col-sm-6">
				
				<div class="portfolio-item">
				
				
					<div class="portfolio-image">
						<div class="foto">{ IMMAGINE QUI%>
						
					</div>	
						
					</div>
				
			        <div class="portfolio-info-fade">
			        <ul>
                        
                      <br><br><br><br>
				    <li class="acquista"><a href="prodotto?idProd=<%=bean.getCodice()%>" class="portfolio-btn">ACQUISTA</a></li>
					
						<% //immagien %>

					</ul>
					</div>
					
					
					 
					
				</div>	
				
					<p class="name" align="center" style= margin-top:-20px><b><%=bean.getNome()%></b></p>
					<p class="category" align="center" style="line-height:2px; margin-bottom:70px"><%= bean.getCategoria()%></p>
				
				</div>
				
					
				<%
							}	
						}
					} 
				%>
				
		    </div>
	</div>
		<br><br><br><br>
	<jsp:include page="/section/footer.jsp"/>
	
	
</body>
</html>