package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datasource.ProdottoModelDS;
import model.Carrello;
import model.ProdottoModel;

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
				else if(action.equalsIgnoreCase("view")) {
					int id=Integer.parseInt(request.getParameter("id"));
					//rimuovo il precedente prodotto di cui ho letto la descrizione e metto quello nuovo
					request.removeAttribute("product");
					request.setAttribute("product", model.doRetrieveByKey(id));
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
		if(action!=null && action.equalsIgnoreCase("deleteC"))
		{
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Carrello.jsp");
			dispatcher.forward(request, response);
		}
		else if(action!=null && action.equalsIgnoreCase("view")) {
			RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Descrizione.jsp");
			dispatcher.forward(request, response);
		}
		else {
		RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Home.jsp");
		dispatcher.forward(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		doGet(request,response);
	}
}
