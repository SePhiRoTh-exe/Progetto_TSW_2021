package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.PasswordCrypt;
import model.UserBean;

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
	public static synchronized UserBean doRetrieve(UserBean bean) throws Exception{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		PasswordCrypt crypt=new PasswordCrypt();
		System.out.println(bean.getUsername());
		String username=bean.getUsername();
		String password=crypt.encrypt(bean.getPassword());
		String selectSQL="SELECT * FROM STORAGE."+TABLE_NAME+" WHERE USERNAME='"+username+"' AND PASSWORD='"+password+"'";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			rs=preparedStatement.executeQuery(selectSQL);
			boolean exist=rs.next();
			
			if(!exist)
				bean.setValid(false);
			else {
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setEmail(rs.getString("Email"));
				bean.setAdmin(rs.getBoolean("Admin"));
				bean.setValid(exist);
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
	public static synchronized UserBean doRetrieve(String email) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		System.out.println(email);
		String UserSelectSQL="SELECT * FROM "+TABLE_NAME+" WHERE EMAIL ='"+email+"'";
		UserBean bean=new UserBean();
		
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(UserSelectSQL);
			ResultSet rs=preparedStatement.executeQuery(UserSelectSQL);
			boolean exist=rs.next();
			if(!exist) bean.setValid(false);
			else {
				bean.setNome(rs.getString("Nome"));
				bean.setCognome(rs.getString("Cognome"));
				bean.setUsername(rs.getString("Username"));
				bean.setPassword(rs.getString("Password"));
				bean.setEmail(email);
				bean.setValid(true);
				bean.setAdmin(rs.getBoolean("Admin"));
				System.out.println(bean.getCognome());
			}
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
		System.out.println("return");
		return bean;
	}
	
	public static synchronized boolean doSave(UserBean bean) throws Exception{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		PasswordCrypt crypt=new PasswordCrypt();
		String insertSQL="INSERT INTO STORAGE."+TABLE_NAME+"(EMAIL, NOME, COGNOME, USERNAME, PASSWORD, ADMIN) VALUES (?, ?, ?, ?, ?, ?)";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, bean.getEmail());
			preparedStatement.setString(2, bean.getNome());
			preparedStatement.setString(3, bean.getCognome());
			preparedStatement.setString(4, bean.getUsername());
			preparedStatement.setString(5, crypt.encrypt(bean.getPassword()));
			preparedStatement.setBoolean(6, false);
			preparedStatement.executeUpdate();
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
		return true;
	}
	private final static String TABLE_NAME="users";
	private static DataSource ds;
	private static ResultSet rs;
}
