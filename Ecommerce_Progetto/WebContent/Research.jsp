<%
	Collection<?> prodotti = (Collection<?>) request.getAttribute("prodotti");
	if(prodotti == null) {
		response.sendRedirect("./productviewcontrol");	
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
    <%if(session.getAttribute("alertMsg")!=null){%>
<h3><font color="red"><%=session.getAttribute("alertMsg")%></font></h3>
<%session.setAttribute("alertMsg","");
session.setAttribute("redirect",null);
%>
<%}%>
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
            <div class="content main-cat ombre">
                <div class="pannello-centrale">
                    <div class="titolo">
                        <div class="categoria">Risultati</div>
                    </div>
                    <div class="catalogo">
                   	<%
					if (prodotti != null && prodotti.size() != 0) {
						Iterator<?> it = prodotti.iterator();
						while (it.hasNext()) {
							ProdottoBean prodotto = (ProdottoBean) it.next();
					%>
                        <div class="item">
                            <%if(session.getAttribute("manager")==null){ %>
                            <a class="cover" href="prodotto?idProd=<%=prodotto.getCodice() %>" title="Battlefield">
                            <%} else {%>
                            	<a class="cover" href="updateproduct?idProd=<%=prodotto.getCodice() %>" title="Battlefield">
                            	<%} %>
                                <div class="badge <%=prodotto.getPiattaforma() %>"></div>
                                <img class="picture ombre" src="img/<%=prodotto.getImg()%>-cover.jpg" alt="Battlefield V" onload="lazyLoadImage(this)">
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
        <br>
        <br>
                <br>
        <br>
                <br>
        <br>
                <br>
        <br>
                <br>
        <br>
                <br>
        <br>

        <%@ include file="../section/footer.jsp" %>
    </body>
</html>