package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.MetodoPagamentoBean;

public class MetodoPagamentoModelDS {
	static {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			ds=(DataSource) envCtx.lookup("jdbc/storage");
		}catch(NamingException e){
			System.out.println("Errore:" + e.getMessage());
		}
	}
	/* 
	 * Creato come collection perche un utente puo avere piu metodi di pagamento salvati 
	 * sceglie poi quale usare
	 */
	public static synchronized Collection<MetodoPagamentoBean> doRetrieve(String email) throws SQLException{
		Collection<MetodoPagamentoBean> metodiPagamento=new ArrayList<MetodoPagamentoBean>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String selectSQL="SELECT * FROM "+TABLE_NAME+" WHERE EMAIL ='"+email+"'";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			rs=preparedStatement.executeQuery(selectSQL);
			while(rs.next())
			{
				metodiPagamento.add(new MetodoPagamentoBean(rs.getInt("NUMEROCARTA"),rs.getString("TIPO"),rs.getString("SCADENZA"),rs.getInt("CVV"),rs.getString("NOME"),rs.getString("COGNOME"),rs.getString("EMAIL")));
			}
		}finally {
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
		return metodiPagamento;
	}
	/* Il parametro email è quello dell utente che sta salvando il metodo e puo avere
	 * piu metodi di pagamento salvati un utente.....l email la prendiamo dall utente salvato in sessione*/
	public static synchronized boolean doSave(MetodoPagamentoBean metodoPagamento,String email) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String insertSQL="INSERT INTO STORAGE."+TABLE_NAME+"(NUMEROCARTA, TIPO, SCADENZA, CVV, NOME, COGNOME, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?)";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, metodoPagamento.getNumeroCarta());
			preparedStatement.setString(2, metodoPagamento.getTipo());
			preparedStatement.setString(3, metodoPagamento.getScadenza());
			preparedStatement.setInt(4, metodoPagamento.getCvv());
			preparedStatement.setString(5, metodoPagamento.getNome());
			preparedStatement.setString(6, metodoPagamento.getCognome());
			preparedStatement.setString(7, email);
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
	return true;
	}
	private final static String TABLE_NAME="payment_method";
	private static DataSource ds;
	private static ResultSet rs;
}
