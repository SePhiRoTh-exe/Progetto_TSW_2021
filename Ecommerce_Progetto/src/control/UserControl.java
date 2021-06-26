package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.ProdottoModelDS;
import model.UserBean;

public class UserControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserBean utente;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		HttpSession session=request.getSession();
		utente=(UserBean) session.getAttribute("user");
		try {
			if(utente!=null) {
				String action=request.getParameter("action");
				if(action.equalsIgnoreCase("vieworders")) {
					request.setAttribute("orders", ProdottoModelDS.doRetrieveByEmail(utente.getEmail()));
					RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/UserPage.jsp");
					dispatcher.forward(request, response);
				}
			}
			else
			{
				RequestDispatcher dispatcher=getServletContext().getRequestDispatcher("/Home.jsp");
				dispatcher.forward(request, response);
			}
		}catch(SQLException e) {
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./HomePage.jsp");	
		}
	}
}
