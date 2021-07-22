<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% ProdottoBean prodotto = (ProdottoBean) request.getAttribute("prodotto"); 
    	
    %>
    <!-- DA AGGIUNGERE RITORNO A PAGINA DI ERRORE IN CASO DI PRODOTTO NULL ED AGGIUNGERE IL CONTROLLO UTENTE-->
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="stile.css" rel="stylesheet" type="text/css">
		<title>VGHUB</title>
	</head>
<body>
	<%@ include file="../section/navbar.jsp" %><br>
	        <div class="main-container">
            <div class="content main-cat ombre rd">
                <div class="pannello-centrale">
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
                                    <a class="tag tag1">Categoria: <%=prodotto.getCategoria() %></a>
                                </div>
                                <div class="compra">
                                    <div class="prezzi">
                                        <div class="prezzo"><%=prodotto.getPrezzo() %>$</div>
                                    </div>
                                    <div class="swap">
                                        <a href="addCarrello?idProd=<%=prodotto.getCodice() %>" class="button buybutton">Acquista</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="main-info">
                        <div class="info-prodotto ombre" id="descrizione-content">
                            <div class="descrizione-prodotto">
                                <%=prodotto.getDescrizione() %>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
       <%@ include file="../section/footer.jsp" %>
</body>
</html>