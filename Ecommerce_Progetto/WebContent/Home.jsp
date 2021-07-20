<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null) {
		response.sendRedirect("./catalogo?catalog=1");	
		return;
	}
%>
<!DOCTYPE html>
<html>
	<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>
    <head>
        <meta charset="UTF-8">
        <title>VGHUB</title>
        <link rel="stylesheet" href="stile.css">
    </head>
    <body>
        <script>
            function changeCss () {
            var bodyElement = document.querySelector("body");
            var sfondo = document.getElementById("background-banner");
            this.scrollY > 80 ? sfondo.style.position = "fixed" : sfondo.style.position = "absolute";
            this.scrollY > 80 ? sfondo.style.top = "0px" : sfondo.style.top = "80px";
        }
        window.addEventListener("scroll", changeCss , false);
        </script>
        <a href="#" id="background-banner"></a>
		<%@ include file="../section/navbar.jsp" %>
        <div class="main-container">
            <div id="banner">
                <a href="#linkgioco">
                    <img src="img/background-1.jpg" alt="BATTLEFIELD 2042">
                    <span class="prezzo">54.99$</span>
                </a>
            </div>
            <div class="content main-cat ombre">
                <div class="pannello-centrale">
                    <div class="titolo">
                        <div class="categoria">Ultime Uscite</div>
                        <a class="tutti" href="#">Guarda Tutti</a>
                    </div>
                    <div class="catalogo">
                   	<%
					if (prodotti != null && prodotti.size() != 0) {
						Iterator<?> it = prodotti.iterator();
						while (it.hasNext()) {
							ProdottoBean prodotto = (ProdottoBean) it.next();
					%>
                        <div class="item">
                            <a class="cover" href="prodotto?idProd=<%=prodotto.getCodice() %>" title="Battlefield">
                                <div class="badge playstation"></div>
                                <img class="picture ombre" src="img/battlefield-5-cover.jpg" alt="Battlefield V" onload="lazyLoadImage(this)">
                                <div class="shadow">
                                    <div class="prezzo"><%=prodotto.getPrezzo()%>$</div>
                                </div>
                            </a>
                            <div class="nome"><%=prodotto.getNome()%></div>
                        </div>
                        <%}} %>
                    </div>
                </div>
            </div>
        </div>
        <%@ include file="../section/footer.jsp" %>
    </body>
</html>