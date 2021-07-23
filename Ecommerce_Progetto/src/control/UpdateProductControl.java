package control;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ProdottoBean;
import datasource.ProdottoModelDS;
//modifica di un prodotto
public class UpdateProductControl extends HttpServlet{

 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
ProdottoModelDS pm = new ProdottoModelDS();
 
 	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
 		HttpSession session = request.getSession();
 		try {
 			//solo i manager possono modificare i prodotti
 			if(session.getAttribute("manager")!=null ) {
 				//controllo della validità della request
 				if(request.getParameter("action")!=null){
 					//si prendono i parametri dal form
 					
	 				String categoria= request.getParameter("categoria");
	 				String codice= request.getParameter("codice");
	 				int code = Integer.parseInt(codice);
	 				String costo= request.getParameter("costo");
	 				float cost= Float.parseFloat(costo);
	 				String descrizione = request.getParameter("descrizione");
	 				String nomeProd = request.getParameter("nomeprod");
	 				String quantita = request.getParameter("quantita");
	 				int quantity = Integer.parseInt(quantita);
	 				String piattaforma= request.getParameter("piattaforma");
	 				ProdottoBean bean = new ProdottoBean(code,nomeProd, descrizione, piattaforma, categoria, cost, quantity);
	 				//in base al booleano di risposta del metodo di salvataggio del prodotto, si
	 				//può capire l'esito dell'operazione
	 				if(pm.doSave(bean))
	 					session.setAttribute("alertMsg", "Modifica effettuata");
	 				else
	 					session.setAttribute("alertMsg", "Errore nella modifica");
	 				
	 				response.sendRedirect("./AdminPage.jsp");
 				}else {
 					//se l'action è null ma la request dell'idprod no, viene riaperta la pagina col prodotto
 					if(request.getParameter("idProd")!=null) {
 						int idProd=Integer.parseInt(request.getParameter("idProd"));
 						ProdottoBean prodotto=pm.doRetrieveByKey(idProd);
 						request.setAttribute("prodotto", prodotto);
 						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ModifyProduct.jsp");
 						dispatcher.forward(request, response);

 					}else {
 						session.setAttribute("alertMsg", "Errore nella richiesta");
 		 				response.sendRedirect("./AdminMod.jsp");
 					}
 				}
 			}
 			else {
 				session.setAttribute("alertMsg", "Accesso non autorizzato");
 				response.sendRedirect("./Home.jsp");
 			}
 		}
 		
 		
 		catch(Exception e2) {
			
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
			}
}
}