package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Carrello;

public class AddToCartControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//CONFIGURATA NEL XML
		HttpSession session = request.getSession();
		try {
				if(session.getAttribute("utente")!=null) {
					Carrello cart = (Carrello) session.getAttribute("cart");
					
					//LA VIEWCARTCONTROL NON SERVE POICHE IL CARRELLO E' GESTITO NELLA SESSIONE E LA JSP CONTROLLA SE ESISTE O MENO
					if(cart==null)
					{
						cart=new Carrello();
					}
					int id = Integer.parseInt(request.getParameter("idProd"));
					cart.addProdotto(id);
					session.setAttribute("cart", cart);
					response.sendRedirect("./Carrello.jsp");
					
				}
				
				else {
					session.setAttribute("alertMsg","Accesso non autorizzato");
					response.sendRedirect("./LoginPage.jsp");
				}
		
	}
		
		catch (SQLException e) {
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
		}
}
}
