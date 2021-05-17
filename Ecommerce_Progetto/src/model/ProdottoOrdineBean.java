package model;

import java.util.ArrayList;

public class ProdottoOrdineBean {
	public ProdottoOrdineBean() {}
	
	public void setPrezzo(float prezzo) {
		this.prezzo=prezzo;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setIva(float iva) {
		this.iva=iva;
	}
	public float getIva() {
		return iva;
	}
	public void setQuantita(int quantitaAcquistata) {
		this.quantitaAcquistata=quantitaAcquistata;
	}
	public int getQuantita() {
		return quantitaAcquistata;
	}
	public void setCodice(int codiceProdotto) {
		this.codiceProdotto=codiceProdotto;
	}
	public int getCodice() {
		return codiceProdotto;
	}
	public void setID(long idOrdine) {
		this.idOrdine=idOrdine;
	}
	public long getID() {
		return idOrdine;
	}
	//metodo per prendere i prodotti da un ordine e convertirli i prodotti ordinati
	public ArrayList<ProdottoOrdineBean> prodotti(Ordine ordine) {
		ArrayList<ProdottoOrdineBean> prodottiOrdine=new ArrayList<ProdottoOrdineBean>();
		ArrayList<ProdottoBean> lista=ordine.getProdotti();
		for(ProdottoBean prodotto:lista) {
			ProdottoOrdineBean bean=new ProdottoOrdineBean();
			bean.setCodice(prodotto.getCodice());
			bean.setID(ordine.getNumeroOrdine());
			bean.setIva(22);
			bean.setPrezzo(prodotto.getPrezzo());
			bean.setQuantita(prodotto.quantitaCarrello);
			prodottiOrdine.add(bean);
		}
		return prodottiOrdine;
	}
	private float prezzo,iva;
	private int quantitaAcquistata,codiceProdotto;
	private long idOrdine;
}
