package model;

import java.sql.SQLException;
import java.util.Collection;

public interface ProdottoModel {
	public ProdottoBean doRetrieveByKey(int codice) throws SQLException;
	public Collection<ProdottoBean> doRetrieveAll(String ordine) throws SQLException;
}
