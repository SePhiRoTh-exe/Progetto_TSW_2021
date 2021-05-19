package model;

import java.io.Serializable;

public class ProdottoBean implements Serializable{
	private static final long serialVersionUID=1L;
	public ProdottoBean() {
		codice=-1;
		nome="";
		descrizione="";
		quantita=0;
	}
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice=codice;
	}
	public int getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(int prezzo) {
		this.prezzo=prezzo;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita=quantita;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione=descrizione;
	}
	@Override
	public String toString() {
		return nome + " (" + codice + "), " + prezzo + " " + quantita + ". " + descrizione;
	}
	int codice;
	String nome;
	String descrizione;
	int prezzo;
	int quantita;
}
