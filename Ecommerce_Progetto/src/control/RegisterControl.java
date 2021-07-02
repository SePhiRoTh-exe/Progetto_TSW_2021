package control;
import java.io.IOException;
import java.sql.SQLException;

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
		
		if(session.getAttribute("user")==null && session.getAttribute("manager")==null) {
			
			String nome=request.getParameter("Nome");  
			String cognome=request.getParameter("Cognome");
			String username=request.getParameter("Username");
			String psw=request.getParameter("Password");  
			String email=request.getParameter("Email"); 
			//String paymentInst=request.getParameter("userPaymentInst");
			
			/*da cambiare questa parte perche la gestione del metodo di pagamento non puo essere fatta alla registrazione ma deve essere gestita dalla 
			 * user page ed aggiunta o in un secondo momento oppure al checkout*/
			/*
			String paymentCo=request.getParameter("userPaymentCode");
			String paymentExpMonth=request.getParameter("userPaymentExpMonth");
			String paymentExpyear=request.getParameter("userPaymentExpYear");
			String paymentCvv=request.getParameter("userPaymentCvv");
			String payment=paymentInst+", "+paymentCo+", "+paymentExpMonth+"/"+paymentExpyear+", "+paymentCvv;
			*/
			
			try {
				UserBean user = new UserBean(nome, cognome, username, psw, email);
				if(UserModelDS.doRetrieve(email).isValid()) {
					//SE E VALIDO VUOL DIRE CHE ESISTE GIA UN UTENTE CON QUESTA EMAIL
					session.setAttribute("alertMsg", "Registrazione fallita.");
					response.sendRedirect("./LoginPage.jsp");
				}
				else {
					UserModelDS.doSave(user);
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
		doGet(request,response);
	}
}
