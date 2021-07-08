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
	public void setPiattaforma(String piattaforma) {
		this.piattaforma=piattaforma;
	}
	public String getPiattaforma() {
		return piattaforma;
	}
	public void setCategoria(String categoria) {
		this.categoria=categoria;
	}
	public String getCategoria() {
		return categoria;
	}
	@Override
	public String toString() {
		return nome + " (" + codice + "), " + prezzo + " " + quantita + ". " + descrizione;
	}
	
	int codice;
	String nome;
	String descrizione;
	String piattaforma;
	String categoria;
	int prezzo;
	int quantita;
}
