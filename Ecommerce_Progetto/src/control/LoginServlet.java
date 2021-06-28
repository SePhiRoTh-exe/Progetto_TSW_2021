package control;


import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datasource.UserModelDS;
import model.UserBean;

public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	public LoginServlet()
	{
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		HttpSession session = request.getSession();
		try {
			UserBean user=new UserBean();
			user.setUsername(request.getParameter("Username"));
			user.setPassword(request.getParameter("Password"));
			user=UserModelDS.doRetrieve(user);
			if(user.isValid())
			{
				session.setAttribute("user", user);
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("LoginPage.jsp");
			}
		}
		catch(Throwable e)
		{
			session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
			response.sendRedirect("./HomePage.jsp");	
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
}
