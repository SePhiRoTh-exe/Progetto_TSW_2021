package datasource;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Carrello;
import model.Ordine;
import model.UserBean;

public class OrdineModelDS {
	static {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			ds=(DataSource) envCtx.lookup("jdbc/storage");
		}catch(NamingException e){
			System.out.println("Errore:" + e.getMessage());
		}
	}
	
	public static synchronized Ordine doRetrieve(String email) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Ordine ordine=null;
		UserBean user=UserModelDS.doRetrieve(email);
		String selectSQL="SELECT * FROM "+OrdineModelDS.TABLE_NAME+" WHERE EMAIL ='"+email+"'";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				ordine=new Ordine(rs.getLong("IDORDINE"),rs.getFloat("TOTALE"),rs.getString("STATO"),user,ProdottoModelDS.doRetrieveByEmail(email));
			}
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
		return ordine;
	}
	
	public static synchronized boolean doSave(Carrello cart, UserBean user) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		java.util.Date data=new java.util.Date();
		Date date = new Date(data.getTime());
		//formatto la data da inserire nei dati dell ordine
		
		int id;
		
		//da modificare aggiungendo il check che valuta se ci sono ordini con lo stesso id nel database
		{
			id= (int) ((int) 1000*Math.random())+10000;
		}
		String stato= "In preparazione";
		
		
		//Salvo l'ordine nel DB
		String insertSQL="INSERT INTO STORAGE."+TABLE_NAME+" (IDORDINE, STATO, TOTALE, EMAIL, DATA) VALUES (?, ?, ?, ?, ?)";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, stato);
			preparedStatement.setFloat(3, cart.getTotale());
			preparedStatement.setString(4,user.getEmail());
			preparedStatement.setDate(5,date);
			preparedStatement.executeUpdate();
			
			
		}
		finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
		
		//Salvo i prodotti ordinati nel DB
		
		if(ProdottoOrdineDS.doSave(cart.getProdotti(), id)) {
		return true;
		}
		return false;
	}
	private final static String TABLE_NAME="order";
	private static DataSource ds;
}
