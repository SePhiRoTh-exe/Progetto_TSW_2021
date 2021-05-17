package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Carrello;
import model.Ordine;
import model.ProdottoCarrello;
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
		LocalDate date = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String data = date.format(formatter);
		//formatto la data da inserire nei dati dell ordine
		
		int id;
		
		//da modificare aggiungendo il check che valuta se ci sono ordini con lo stesso id nel database
		{
			id= (int) ((int) 1000*Math.random())+10000;
		}
		String stato= "In preparazione";
		
		
		//Salvo l'ordine nel DB
		String insertSQL="INSERT INTO "+TABLE_NAME+" (IDORDINE, STATO, TOTALE, EMAIL) VALUES ("+id+","+stato+" "+cart.getTotale()+", "+user.getEmail()+", "+data+")";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
			preparedStatement.executeQuery();
			
			
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
