package control;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class LogoutControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

		HttpSession session=request.getSession();
		
		try { 
			//se l'utente non � loggato, allora non pu� svolgere operazione di logout
			if(session.getAttribute("utente")==null&&session.getAttribute("manager")==null) {
				session.setAttribute("alertMsg", "Errore, utente non loggato");
				response.sendRedirect("./HomePage.jsp");
			}else {
				//la sessione viene svuotata dalle informazioni di utente o manager e quindi il logout avviene
				//con successo
				session.removeAttribute("utente");
				session.removeAttribute("manager");
				session.setAttribute("alertMsg", "Logout effettuato con successo.");
				response.sendRedirect("./HomePage.jsp");
			}
		}catch(Exception e2) {
			
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./HomePage.jsp");	
			}
	}

}
