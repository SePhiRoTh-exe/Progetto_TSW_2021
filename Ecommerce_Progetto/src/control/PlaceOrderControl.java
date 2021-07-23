package control;

import java.io.IOException;


import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import datasource.OrdineModelDS;
import datasource.ProdottoModelDS;
import model.UserBean;
import model.Carrello;
import model.ProdottoBean;

public class PlaceOrderControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean utente;
	ProdottoModelDS pro= new ProdottoModelDS();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session = request.getSession();
		try {
			if(session.getAttribute("utente")!=null) {
				System.out.println("UTENTE PRESENTE");
				utente=(UserBean) session.getAttribute("utente");
				if(session.getAttribute("cart")!=null) {
					System.out.println("CARRELLO PRESENTE");
					Carrello cart = (Carrello) session.getAttribute("cart");
					if(cart.getProdotti().size()==0) {
						System.out.println("CARRELLO VUOTO");
						session.setAttribute("alertMsg", "Errore, carrello vuoto");
						response.sendRedirect("./Home.jsp");
					}
					else {	
						if(OrdineModelDS.doSave(cart, utente)) {
							System.out.println("ORDINE SALVATO");
							for(int i=0;cart.getProdotti().size()>i;i++) {
								int comprato=cart.getProdotti().get(i).getQuantità();
								ProdottoBean pr=cart.getProdotti().get(i).getProduct();
								System.out.println(pr.getQuantita());
								pr.setQuantita(pr.getQuantita()-comprato);
								pro.doSave(pr);
							}
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
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
			
		}
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
