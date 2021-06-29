package control;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.OrdineModelDS;
import model.UserBean;
import model.Carrello;
import model.Ordine;

public class UserOrderSearchControl extends HttpServlet {
	
	OrdineModelDS ord = new OrdineModelDS();
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("utente")!=null) {
				UserBean utente = (UserBean) session.getAttribute("utente");
				ArrayList <Ordine> ordini = ord.doRetrieve(utente.getEmail());
				session.setAttribute("ordini", ordini);
				response.sendRedirect("./OrderPage.jsp");
			
			}
			else {
				session.setAttribute("alertMsg", "Pagina non disponibile");
				response.sendRedirect("./Home.jsp");
			}
		
		}
		catch(Exception e2) {
			
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
		}
	
		
	}
			

}
