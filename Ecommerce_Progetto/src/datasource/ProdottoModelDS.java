package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.ProdottoBean;

public class ProdottoModelDS implements ProdottoModel{
	static {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			ds=(DataSource) envCtx.lookup("jdbc/storage");
		}catch(NamingException e){
			System.out.println("Errore:" + e.getMessage());
		}
	}
	@Override
	public synchronized ProdottoBean doRetrieveByKey(int codice) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ProdottoBean bean=new ProdottoBean();
		String selectSQL="SELECT * FROM "+ProdottoModelDS.TABLE_NAME+" WHERE CODE = ?";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, codice);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setCodice(rs.getInt("CODE"));
				bean.setNome(rs.getString("NAME"));
				bean.setDescrizione(rs.getString("DESCRIPTION"));
				bean.setPrezzo(rs.getInt("PRICE"));
				bean.setQuantita(rs.getInt("QUANTITY"));
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
		return bean;
	}

	@Override
	public synchronized Collection<ProdottoBean> doRetrieveAll(String ordine) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<ProdottoBean> prodotti=new LinkedList<ProdottoBean>();
		String selectSQL="SELECT * FROM "+ProdottoModelDS.TABLE_NAME;
		if(ordine!=null && !ordine.equals("")) {
			selectSQL+=" ORDER BY "+ordine;
		}
		try {
			//Mi connetto al database e passo la select
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			//Nel result sara contenuto l intero catalogo
			ResultSet rs=preparedStatement.executeQuery();
			//Scorro tutto result e creo un bean per ogni prodotto e lo aggiungo ai prodotti
			while(rs.next()) {
				ProdottoBean bean=new ProdottoBean();
				bean.setCodice(rs.getInt("CODE"));
				bean.setNome(rs.getString("NAME"));
				bean.setDescrizione(rs.getString("DESCRIPTION"));
				bean.setPrezzo(rs.getInt("PRICE"));
				bean.setQuantita(rs.getInt("QUANTITY"));
				prodotti.add(bean);
			}
		}finally {//chiudo statement e connessione se aperte
			try {
				if(preparedStatement!=null)
					preparedStatement.close();
			}finally {
				if(connection!=null)
					connection.close();
			}
		}
		return prodotti;
	}
	private final static String TABLE_NAME="product";
	private static DataSource ds;
}
