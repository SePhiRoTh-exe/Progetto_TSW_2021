package control;

import java.io.IOException;


import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import datasource.OrdineModelDS;
import model.UserBean;
import model.Ordine;

//visualizzazione di un ordine effettuato dall'utente loggato
public class ViewOrdersControl extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	OrdineModelDS ord = new OrdineModelDS();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		
		try {
			//solo l'utente può visualizzare il proprio ordine effettuato, in quanto i manager non possono effettuare ordini
			if(session.getAttribute("utente")==null) {
				session.setAttribute("alertMsg", "Richiesta non valida");
				response.sendRedirect("./Home.jsp");
			}else {
				UserBean utente = (UserBean) session.getAttribute("utente");
				ArrayList<Ordine> listaOrdini= ord.doRetrieve(utente.getEmail());
				session.setAttribute("ordini", listaOrdini);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderPage.jsp");
				dispatcher.forward(request, response);
			}
				
				
		}
		catch(Exception e2) {
			
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
			}
		
	}
}
	