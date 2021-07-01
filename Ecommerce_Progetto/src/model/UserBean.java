package model;

public class UserBean {
	
	public UserBean() {
		
	}
	public UserBean(String nome, String cognome, String username, String password, String email, String paymentMethod
			) {
		this.nome = nome;
		this.cognome = cognome;
		this.username = username;
		this.password = password;
		this.email = email;
		this.paymentMethod = paymentMethod;
		this.admin=false;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getCognome() {
		return this.cognome;
	}
	public void setCognome(String cognome) {
		this.cognome=cognome;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	public String getUsername() {
		return this.username;
	}
	public void setUsername(String username) {
		this.username=username;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid=valid;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public void setAdmin(boolean value) {
		this.admin=value;
	}
	public boolean isAdmin() {
		return admin;
	}
	private String nome,cognome,username,password,email,paymentMethod;
	public boolean valid,admin;
}
