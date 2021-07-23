package control;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session=request.getSession();
		
		try { 
			//se l'utente non è loggato, allora non può svolgere operazione di logout
			if(session.getAttribute("utente")==null && session.getAttribute("manager")==null) {
				session.setAttribute("alertMsg", "Errore, utente non loggato");
				response.sendRedirect("./Home.jsp");
			}else {
				//la sessione viene svuotata dalle informazioni di utente o manager e quindi il logout avviene
				//con successo
				session.removeAttribute("utente");
				session.removeAttribute("manager");
				session.removeAttribute("cart");
				session.setAttribute("alertMsg", "Logout effettuato con successo.");
				response.sendRedirect("./Home.jsp");
			}
		}catch(Exception e2) {
			
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./Home.jsp");	
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request,response);
	}
}
