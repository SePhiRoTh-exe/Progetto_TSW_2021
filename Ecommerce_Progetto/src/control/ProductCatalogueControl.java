package control;

import java.io.IOException;



import java.sql.SQLException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.ProdottoBean;
import datasource.ProdottoModelDS;


public class ProductCatalogueControl extends HttpServlet {
	//CONFIGURATA NEL XML
	private static final long serialVersionUID = 1L;

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		ProdottoModelDS pds = new ProdottoModelDS();
		
		try {
		if(request.getParameter("catalog")!=null) {
			String tipo=request.getParameter("catalog");
			ArrayList <ProdottoBean> prodotti = new ArrayList<ProdottoBean>(pds.doRetrieveAllProducts());
			request.setAttribute("prodotti", prodotti);
			if(tipo.equals("2"))
			{
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminPage.jsp");
				dispatcher.forward(request, response);
			}
			else
			{
			
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);
			}
			
			
		}
		else {
			 
				//se la ricerca è avvenuta per categoria, allora vengono presi tutti i prodotti 
				//di una data categoria dal database e mostrati nella pagina
				String p=request.getParameter("by");
				if(request.getParameter("by").equalsIgnoreCase("categoria")){
					ArrayList<ProdottoBean> prodotti=(ArrayList<ProdottoBean>) pds.doRetrieveByCat(request.getParameter("q"));
					request.setAttribute("prodotti", prodotti);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Research.jsp");
					dispatcher.forward(request, response);
				}
				else if(request.getParameter("by").equalsIgnoreCase("name")) {
					ArrayList<ProdottoBean> prodotti=(ArrayList<ProdottoBean>) pds.doRetrieveByName(request.getParameter("name"));
					System.out.println("prodotti caricati");
					request.setAttribute("prodotti", prodotti);
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Research.jsp");
					dispatcher.forward(request, response);
					
				}
			
			
		}
		}
		catch (SQLException e) {
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
		} 
	}
}
