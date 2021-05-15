package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class UserModelDS {
	static {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			ds=(DataSource) envCtx.lookup("jdbc/storage");
		}catch(NamingException e){
			System.out.println("Errore:" + e.getMessage());
		}
	}
	public static synchronized UserBean doRetrieve(UserBean bean) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String username=bean.getUsername();
		String password=bean.getPassword();
		String selectSQL="SELECT * FROM "+TABLE_NAME+" WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			rs=preparedStatement.executeQuery(selectSQL);
			boolean exist=rs.next();
			
			if(!exist) bean.setValid(false);
			else
			{
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setValid(true);
			}
		}
		catch(Exception e)
		{
			System.out.println("Login fallito"+e);
		}
		finally
		{
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
		return bean;
	}
	private final static String TABLE_NAME="users";
	private static DataSource ds;
	private static ResultSet rs;
}
