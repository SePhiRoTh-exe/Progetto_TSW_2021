package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

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
	
	public static synchronized void doSave(Ordine ordine) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		
		//formatto la data da inserire nei dati dell ordine
		Date now = new Date();
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat formato = new SimpleDateFormat(pattern);
		String data = formato.format(now);
		
		//Salvo gli ordini nel DB
		String insertSQL="INSERT INTO "+TABLE_NAME+" (IDORDINE, STATO, TOTALE, EMAIL, DATA) VALUES ("+ordine.getNumeroOrdine()+", "+ordine.getTotale()+", "+ordine.getUtente().getEmail()+", "+data+")";
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
		ProdottoOrdineDS.doSave(ordine);
	}
	private final static String TABLE_NAME="order";
	private static DataSource ds;
}
