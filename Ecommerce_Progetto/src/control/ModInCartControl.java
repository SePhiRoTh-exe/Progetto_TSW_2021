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

public class ModInCartControl {
	public ModInCartControl() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(request.getSession().getAttribute("utente")!=null) {
		//Prendo dalla sessione il contenuto del carrello
			Carrello carrello=(Carrello)request.getSession().getAttribute("cart");
			int changeQ = Integer.parseInt(request.getParameter("change"));
			long id= Long.parseLong(request.getParameter("idProd"));
			carrello.modQuantità(changeQ, changeQ);
			response.sendRedirect("./Carrello.jsp");
			
			}
			else {
				session.setAttribute("alertMsg", "accesso non autorizzato");
				response.sendRedirect("./Home.jsp");
			}
			
		
		
					
		

}
}


