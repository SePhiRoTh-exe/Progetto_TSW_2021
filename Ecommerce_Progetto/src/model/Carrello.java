package model;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import datasource.ProdottoModelDS;

public class Carrello {
	public Carrello() {
		prodotti=new ArrayList<ProdottoCarrello>();
		totale=0;
	}
	public float returnTotale() {
		return totale;
	}
	public boolean addProdotto(int idProd) throws SQLException {
		ProdottoModelDS productds=new ProdottoModelDS();
		ProdottoBean p=productds.doRetrieveByKey(idProd);
		
		for(ProdottoCarrello pr: prodotti) {
			if(pr.getProduct().getCodice()==p.getCodice() && pr.getProduct().getQuantita()+1 < p.getQuantita())
			{
				pr.setQuantità(pr.getQuantità()+1);
				this.getTotale();
				return true;
			}
		}
		ProdottoCarrello product = new ProdottoCarrello(p,1);
		prodotti.add(product);
		this.getTotale();
		return true;
	}
	public boolean modQuantità(int idProd, int quantita) {
		
		try {
			if (!checkQuantity(idProd, quantita)) return false;
			
			ProdottoModelDS productds=new ProdottoModelDS();
			ProdottoBean p=productds.doRetrieveByKey(idProd);
			
			int pos=this.isInCart(p);
			prodotti.get(pos).setQuantità(prodotti.get(pos).getQuantità() + quantita);
			if(prodotti.get(pos).getQuantità()==0) {
				this.deleteProdotto(p);
			}
			this.getTotale();
			return true;
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return true;	
	}
	
	public boolean checkQuantity(int idProd, int quantita) throws SQLException {
		ProdottoModelDS productds=new ProdottoModelDS();
		ProdottoBean p=productds.doRetrieveByKey(idProd);
		
		int pos=this.isInCart(p);
		int quantitadesiderata=quantita;
		if(pos>0) quantitadesiderata+=prodotti.get(pos).getQuantità();
		
		if(quantitadesiderata>p.getQuantita()) return false;
		return true;
	}
	public void deleteProdotto(ProdottoBean prodotto) {
		//elimino il prodotto nel carrello tramite codice identificativo
		for(ProdottoCarrello pr:prodotti) {
			if(pr.getProduct().getCodice()==prodotto.getCodice())
			{
				prodotti.remove(pr);
				this.getTotale();
				break;
			}
		}
	}
	
	public int isInCart(ProdottoBean p) {
		if(prodotti.size()<1) return -1;
		for(int i=0;i<prodotti.size();i++) {
			if(prodotti.get(i).getProduct().getCodice()==p.getCodice())
				return i;
		}
		return -1;
	}
	public boolean isEmpty() {
		if(prodotti.size()==0) {
			return true;
		}
		return false;
	}
	public void getTotale() {
		float prezzo=0;
		for (ProdottoCarrello pr: prodotti) {
			prezzo+=pr.getProduct().getPrezzo()*pr.getQuantità();
		}
		totale=prezzo;
	}
	public ArrayList<ProdottoCarrello> getProdotti(){
		return (ArrayList<ProdottoCarrello>) prodotti;
	}
	private List<ProdottoCarrello> prodotti;
	private float totale;
}
