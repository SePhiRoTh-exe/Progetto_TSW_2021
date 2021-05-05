package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Carrello;
import model.ProdottoModel;
import model.ProdottoModelDS;

public class ProdottoControl extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static ProdottoModel model=new ProdottoModelDS();
	public ProdottoControl() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//Prendo dalla sessione il contenuto del carrello
		Carrello carrello=(Carrello)request.getSession().getAttribute("cart");
		//Se il carrello è vuoto lo inizializzo i setto l attributo alla sessione
		if(carrello==null) {
			carrello=new Carrello();
			request.getSession().setAttribute("cart", carrello);
		}
		String action=request.getParameter("action");
		try {
			if(action!=null) {
				if(action.equalsIgnoreCase("addC")) {
					int id=Integer.parseInt(request.getParameter("id"));
					carrello.addProdotto(model.doRetrieveByKey(id));
				}
				else if(action.equalsIgnoreCase("deleteC")) {
					int id=Integer.parseInt(request.getParameter("id"));
					carrello.deleteProdotto(model.doRetrieveByKey(id));
				}
			}
		}catch(SQLException e) {
			System.out.println("Errore "+e.getMessage());
		}
		request.getSession().setAttribute("cart", carrello);
		request.setAttribute("cart", carrello);
		
		String sort = request.getParameter("sort");

		try {
			request.removeAttribute("products");
			request.setAttribute("products", model.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Home.jsp");
		dispatcher.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
