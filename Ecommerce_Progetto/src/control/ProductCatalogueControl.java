package control;

import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdottoBean;
import datasource.ProdottoModelDS;


public class ProductCatalogueControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		ProdottoModelDS pds = new ProdottoModelDS();
		try {
		if(request.getParameter("catalog")==null) {
			
			
			
			ArrayList <ProdottoBean> prodotti = new ArrayList<ProdottoBean>(pds.doRetrieveAllProducts());
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
			dispatcher.forward(request, response);
			
		}
		else {
			 
				//se la ricerca è avvenuta per categoria, allora vengono presi tutti i prodotti 
				//di una data categoria dal database e mostrati nella pagina
				if(request.getParameter("by").equalsIgnoreCase("categoria")){
					ArrayList<ProdottoBean> prodotti=(ArrayList<ProdottoBean>) pds.doRetrieveByCat(request.getParameter("q"));
					request.setAttribute("prodotti", prodotti);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ricerca.jsp");
					dispatcher.forward(request, response);
				}
				else if(request.getParameter("by").equalsIgnoreCase("name")) {
					ArrayList<ProdottoBean> prodotti=(ArrayList<ProdottoBean>) pds.doRetrieveByName(request.getParameter("q"));
					request.setAttribute("prodotti", prodotti);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Ricerca.jsp");
					dispatcher.forward(request, response);
					
				}
			
			
		}
		}
		catch (SQLException e) {
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./HomePage.jsp");	
		} 
	}
}
