<%@ page contentType="text/html; charset=UTF-8" import="java.util.*,model.UserBean"%>
<div class="navbar">
	<a href="<%=request.getContextPath() %>/Home.jsp">HOME</a>
	<a href="<%=request.getContextPath() %>/Carrello.jsp">CARRELLO</a>
	<% 
		if(session.getAttribute("user")==null){
	%>
	<a href="<%=request.getContextPath() %>/LoginPage.jsp">SIGN IN/SIGN UP</a>
	<%} 
		else {
	%>
	<a href="<%=request.getContextPath() %>/UserPage.jsp">ACCOUNT</a>
	<%} %>
</div>