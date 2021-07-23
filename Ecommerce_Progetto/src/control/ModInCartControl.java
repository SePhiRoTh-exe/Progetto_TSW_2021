package control;
import java.io.IOException;


import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Carrello;

public class ModInCartControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public ModInCartControl() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(request.getSession().getAttribute("utente")!=null) {
		//Prendo dalla sessione il contenuto del carrello
			Carrello carrello=(Carrello)request.getSession().getAttribute("cart");
			int changeQ = Integer.parseInt(request.getParameter("change"));
			//HO MESSO L ID DI TIPO INTERO MOMENTANEAMENTE ALTRIMENTI ANDAVANO CAMBIATE TROPPE COSE AL MOMENTO ANCHE NEL DATABASE
			//long id= Long.parseLong(request.getParameter("idProd"));
			int id=Integer.parseInt(request.getParameter("idProd"));
			//QUA IN MOD QUANTITA NON ERA STATO MESSO L ID MA DI NUOVO LA QUANTITA
			carrello.modQuantità(id, changeQ);
			response.sendRedirect("./Carrello.jsp");
			
			}
			else {
				session.setAttribute("alertMsg", "accesso non autorizzato");
				response.sendRedirect("./Home.jsp");
			}
}
}


