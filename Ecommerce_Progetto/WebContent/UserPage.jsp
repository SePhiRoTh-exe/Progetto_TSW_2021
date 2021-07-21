<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
    <% UserBean user=(UserBean) request.getSession().getAttribute("utente");
    	if(user==null)
    	{
    		response.sendRedirect("LoginPage.jsp");
    	}
    	ArrayList<?> prodottiOrdinati=(ArrayList<?>) request.getAttribute("ordini");%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.*"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="style.css" rel="stylesheet" type="text/css">
		<title>Ecommerce</title>
	</head>
<body>
<%@ include file="/section/navbar.jsp" %>
<br><br>
		
		<%if(session.getAttribute("alertMsg")!=null){%>
		<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3> 
		<%session.setAttribute("alertMsg",""); 
		session.setAttribute("redirect","UserArea.jsp");%><br>
	<%}%>
	
	<div class="container">
      <div class="row padding-inner"> 
             
             <!-- Column1 -->
             <div class="col-md-6 col-sm-12">
             	
                  
                  <p class="block">Le tue informazioni</p>
                  
                  <div class="thumbnail">
                  <p><b>Username:</b> <%=user.getUsername() %></p>
                  <p><b>Nome:</b> <%=user.getNome() %></p>
				  <p><b>Cognome:</b> <%=user.getCognome() %></p>
				  <p><b>Email:</b> <%=user.getEmail() %></p>    
                 
            	 </div>
            	 <div >
						 <a href="OrderPage.jsp">Ordini effettuati</a>
						
					</div>
            </div>
</body>
</html>