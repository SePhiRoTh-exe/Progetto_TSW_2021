package model;

public class MetodoPagamentoBean {
	public MetodoPagamentoBean(int numeroCarta,String tipo,String scadenza,int cvv,String nome,String cognome,String email) {
		this.numeroCarta=numeroCarta;
		this.tipo=tipo;
		this.scadenza=scadenza;
		this.cvv=cvv;
		this.nome=nome;
		this.cognome=cognome;
		this.email=email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getScadenza() {
		return scadenza;
	}
	public void setScadenza(String scadenza) {
		this.scadenza = scadenza;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumeroCarta() {
		return numeroCarta;
	}
	public void setNumeroCarta(int numeroCarta) {
		this.numeroCarta = numeroCarta;
	}
	public int getCvv() {
		return cvv;
	}
	public void setCvv(int cvv) {
		this.cvv = cvv;
	}
	private String nome,cognome,tipo,scadenza,email;
	private int numeroCarta,cvv;
}
