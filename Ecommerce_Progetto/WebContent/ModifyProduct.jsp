
    <%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.ProdottoBean,model.Carrello"%>
   
    <%
	if(request.getAttribute("prodotto")==null){
		response.sendRedirect("Home.jsp");
	}
	
	ProdottoBean prodotto=(ProdottoBean)request.getAttribute("prodotto");
	
%>

<!DOCTYPE html>
<html>
<head>
		<script src="./js/ValidateModifyProduct.js"></script>
        <link href='http://fonts.googleapis.com/css?family=Open%20Sans:400,700,600' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Josefin+Sans:400,600,700' rel='stylesheet' type='text/css'> 
        <link href="stile.css" rel="stylesheet" type="text/css">
<meta charset="ISO-8859-1">
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
                            
                            						<tbody>
<tr>
    <td>

                </td>
                <br><br><br>
                <center>
                <h1 style="text-align:center; font-family: 'Josefin Sans', sans-serif">Modifica prodotto:</h1>
                <br><br><br>
                <td>
                <div class="container h-100" style="position:center">
                
                <form action="updateproduct" class="form-group col-md-12" method="get" onsubmit="return ValidateModifyProduct()">
                
                <input type="hidden" name="action" value="mod">
                <div class="form-group< col-md-5">
                <label for="inputZip">Nome prodotto</label>
                <input type="text" class="form-control" id="inputNameProd" name="nomeprod" value="<%= prodotto.getNome() %>">
                <span id="spannameprod" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Minimo 5, massimo 64 (tra caratteri e numeri) </span>
                </div>
                <div class="form-group col-md-5">
                <label for="inputZip">Quantit??</label>
                <input type="number" class="form-control" id="inputQuant" name="quantita" value="<%= prodotto.getQuantita() %>">
                <span id="spanquant" style="display:none; font-family: 'Josefin Sans', sans-serif; border-style: none;"><i class="fa fa-info-circle" aria-hidden="true"></i> Minimo 1, massimo 99 cifre(non sotto lo zero). Dopo la ,/. solo due cifre.</span>
                </div>
                <div class="form-group col-md-5">
                <label for="inputZip">Tipo</label>
                <input type="text" class="form-control" id="inputTipo" name="piattaforma" value="<%= prodotto.getPiattaforma() %>" >
                <span id="spantipo" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Solo caratteri</span>
                </div>
                <div class="form-group col-md-5">
                <label for="inputZip">Costo</label>
                <input type="number" step="0.01" class="form-control" id="inputCosto" name="costo" value="<%= prodotto.getPrezzo() %>" >
                <span id="spancosto" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i>Minimo 1, non sotto lo zero</span>
                </div>
                <div class="form-group col-md-5">
                <label for="inputZip">Codice</label>
                <input type="number" class="form-control" id="inputCodice" name="codice" readonly value="<%= prodotto.getCodice() %>">
                </div>
                <div class="form-group col-md-5">
                <label for="inputZip">Categoria</label>
                <input type="text" class="form-control" id="inputCat" name="categoria" value="<%= prodotto.getCategoria() %>">
                <span id="spancat" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Solo caratteri</span>
                </div>
                 <div class="form-group col-md-8">
                <label for="inputZip">Descrizione</label>
                <textarea class="form-control" id="inputDescr" name="descrizione" style="height:250px"><%= prodotto.getDescrizione() %></textarea>
                <span id="spandescr" style="display:none; font-family: 'Josefin Sans', sans-serif;"><i class="fa fa-info-circle" aria-hidden="true"></i> Minimo 5 caratteri, massimo 1000 (fra caratteri, numeri, simboli..)</span>
                </div>
                <br><br><br>
                <input type="submit" class="btn-primary" value="Conferma modifiche">
                <br><br><br>
                <input type="reset" class="btn-primary" value="Reset">
                </form>
                </div>
                </td>
                </center>
                </tr>
                </tbody>
                            </div>
                        </div>
                    </div>

                </div>
            </div>
        </div>
       <%@ include file="../section/footer.jsp" %>
 
                 <script src="js/JQuery1-11-0.js"></script>
                
             
              
</body>


</html>