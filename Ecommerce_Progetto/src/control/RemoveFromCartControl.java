package control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;

public class RemoveFromCartControl extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//CONFIGURATA NEL XML
		HttpSession session = request.getSession();
		if(session.getAttribute("utente")!=null) {
			Carrello cart = (Carrello) session.getAttribute("cart");
			
			int id = Integer.parseInt(request.getParameter("idProd"));
			cart.deleteProdotto(id);
			session.setAttribute("cart", cart);
			response.sendRedirect("./Carrello.jsp");
			
		}
		
		else {
			session.setAttribute("alertMsg","Accesso non autorizzato");
			response.sendRedirect("./Home.jsp");
		}
}
}
