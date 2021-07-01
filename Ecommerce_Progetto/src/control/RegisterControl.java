package control;
import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.UserModelDS;
import model.UserBean;

public class RegisterControl extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		HttpSession session = request.getSession();
		UserModelDS usr = new UserModelDS();
		
		if(session.getAttribute("user")==null || session.getAttribute("admin")==null) {
			
			String nome=request.getParameter("Name");  
			String cognome=request.getParameter("Surname");
			String username=request.getParameter("userName");
			String psw=request.getParameter("userPass");  
			String email=request.getParameter("userEmail"); 
			String paymentInst=request.getParameter("userPaymentInst");
			
			/*da cambiare questa parte perche la gestione del metodo di pagamento non puo essere fatta alla registrazione ma deve essere gestita dalla 
			 * user page ed aggiunta o in un secondo momento oppure al checkout*/
			String paymentCo=request.getParameter("userPaymentCode");
			String paymentExpMonth=request.getParameter("userPaymentExpMonth");
			String paymentExpyear=request.getParameter("userPaymentExpYear");
			String paymentCvv=request.getParameter("userPaymentCvv");
			String payment=paymentInst+", "+paymentCo+", "+paymentExpMonth+"/"+paymentExpyear+", "+paymentCvv;
			
			try {
				UserBean user = new UserBean(nome, cognome, username, psw, email, payment );
				usr.doSave(user);
				
				if(usr.doRetrieve(email)==null) {
					session.setAttribute("alertMsg", "Registrazione fallita.");
					response.sendRedirect("./Signup.jsp");
				}
				else {
					session.setAttribute("alertMsg", "Registrazione effettuata con successo");
					session.setAttribute("utente", user);
					response.sendRedirect("./Home.jsp");
				}
			}
			
			catch(SQLException e) {
				session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
				response.sendRedirect("./HomePage.jsp");	
			}
			
		}
		else {
			session.setAttribute("alertMsg", "non è possibile registrarsi");
			response.sendRedirect("./Home.jsp");
		}
	}
}
