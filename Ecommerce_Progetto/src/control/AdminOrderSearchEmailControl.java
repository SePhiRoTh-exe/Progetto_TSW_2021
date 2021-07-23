package control;

import java.io.IOException;

import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


import datasource.OrdineModelDS;
import model.UserBean;
import model.Ordine;

public class AdminOrderSearchEmailControl extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	
	OrdineModelDS ord = new OrdineModelDS();
	HttpSession session=request.getSession();
	try {
			//solo i manager possono effettuare la ricerca degli ordini
			if(session.getAttribute("manager")!=null) {
				session.setAttribute("mailTest",request.getParameter("mailOrd"));
				//viene controllato che la richiesta contenga il parametro collegato all'email
				//questo può avvenire se il manager prova a cancellare un prodotto tramite un
				//url scorretto, e non dalla sua pagina di amministrazione
				if(request.getParameter("mailOrd")==null) {
					session.setAttribute("alertMsg", "Operazione non valida");
					response.sendRedirect("./Home.jsp");
				}
				else {
					
						//la classe manager comunica col dao che prende gli ordini legati all'email dal database
						ArrayList<Ordine> ordini=ord.doRetrieve(request.getParameter("mailOrd"));
						if(ordini==null||ordini.size()==0) {
							//se nessun ordine viene trovato, errore
							session.setAttribute("alertMsg", "Nessun ordine trovato per la mail: "+request.getParameter("mailOrd"));
							response.sendRedirect("./OrdersManagerPage.jsp");
						}else {
							//altrimenti vengono mostrati gli ordini nella pagina
							session.setAttribute("ordini",ordini);
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrdersManagerPage.jsp");
							dispatcher.forward(request, response);
						}
					}
				}
			
			else {
				session.setAttribute("alertMsg", "Operazione non autorizzata");
				response.sendRedirect("./Home.jsp");
		}
	
		
	}catch(Exception e2) {
		
		session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
		response.sendRedirect("./Home.jsp");	
		}
}

}

