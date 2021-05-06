package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	public Carrello() {
		prodotti=new ArrayList<ProdottoBean>();
	}
	public void addProdotto(ProdottoBean prodotto) {
		for(ProdottoBean pr: prodotti) {
			if(pr.getCodice()==prodotto.getCodice())
			{
				pr.setQuantita(pr.getQuantita()+1);
				return;
			}
		}
		prodotti.add(prodotto);
	}
	public void deleteProdotto(ProdottoBean prodotto) {
		//elimino il prodotto nel carrello tramite codice identificativo
		for(ProdottoBean pr:prodotti) {
			if(pr.getCodice()==prodotto.getCodice())
			{
				prodotti.remove(prodotto);
				break;
			}
		}
	}
	public List<ProdottoBean> getProdotti(){
		return prodotti;
	}
	private List<ProdottoBean> prodotti;
}
