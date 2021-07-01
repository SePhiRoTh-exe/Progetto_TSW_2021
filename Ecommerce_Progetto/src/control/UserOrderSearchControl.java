package control;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.OrdineModelDS;
import model.UserBean;
import model.Ordine;

public class UserOrderSearchControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("utente")!=null) {
				UserBean utente = (UserBean) session.getAttribute("utente");
				ArrayList <Ordine> ordini = OrdineModelDS.doRetrieve(utente.getEmail());
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
