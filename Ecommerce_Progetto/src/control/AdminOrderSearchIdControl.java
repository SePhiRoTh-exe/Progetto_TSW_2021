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

public class AdminOrderSearchIdControl extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
	
	OrdineModelDS ord = new OrdineModelDS();
	HttpSession session=request.getSession();
	try {
			//Solo i manager possono effettuare operazioni di ricerca degli ordini
			if(session.getAttribute("manager")!=null) {
				//viene controllato che la richiesta contenga il parametro collegato all'id 
				if(request.getParameter("idOrd")==null) {
					session.setAttribute("alertMsg", "Operazione non valida");
					response.sendRedirect("./Home.jsp");
				}
				else {
					 	
						Ordine o=ord.doRetrieveById(Long.parseLong(request.getParameter("idOrd")));
						//se non esistono ordini collegati all'id inserito, allora si ritorna alla pagina 
						// di amministrazione
						if(o==null) {
							session.setAttribute("alertMsg", "Ordine non trovato");
							response.sendRedirect("./OrdersManagerPage.jsp");
							
						}else {
							//altrimenti, viene mostrato il risultato della ricerca nella pagina
							ArrayList<Ordine> array=new ArrayList<Ordine>();
							array.add(o);
							session.setAttribute("ordini", array);
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrdersManagerPage.jsp");
							dispatcher.forward(request, response);
						}
					}
				}
			//gli utenti normali vengono reindirizzati alla homepage
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
