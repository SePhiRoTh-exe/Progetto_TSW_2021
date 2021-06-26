package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.ProdottoModel;
import datasource.ProdottoModelDS;
import model.Carrello;

public class AddToCartControl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		try {
				if(request.getAttribute("utente")!=null) {
					Carrello cart = (Carrello) request.getAttribute("cart");
					int id = (int) request.getAttribute("idProd");
					
						cart.addProdotto(id);
						
					response.sendRedirect("./Carrello.jsp");
					
				}
				
				else {
					session.setAttribute("alertMsg","Accesso non autorizzato");
					response.sendRedirect("/Home.jsp");
				}
		
	}
		
		catch (SQLException e) {
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./HomePage.jsp");	
		}
}
}
