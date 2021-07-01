package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProdottoBean;
import datasource.ProdottoModelDS;

public class ProductViewControl extends HttpServlet {
	
	//CONFIGURATA NEL XML
	//visualizzazione di un prodotto
	
	private static final long serialVersionUID = 1L;
		static ProdottoModelDS pm=new ProdottoModelDS();
		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
			HttpSession session=request.getSession();
			try {
				
				if(request.getParameter("idProd")==null) {
					//id nullo, si ritorna alla home page e vengono mostrati tutti i prodotti
					ArrayList<ProdottoBean> prodotti=(ArrayList<ProdottoBean>) pm.doRetrieveAllProducts();
					request.setAttribute("prodotti", prodotti);
					if(session.getAttribute("manager")!=null) {
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/AdminMod.jsp");
						dispatcher.forward(request, response);
					}else {
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Home.jsp");
						dispatcher.forward(request, response);
					}
				}else {
					// se la request è regolare, allora viene mostrato il prodotto nella pagina
					if(request.getParameter("idProd")!=null) {
						int idProd=Integer.parseInt(request.getParameter("idProd"));
						ProdottoBean prodotto=pm.doRetrieveByKey(idProd);
						request.setAttribute("prodotto", prodotto);
						RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ProductView.jsp");
						dispatcher.forward(request, response);
					
					}
				}
			
			} catch(Exception e2) {
				
				session.setAttribute("alertMsg","Errore, ritorno alla Homepage");
				response.sendRedirect("./Home.jsp");	
				}
			}
	}


