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
public class OrderViewControl extends HttpServlet{
	OrdineModelDS ord = new OrdineModelDS();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session=request.getSession();
		
		try {
			//solo l'utente può visualizzare il proprio ordine effettuato, in quanto i manager non possono effettuare ordini
			if(session.getAttribute("utente")==null) {
				session.setAttribute("alertMsg", "Richiesta non valida");
				response.sendRedirect("./Home.jsp");
			}else {
				//se la request nell'url non è valida, errore
				if(request.getParameter("idOrd")==null) {
					session.setAttribute("alertMsg", "Errore nella richiesta");
					response.sendRedirect("./Home.jsp");
				}else {
					//viene preso l'ordine, ma se il valore nella request non corrisponde ad un ordine esistente nel database, errore
					int idOrd=Integer.parseInt(request.getParameter("idOrd"));
					Ordine ordine = ord.doRetrieveById(idOrd);
					if(ordine==null) {
						session.setAttribute("alertMsg", "Richiesta non valida");
						response.sendRedirect("./Home.jsp");
					}else {
						//si deve verificare che l'ordine visualizzato sia effettivamente dell'utente che sta cercando di visualizzarlo
						//quindi si prendono tutti gli ordini da lui effettuati e si fa il confronto
						//se ha riscontro positivo viene mostrato l'ordine nella pagina, altrimenti no
						UserBean u=(UserBean)session.getAttribute("utente");
						ArrayList<Ordine> ordini=ord.doRetrieve(u.getEmail());
						boolean flag=false;
						for(int i=0;i<ordini.size();i++) {
							if(ordini.get(i).getNumeroOrdine()==ordine.getNumeroOrdine()) flag=true;
						}
						if(!flag) {
							session.setAttribute("alertMsg", "Richiesta non valida");
							response.sendRedirect("./Home.jsp");
						}else {
							session.setAttribute("ordine",ordine);
							RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/OrderDetailPage.jsp");
							dispatcher.forward(request, response);
						}
					}
				}
			}
		}catch(Exception e2) {
			
			e2.printStackTrace();
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
			}
	}

}
