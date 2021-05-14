package control;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserBean;
import model.UserModelDS;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID=1L;
	public LoginServlet()
	{
		super();
	}
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		try {
			UserBean user=new UserBean();
			user.setUsername(request.getParameter("Username"));
			user.setPassword(request.getParameter("Password"));
			user=userDS.doRetrieve(user);
			if(user.isValid())
			{
				HttpSession session=request.getSession(true);
				session.setAttribute("currentSession", user);
				response.sendRedirect("Home.jsp");
			}
			else
			{
				response.sendRedirect("LoginPage.jsp");
			}
		}
		catch(Throwable e)
		{
			System.out.println(e);
		}
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
		doGet(request,response);
	}
	private static UserModelDS userDS;
}
