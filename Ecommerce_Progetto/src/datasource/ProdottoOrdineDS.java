package datasource;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Ordine;
import model.ProdottoCarrello;
import model.ProdottoOrdineBean;

public class ProdottoOrdineDS {
	static {
		try {
			Context initCtx=new InitialContext();
			Context envCtx=(Context) initCtx.lookup("java:comp/env");
			ds=(DataSource) envCtx.lookup("jdbc/storage");
		}catch(NamingException e) {
			System.out.println("Errore:" + e.getMessage());
		}
	}
	
	public static synchronized boolean doSave(List<ProdottoCarrello> list, int id) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try {
			connection=ds.getConnection();
			for(ProdottoCarrello bean:list) {
				String insertSQL="INSERT INTO "+TABLE_NAME+"(PREZZO, IVA, QUANTITA, CODE, IDORDINE) VALUES ("+bean.getQuantità()*bean.getProduct().getPrezzo()+", "+20+", "+bean.getQuantità()+", "+bean.getProduct().getCodice()+", "+id+")";
				preparedStatement=connection.prepareStatement(insertSQL);
				preparedStatement.executeUpdate();
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
		return true;
	}
	private final static String TABLE_NAME="product_order";
	private static DataSource ds;
}
