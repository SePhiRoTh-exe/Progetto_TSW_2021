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

public class ViewCartControl {
	
	private static final long serialVersionUID = 1L;
	static ProdottoModel model=new ProdottoModelDS();
	public ViewCartControl() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(request.getSession().getAttribute("utente")!=null) {
		//Prendo dalla sessione il contenuto del carrello
			Carrello carrello=(Carrello)request.getSession().getAttribute("cart");
		//Se il carrello è vuoto lo inizializzo i setto l attributo alla sessione
			if( carrello != null) {
				if(carrello.isEmpty()) {
					session.setAttribute("alertMsg", "Carrello vuoto");
					response.sendRedirect("./Home.jsp");
					}
			
			}
			else {
				session.setAttribute("alertMsg", "Carrello vuoto");
				response.sendRedirect("./Home.jsp");
			}
				response.sendRedirect("./Carrello.jsp");
			}
		
		else {	
			session.setAttribute("alertMsg", "Gli amministratori non possono avere un carrello");
			response.sendRedirect("./Home.jsp");
		}
					
		

}
}
