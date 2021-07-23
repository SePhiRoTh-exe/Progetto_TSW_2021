<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello,model.*"%>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
		<link href="./css/stile2.css" rel="stylesheet" type="text/css">
		<link href="stile.css" rel="stylesheet" type="text/css">
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
	
    <!-- DA AGGIUNGERE RITORNO A PAGINA DI ERRORE IN CASO DI PRODOTTO NULL ED AGGIUNGERE IL CONTROLLO UTENTE-->
                        
<div id="ig-main-container">
<div id="home-top-banner-wrapper">
</div>
<div class="ig-wrapper ig-mainwrapper mainshadow  rounded">
<div id="ig-panel-center">
<div class="payment-container">
<form id="buy-card-form" action="placeOrder" method="post">
<div class="warnings">
</div>
<div class="ig-sections-header">Riepilogo ordine:</div>
<div class="ig-sections-main-content ig-new-payment-page">
<div class="ig-wrapper2">
<input type="hidden" name="prod_id" value="6791" />
<input id="ewallet-use" type="hidden" name="ewallet" value="0" />
<input id="plat-id" type="hidden" name="platform" value="12" />
<input id="plat-method" type="hidden" name="platform-method" value="cb" />
<input id="pluginsdata" type="hidden" name="pluginsdata" value="" />
<input type="hidden" name="process" value="pay" />
<input type="hidden" name="usid" value="9824ff8d1b84d6738ab4336bd2e951df" />
<input type="hidden" name="ioBB" id="ioBB" />
<table class="payment-table">
<thead class="title">
<tr>
<th colspan="2" width="35%">Prodotto</th>
<th>Piattaforma</th>
<th>Consegna</th>
<th style="min-width: 77px;">Prezzo</th>
</tr>
</thead>
<tbody>
<% if(cart.getProdotti().size()==0){%>
	<h2>Vuoto, aggiungi qualcosa!</h2>
	<%
	}else{%> 
		     
  <%  for(int i=0;i<lista.size();i++){ 
  	ProdottoCarrello prodotto=lista.get(i); %>

<tr class="product-basket">
<td class="jacket">
<img src="./img/<%=prodotto.getProduct().getImg()%>-cover.jpg" style="width:47px; height:65px;"alt="img" title="img" />
</td>
<td class="pname">
<b><%=prodotto.getProduct().getNome()%></b>
</td>
<td class="product-type" data-th="Piattaforma">
<div>
 <span class="badge <%=prodotto.getProduct().getPiattaforma()%>"></span>
<b><%=prodotto.getProduct().getPiattaforma()%></b>
</div>
</td>
<td data-th="Consegna" class="pdelivery">
<b>Immediato</b>
</td>
<td data-th="Prezzo">
<b><%=prodotto.getQuantità()*prodotto.getProduct().getPrezzo()%>€</b>
</td>
</tr>
<%} }%>



<tr class="total">
<td colspan="3"></td>
<td colspan="2" class="thead">Pagamento quota: :</td>
<td class="platform_fees" style="color:green">0.00€</td>
</tr>
<tr class="total" id="ig-vat" data-rate="0">
<td colspan="3"></td>
<td colspan="2" class="thead ig-vat-percentage">
VAT (<span>0</span>%) :
</td>
<td class="ig-vat-value">
<span class="is-free">
0.00€
</span>
</td>
</tr>
<tr class="total">
<td colspan="3"></td>
<td colspan="2" class="thead texttotal">Totale :</td>
<td class="totalprice subtotal"><%=cart.getTotale()%>€</td>
</tr>
</tbody>
</table>
<input type="submit" class="button" value="compra">
</div>
</div>
</div>
</form>
<div id="redirectSpinner" style="display: none; text-align: center; padding: 20px; color: #ff5400;">
Stai per essere reindirizzato alla piattaforma di pagamento sicuro ...
<div class="loader">loading...</div>
</div>

</div>
</div>
</div>
</div>
</html>
                        
       <%@ include file="../section/footer.jsp" %>
		

</body>
</html>