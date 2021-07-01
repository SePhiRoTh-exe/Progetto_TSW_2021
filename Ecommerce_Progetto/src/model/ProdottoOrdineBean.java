package model;

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
	private float prezzo,iva;
	private int quantitaAcquistata,codiceProdotto;
	private long idOrdine;
}
