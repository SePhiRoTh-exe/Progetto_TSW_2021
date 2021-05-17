package model;

import java.util.ArrayList;
import java.util.List;

public class Carrello {
	public Carrello() {
		prodotti=new ArrayList<ProdottoCarrello>();
	}
	public void addProdotto(ProdottoBean prodotto) {
		for(ProdottoCarrello pr: prodotti) {
			if(pr.getProduct().getCodice()==prodotto.getCodice())
			{
				pr.setQuantità(pr.getQuantità()+1);
				return;
			}
		}
		ProdottoCarrello product = new ProdottoCarrello(prodotto,1);
		prodotti.add(product);
	}
	public void deleteProdotto(ProdottoBean prodotto) {
		//elimino il prodotto nel carrello tramite codice identificativo
		for(ProdottoCarrello pr:prodotti) {
			if(pr.getProduct().getCodice()==prodotto.getCodice())
			{
				prodotti.remove(pr);
				break;
			}
		}
	}
	public float getTotale() {
		float totale=0;
		for (ProdottoCarrello pr: prodotti) {
			totale+=pr.getProduct().getPrezzo()*pr.getQuantità();
		}
		return totale;
	}
	public List<ProdottoCarrello> getProdotti(){
		return prodotti;
	}
	private List<ProdottoCarrello> prodotti;
}
