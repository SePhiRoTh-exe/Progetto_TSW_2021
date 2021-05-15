package model;

import java.util.ArrayList;


public class Ordine {
	
	
	private long numeroOrdine;
	private float totale;
	private String stto;
	private UserBean utente;
	private ArrayList<ProdottoBean> prodotti;

	public Ordine(long numeroOrdine, float totale, String stato, UserBean utente,
			ArrayList<ProdottoBean> prodotti) {
		
		this.numeroOrdine = numeroOrdine;
		this.totale = totale;
		this.stato = stato;
		this.utente = utente;
		this.prodotti = prodotti;
	}


	public long getNumeroOrdine() {
		return numeroOrdine;
	}

	public void setNumeroOrdine(long numeroOrdine) {
		this.numeroOrdine = numeroOrdine;
	}

	public float getTotale() {
		return totale;
	}

	public void setTotale(float totale) {
		this.totale = totale;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public UserBean getUtente() {
		return utente;
	}

	public void setUtente(UserBean utente) {
		this.utente = utente;
	}

	public ArrayList<ProdottoBean> getProdotti() {
		return prodotti;
	}

	public void setProdotti(ArrayList<ProdottoBean> prodotti) {
		this.prodotti = prodotti;
	}
	
	@Override
	public String toString() {
		return "Ordine [numeroOrdine=" + numeroOrdine + ", totale=" + totale + ", stato=" + stato + ", utente=" + utente
				+ ", prodotti=" + prodotti + "]";
	}

}
