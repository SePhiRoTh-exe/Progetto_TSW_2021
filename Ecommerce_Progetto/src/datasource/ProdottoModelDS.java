package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
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
	public synchronized Collection<ProdottoBean> doRetrieveByCat(String categoria) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<ProdottoBean> prodotti=new ArrayList<ProdottoBean>();
		ProdottoBean bean=new ProdottoBean();
		String selectSQL="SELECT * FROM "+ProdottoModelDS.TABLE_NAME+" WHERE CATEGORIA = ?";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			//da modificare!!!
			preparedStatement.setString(1, categoria);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setCodice(rs.getInt("CODE"));
				bean.setNome(rs.getString("NAME"));
				bean.setDescrizione(rs.getString("DESCRIPTION"));
				bean.setPrezzo(rs.getInt("PRICE"));
				bean.setQuantita(rs.getInt("QUANTITY"));
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
				prodotti.add(bean);
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
		return prodotti;
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
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
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
	
	public synchronized Collection<ProdottoBean> doRetrieveByName(String nome) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<ProdottoBean> prodotti=new ArrayList<ProdottoBean>();
		ProdottoBean bean=new ProdottoBean();
		String selectSQL="SELECT * FROM "+ProdottoModelDS.TABLE_NAME+" WHERE NAME = ?";
		try {
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			preparedStatement.setString(2, nome);
			ResultSet rs=preparedStatement.executeQuery();
			while(rs.next()) {
				bean.setCodice(rs.getInt("CODE"));
				bean.setNome(rs.getString("NAME"));
				bean.setDescrizione(rs.getString("DESCRIPTION"));
				bean.setPrezzo(rs.getInt("PRICE"));
				bean.setQuantita(rs.getInt("QUANTITY"));
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
				prodotti.add(bean);
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
		return prodotti;
	}
	
	public synchronized Collection<ProdottoBean> doRetrieveAllProducts() throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		Collection<ProdottoBean> prodotti=new LinkedList<ProdottoBean>();
		String selectSQL="SELECT * FROM "+ProdottoModelDS.TABLE_NAME;
		
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
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
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
	
	
	//Metodo per restiturire i prodotti di un ordine
	public synchronized static ArrayList<ProdottoBean> doRetrieveById(long id) throws SQLException{
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ArrayList<ProdottoBean> prodotti=new ArrayList<ProdottoBean>();
		String selectSQL="select * from storage.order, product, product_order where order.idOrdine = '"+id+"'\r\n"
				+ "and product_order.idOrdine= order.idOrdine\r\n"
				+ "and product.Code= product_order.Code";
		try {
			//Mi connetto al database e passo la select
			connection=ds.getConnection();
			preparedStatement=connection.prepareStatement(selectSQL);
			//Nel result saranno contenuti tutti i prodotti acquistati con uno specifico ordine
			ResultSet rs=preparedStatement.executeQuery();
			//Scorro tutto result e creo un bean per ogni prodotto e lo aggiungo ai prodotti
			while(rs.next()) {
				ProdottoBean bean=new ProdottoBean();
				bean.setCodice(rs.getInt("CODE"));
				bean.setNome(rs.getString("NAME"));
				bean.setDescrizione(rs.getString("DESCRIPTION"));
				bean.setPrezzo(rs.getInt("PREZZO"));
				bean.setQuantita(rs.getInt("QUANTITA"));
				bean.setCategoria(rs.getString("CATEGORIA"));
				bean.setPiattaforma(rs.getString("PIATTAFORMA"));
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
