package control;

import java.io.IOException;

import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.OrdineModelDS;
import datasource.ProdottoModelDS;
import model.UserBean;
import datasource.UserModelDS;
import model.Carrello;
import model.Ordine;

public class PlaceOrderControl extends HttpServlet {
	
	private static OrdineModelDS orderManager = new OrdineModelDS();
	private static UserModelDS userManager= new UserModelDS();
	private UserBean utente;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("user")!=null) {
				String email= (String) session.getAttribute("email");
				utente = UserModelDS.doRetrieve(email);
				
				if(session.getAttribute("cart")!=null) {
					Carrello cart = (Carrello) session.getAttribute("cart");
					if(cart.getProdotti().size()==0) {
						session.setAttribute("alertMsg", "Errore, carrello vuoto");
						response.sendRedirect("./Home.jsp");
					}
					else {	
					
						if(OrdineModelDS.doSave(cart, utente)) {
						
							session.setAttribute("cart", null);
							session.setAttribute("alertMsg", "Ordine effettuato con successo");
							response.sendRedirect("./Home.jsp");
						}
					}
					
		
				}
				else {
					  session.setAttribute("alertMsg", "Carrello non esistente");
					  response.sendRedirect("./Home.jsp");
				}
			
			}
			else {
				session.setAttribute("alertMsg", "I manager non possono effettuare acquisti");
				response.sendRedirect("./Home.jsp");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
		

}
