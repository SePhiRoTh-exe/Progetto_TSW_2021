<%
	
		Collection<?> products = (Collection<?>) request.getAttribute("prodotti");
			if(products == null) {
				response.sendRedirect("./catalogo?catalog=2");	
				return;
			}
			
	
%>

<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>

<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="stile.css" rel="stylesheet" type="text/css">
		<title>VGHUB</title>

        
        

        <!-- Google fonts -->
        <link href='http://fonts.googleapis.com/css?family=Open%20Sans:400,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'> 
	
	
	
</head>

<body>
<%@ include file="../section/navbar.jsp" %><br>
	<%if(session.getAttribute("alertMsg")!=null){%>
		<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3> 
		<%session.setAttribute("alertMsg",""); %>
	<%}%>
	        <div class="main-container">
            <div class="content main-cat ombre rd">
                <div class="pannello-centrale">
               <%
				if (products != null && products.size() != 0) {
				Iterator<?> it = products.iterator();
				while (it.hasNext()) {
					ProdottoBean prodotto = (ProdottoBean) it.next();
					
					%>
                    <div id="prodotto-pannello-centrale">
                        <div class="prodotto">
                            <div class="blur">
                                <img class="background">
                                <div class="cover ombre">
                                    <img class="picture" src="./img/<%=prodotto.getImg() %>-cover.jpg">
                                </div>
                            </div>
                            <div class="info ombre">
                                <h1><%=prodotto.getNome() %></h1>
                                <div class="info-disponibilita">
                                    <a class="piattaforma playstation">
                                        <div class="badge <%=prodotto.getPiattaforma() %>"></div>
                                        <%=prodotto.getPiattaforma() %>
                                    </a>
                                    <div class="disponibilita">
                                    <%if(prodotto.getQuantita()!=0){ %>
                                        <img src="./icon/ok-icon.svg">
                                        Disponibile
                                     <%}else{ %>
                                     	<img src="./icon/close-icon.svg">
                                        Non Disponibile
                                      <%} %>
                                    </div>
                                </div>
                                <div class="tags">
                                    <a class="tag tag1">Codice: <%=prodotto.getCodice() %></a>
                                </div>
                                <div class="compra">
                                    <div class="prezzi">
                                        <div class="prezzo">Quantita: <%=prodotto.getQuantita() %></div>
                                    </div>
                                    <div class="swap">
                                        <a href="updateproduct?idProd=<%=prodotto.getCodice()%>" class="button buybutton">Modifica</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main-info">
                        <div class="info-prodotto ombre" id="descrizione-content">
                        </div>
                    </div>
                    <% } }%>
                </div>
            </div>
        </div>
       <%@ include file="../section/footer.jsp" %>
       	<% if (request.getAttribute("mod")!=null){ 
		ProdottoBean mod=(ProdottoBean)request.getAttribute("mod");
		request.setAttribute("mod",mod);
	   } %>
	
</body>
</html>