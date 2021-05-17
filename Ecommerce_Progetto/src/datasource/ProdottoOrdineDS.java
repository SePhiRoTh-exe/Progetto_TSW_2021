package datasource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.Ordine;
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
	
	public static synchronized void doSave(Ordine ordine) throws SQLException {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ArrayList<ProdottoOrdineBean> lista=new ProdottoOrdineBean().prodotti(ordine);
		try {
			connection=ds.getConnection();
			for(ProdottoOrdineBean bean:lista) {
				String insertSQL="INSERT INTO "+TABLE_NAME+"(PREZZO, IVA, QUANTITA, CODE, IDORDINE) VALUES ("+bean.getPrezzo()+", "+bean.getIva()+", "+bean.getQuantita()+", "+bean.getCodice()+", "+bean.getID()+")";
				preparedStatement=connection.prepareStatement(insertSQL);
				preparedStatement.executeQuery();
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
	}
	private final static String TABLE_NAME="product_order";
	private static DataSource ds;
}
